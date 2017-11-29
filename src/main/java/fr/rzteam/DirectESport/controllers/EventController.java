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

import fr.rzteam.DirectESport.model.Event;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.Stats;
import fr.rzteam.DirectESport.model.StatsRepository;
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
 * Controller for event page and operations
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
    
    @Inject
    StatsRepository statsRepo;
	
    /**
     *
     * @param description
     * @param team1id
     * @param team2id
     * @param type
     * @param idCompetition
     * @return
     */
    @RequestMapping(value = "/add_event", method = RequestMethod.POST)
    public String addEvent(
            @RequestParam("description") String description,
            @RequestParam("team1") String team1id,
            @RequestParam("team2") String team2id,
            @RequestParam("type") String type,
            @RequestParam("idCompetition") String idCompetition)
    {
        description = InputDataVerification.escape(description);
        if (InputDataVerification.verifTextLength(description, 1, 255))
        {
            int typel = Integer.parseInt(type);
            Team team1 = teamRepo.findOneById(Long.parseLong(team1id + ""));
            Team team2 = teamRepo.findOneById(Long.parseLong(team2id + ""));

            Stats stats1 = new Stats();
            Stats stats2 = new Stats();
            statsRepo.save(stats1);
            statsRepo.save(stats2);

            Long idCompetLong = Long.parseLong(idCompetition);
            Event e = new Event(description, new Date(), team1, team2, 0,typel,stats1,stats2,idCompetLong);

            eventRepo.save(e);
            
        }
        return "redirect:/event";
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/remove_event", method = RequestMethod.POST)
    public String removeEvent(@RequestParam("id") String id)
    {
        Long idLong = Long.parseLong(id);
        eventRepo.deleteOneById(idLong);
        return "redirect:/event";
    }
    
    /**
     * We redirect to the event page if the id is set, otherwise we redirect to the event menu
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("/event")
    public String event(@RequestParam(value="id", required=false) String id, Model m)
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
        return "event";
    }  
    
}
