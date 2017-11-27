/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Competition;
import fr.rzteam.DirectESport.model.CompetitionRepository;
import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import java.util.ArrayList;
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
public class CompetitionController
{
	
    @Inject
    CompetitionRepository competitionRepo;
    
    @Inject
    UserRepository userRepo;
    
    @Inject
    TeamRepository teamRepo;
	
    @Inject
    EventRepository eventRepo;
        
    @RequestMapping("/competition")
    public String competitionMenu(@RequestParam(value="id", required=false) String id, Model m)
    {
        List<Team> t = teamRepo.findAll();
        
        competitionRepo.save(new Competition(new Date(), "DreamHack", t));
        //If the id is set and valid we display this event, otherwise we display the event menu
        try
        {
            if("undefined".equals(id) || competitionRepo.findOneById(Long.parseLong(id))==null)
            {
                List<Competition> list = competitionRepo.findAll();
                m.addAttribute("competitions",list);
                return "competitionMenu";
            }
        }
        catch(NumberFormatException | NullPointerException e)
        { 
            List<Competition> list = competitionRepo.findAll();
            m.addAttribute("competitions",list);
            return "competitionMenu";
        }
         
	m.addAttribute("id",id);
        m.addAttribute("events",eventRepo.findAll());//A CHANGER POUR findAllByCompetition()
        return "competition";
    }
	
    @RequestMapping(value = "/add_competition", method = RequestMethod.POST)
    public String addCompetition(
            @RequestParam("description") String description,
            @RequestParam("team1") String team1name,
            @RequestParam("team2") String team2name)            
    {
//        
//        List<Team> team1 = teamRepo.findManyByTeamName(team1name);
//        List<Team> team2 = teamRepo.findManyByTeamName(team2name);
//        
//        if(team1.isEmpty())
//        {
//            teamRepo.save(new Team(team1name, new Date(), "history", new HashMap<>()));
//            team1 = teamRepo.findManyByTeamName(team1name);
//        }
//            
//        if(team2.isEmpty())
//        {
//            teamRepo.save(new Team(team2name, new Date(), "history", new HashMap<>()));
//            team2 = teamRepo.findManyByTeamName(team2name);
//        }
//        
//        eventRepo.save(new Event(description, new Date(), team1.get(0), team2.get(0), 0));
        
        return "redirect:/competition";
    }
	
	@RequestMapping(value = "/remove_competition", method = RequestMethod.POST)
	public String removeCompetition(@RequestParam("id") String id)
	{
//            Long idLong = Long.parseLong(id);
//            eventRepo.deleteOneById(idLong);
            return "redirect:/competition";
	}
}
