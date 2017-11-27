/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.PlayerRepository;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Clement Colin
 */
@Controller
public class TeamController {
    
    @Inject
    TeamRepository teamRepo;
    
    @Inject
    PlayerRepository playerRepo;
    
    @RequestMapping("/team")
    public String teamMenu(@RequestParam(value="id", required=false) String id, Model m)
    {
	try
        {
            if("undefined".equals(id) || teamRepo.findOneById(Long.parseLong(id))==null)
            {
                List<Team> list = teamRepo.findAll();
                m.addAttribute("teams",list);
                return "teamMenu";
            }
        }
        catch(NumberFormatException | NullPointerException e)
        { 
                List<Team> list = teamRepo.findAll();
                m.addAttribute("teams",list);
                return "teamMenu";
        }
	
	m.addAttribute("id",id);
	m.addAttribute("team",teamRepo.findOneById(Long.parseLong(id+"")));
	m.addAttribute("player",teamRepo.findManyById(Long.parseLong(id+"")));
	return "team";
    }
    
    @RequestMapping(value = "/add_team", method = RequestMethod.POST)
    public String addteam(@RequestParam("teamname") String teamname,
			  @RequestParam("history") String history)
    {
    
	Team newteam = new Team(teamname,history);
	
	teamRepo.save(newteam);
	
	return "redirect:/team";
	
    }
    
    
    
}
