/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import javax.inject.Inject;
import fr.rzteam.DirectESport.model.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tony
 */
@Controller
public class demoController
{
    @Inject
    UserRepository userRepo;
    @Inject
    EventRepository eventRepo;
    @Inject
    CommentRepository commentRepo;
    @Inject
    TeamRepository teamRepo;
    
    /**
     * Demo data
     */
    @RequestMapping("/demo")
    public String demo()
    {
//        User user1 = new User("admin", "Administrateur", "pass", "admin@rzteam.fr");
//        userRepo.save(user1);
//        Team team1 = new Team("Fnatic", new Date(), "history", new HashMap<String,Integer>());
//        Team team2 = new Team("SKT", new Date(), "history", new HashMap<String,Integer>());
//        eventRepo.save(new Event("Dreamhack LoL Final", "Description de ouf", new Date(), team1, team2, 0));
//        teamRepo.save(team1);
//        teamRepo.save(team2);
//        
//        List<Event> listEvent = eventRepo.findAll();
//        listEvent.get(0).getComments().add(new Comment("Commentaire de ouf", user1, new Date()));
//        eventRepo.save(listEvent);
        
        return "redirect:/home";
    }
    
}
