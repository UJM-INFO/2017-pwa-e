/*
 *      _____   _                   _            _____                      _   
 *     |  __ \ (_) Website Project | |          / ____|                    | |  
 *     | |  | | _  _ __  ___   ___ | |_    ___ | (___   _ __    ___   _ __ | |_ 
 *     | |  | || || '__|/ _ \ / __|| __|  / _ \ \___ \ | '_ \  / _ \ | '__|| __|
 *     | |__| || || |  |  __/| (__ | |_  |  __/ ____) || |_) || (_) || |   | |_ 
 *     |_____/ |_||_|   \___| \___| \__|  \___||_____/ | .__/  \___/ |_|    \__|
 *                                                     | |                                                                                              
 *  ----Authors----                                    |_| 
 * Dimitri BRUYERE
 * Clément COLIN
 * Christopher JEAMME
 *  ---------------
 */

package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Comment;
import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.RequestComment;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;

import org.springframework.ui.Model;
import java.util.List;
import javax.inject.Inject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for event's comments operations
 */
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

    /**
     * Receiving the order to add a comment to an event
     * @param text Text of the comment
     * @param id Id of the event we want to add a comment
     * @return
     */
    @RequestMapping(value ="/add_comment", method = RequestMethod.POST)
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
	return "redirect:/event?id="+id;
    }
}
