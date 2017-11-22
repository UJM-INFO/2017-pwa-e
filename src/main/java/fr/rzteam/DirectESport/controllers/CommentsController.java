package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Comment;
import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.RequestComment;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.User;
import org.springframework.ui.Model;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
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
        //FAUDRA METTRE UN SPECIAL POUR LE SIGNAL DE L'UPDATE POUR EVITER LES HACK
               
        /* on demande au model avec request.getId()*/
        //repo.save(new Comment("La boule magique !","MisterMV","19/11/2017 06:38"));
        //CommentSet commentSet= new CommentSet("Evenement "+request.getId(),repo.findAll());
        //commentSet.add(new Comment("Ces commentaires sont ajoutés directement du serveur dans la classe CommentsController","Chris","19/11/2017 06:49"));

        return "";
    }
    
    //HTTP
    @RequestMapping(value ="/add_comment", method = RequestMethod.POST )
    public String save(
    @RequestParam("rid") long id,
    @RequestParam("text") String text,
    @RequestParam("author") String author)
    {

	for (Event e : eventRepo.findAll()){
	    if (e.getId() == id){
		e.getComments().add(new Comment(text,new User()));
		eventRepo.save(e);
	    }
	}
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
                return "redirect:/eventMenu";
            }
        }
        catch(NumberFormatException | NullPointerException e)
        { 
            return "eventMenu"; 
        }

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
        
        //ERREUR A REGLER : LES TEAMS SONT NULLES (LES OBJETS)
        
        //TEAM DE TEST
        teamRepo.save(new Team("a", new Date(), "history", new HashMap<>()));
	teamRepo.save(new Team("b", new Date(), "history", new HashMap<>()));
        
        
        //Saving the event
        
        Team team1 = teamRepo.findOneByTeamName(team1name);
        Team team2 = teamRepo.findOneByTeamName(team2name);
        
        if(team1 != null && team2 != null)
        {
            eventRepo.save(new Event(eventName, description, new Date(), team1, team2, 0));
        }
        else
        {
            System.err.println("Error : Team(s) not found");
        }
        
        return "comment";
    }
}
