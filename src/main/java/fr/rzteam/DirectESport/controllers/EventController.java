/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class EventController
{
	
	@Inject
    EventRepository eventRepo;
    
    @Inject
    UserRepository userRepo;
    
    @Inject
    TeamRepository teamRepo;
	
	
    @RequestMapping(value = "/add_event", method = RequestMethod.POST)
    public String addEvent(
            @RequestParam("description") String description,
            @RequestParam("team1") String team1name,
            @RequestParam("team2") String team2name)            
    {
        
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
        
        eventRepo.save(new Event(description, new Date(), team1.get(0), team2.get(0), 0));
        
        return "redirect:/comment";
    }
	
	@RequestMapping(value = "/remove_event", method = RequestMethod.POST)
	public String removeEvent(@RequestParam("id") String id)
	{
		Long idLong = Long.parseLong(id);
		eventRepo.deleteOneById(idLong);
		return "eventMenu";
	}
}