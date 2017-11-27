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
        m.addAttribute("events",eventRepo.findAllByCompetitionID(Long.parseLong(id+"")));
        return "competition";
    }
	
    @RequestMapping(value = "/add_competition", method = RequestMethod.POST)
    public String addCompetition(@RequestParam("name") String name)            
    {
        Competition competition = new Competition(new Date(), name);
        
        competitionRepo.save(competition);
        
        return "redirect:/competition";
    }
	
	@RequestMapping(value = "/remove_competition", method = RequestMethod.POST)
	public String removeCompetition(@RequestParam("id") String id)
	{
            Long idLong = Long.parseLong(id);
            competitionRepo.deleteOneById(idLong);
            return "redirect:/competition";
	}
}
