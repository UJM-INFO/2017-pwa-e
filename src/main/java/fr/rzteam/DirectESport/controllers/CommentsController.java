package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Comment;
import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.RequestComment;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;

import org.springframework.ui.Model;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentsController
{
    @Inject
    EventRepository eventRepo;
    
    @Inject
    UserRepository userRepo;
    
    @Inject
    TeamRepository teamRepo;
    
    //WEBSOCKET
    
    /**
     *  When we receive a adding signal of a comment, we request to all websocket to update
     * @param request adding signal from client who add a comment
     * @return a signal to all active websocket
     */
    @MessageMapping("/update")
    @SendTo("/topic/comments")
    public String updateAllWebsocketClient(RequestComment request)
    {
        return "";
    }
    
    //HTTP
    @RequestMapping(value ="/add_comment", method = RequestMethod.POST )
    public String save(
    @RequestParam("text") String text,
    @RequestParam("id") String id)
    {
	Long idlong = Long.parseLong(id);
	String name = SecurityContextHolder.getContext().getAuthentication().getName();
	User user = userRepo.findByUserName(name);
	Event e = eventRepo.findOneById(idlong);
	    e.getComments().add(new Comment(text,user));
	    eventRepo.save(e);
	return "redirect:/comment";
    }
    
    @RequestMapping("/comment")
    public String comment(@RequestParam(value="id", required=false) String id, Model m)
    {
        //If the id is set and valid we display this event, otherwise we display the event menu
        try
        {
            if("undefined".equals(id) || eventRepo.findOneById(Long.parseLong(id))==null)
            {
                List<Event> list = eventRepo.findAll();
                m.addAttribute("events",list);
                return "eventMenu";
            }
        }
        catch(NumberFormatException | NullPointerException e)
        { 
            List<Event> list = eventRepo.findAll();
            m.addAttribute("events",list);
            return "eventMenu";
        }
	m.addAttribute("id",id);
        return "comment";
    }  
    
    @RequestMapping(value = "/add_event", method = RequestMethod.POST)
    public String addEvent(
            @RequestParam("event_name") String eventName,
            @RequestParam("description") String description,
            @RequestParam("team1") String team1name,
            @RequestParam("team2") String team2name)            
    {
    /*    System.out.println("PASS = "+oldPassword+" "+newPassword+" "+repeatNewPassword);
        
        if( !"undefined".equals(oldPassword))
        {
            System.out.println("OK");
        }*/
        
        List<Team> team1 = teamRepo.findManyByTeamName(team1name);
        List<Team> team2 = teamRepo.findManyByTeamName(team2name);
        
        if(team1.isEmpty())
        {
            teamRepo.save(new Team(team1name, new Date(), "history", new HashMap<>()));
            team1 = teamRepo.findManyByTeamName(team1name);
        }
            
        if(team2.isEmpty())
        {
            teamRepo.save(new Team(team2name, new Date(), "history", new HashMap<>()));
            team2 = teamRepo.findManyByTeamName(team2name);
        }
        
        eventRepo.save(new Event(eventName, description, new Date(), team1.get(0), team2.get(0), 0));
        
        return "redirect:/comment";
    }
}
