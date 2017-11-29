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

import fr.rzteam.DirectESport.model.Competition;
import fr.rzteam.DirectESport.model.CompetitionRepository;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.Team;
import fr.rzteam.DirectESport.model.TeamRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import fr.rzteam.DirectESport.verif.InputDataVerification;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for competition page and operations
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
        
    /**
     * We redirect to the competition page if the id is set, otherwise we redirect to the competition menu
     * @param id Id of the competition we want
     * @param m The model to exchange data with Thymeleaf
     * @return The template "competitionMenu" or "competition"
     */
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
        m.addAttribute("competition",competitionRepo.findOneById(Long.parseLong(id+"")));
	m.addAttribute("teamscompet",competitionRepo.findOneById(Long.parseLong(id+"")).getTeams());
	m.addAttribute("teams",teamRepo.findAll());
        return "competition";
    }
	
    /**
     * Receive the order to add a competition
     * @param name Name of the competition
     * @return A redirection to /competition
     */
    @RequestMapping(value = "/add_competition", method = RequestMethod.POST)
    public String addCompetition(@RequestParam("name") String name)            
    {
        name=InputDataVerification.escape(name);
        
        if (InputDataVerification.verifTextLength(name, 1, 200))
        {
            Competition competition = new Competition(new Date(), name);
            Long id = competition.getId();
            competitionRepo.save(competition);
            
            return "redirect:/competition?id="+id;
        }
        
        return "redirect:/competition";
    }
	
    /**
     * Receive the order to remove a competition
     * @param id Id of the competition
     * @return A redirection to /competition
     */
    @RequestMapping(value = "/remove_competition", method = RequestMethod.POST)
    public String removeCompetition(@RequestParam("id") String id)
    {
        Long idLong = Long.parseLong(id);
        competitionRepo.deleteOneById(idLong);
        return "redirect:/competition";
    }
    
    /**
     * Receive the order to add a team in a competition
     * @param name Name of the team
     * @param idCompetition Id of the competition
     * @return Redirection to /competition
     */
    @RequestMapping(value = "/add_team_in_competition", method = RequestMethod.POST)
    public String addCompetition(
            @RequestParam("idteam") String idteam,
            @RequestParam("id") String id)            
    {
       Team temp = teamRepo.findOneById(Long.parseLong(idteam+""));
       Competition c = competitionRepo.findOneById(Long.parseLong(id+""));
       c.getTeams().add(temp);
       competitionRepo.save(c);
        return "redirect:/competition?id="+id;
    }
}
