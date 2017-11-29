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
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Clement Colin
 */
@Controller
public class StatsController {
    
    @Inject
    StatsRepository statsRepo;
	
    @Inject
    EventRepository eventRepo;
    
    @RequestMapping(value = "/addkillt1",method = RequestMethod.POST)
    public String addt1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getKill();
	stats.setKill(temp+1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/subkillt1",method = RequestMethod.POST)
    public String subt1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getKill();
	if(temp-1<=0)
	    temp=1;
	stats.setKill(temp-1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
    
        @RequestMapping(value = "/addkillt2",method = RequestMethod.POST)
    public String addt2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getKill();
	stats.setKill(temp+1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
        
	@RequestMapping(value = "/subkillt2",method = RequestMethod.POST)
    public String subt2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getKill();
	if(temp-1<=0)
	    temp=1;
	stats.setKill(temp-1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/subtowert2",method = RequestMethod.POST)
    public String subtowert2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getTower();
	if(temp-1<=0)
	    temp=1;
	stats.setTower(temp-1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/subtowert1",method = RequestMethod.POST)
    public String subtowert1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getTower();
	if(temp-1<=0)
	    temp=1;
	stats.setTower(temp-1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/addtowert1",method = RequestMethod.POST)
    public String addtowert1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getTower();
	stats.setTower(temp+1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/addtowert2",method = RequestMethod.POST)
    public String addtowert2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getTower();
	stats.setTower(temp+1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/adddraket2",method = RequestMethod.POST)
    public String adddraket2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getDrake();
	stats.setDrake(temp+1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/adddraket1",method = RequestMethod.POST)
    public String adddraket1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getDrake();
	stats.setDrake(temp+1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/subdraket1",method = RequestMethod.POST)
    public String subdraket1(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team1();
	int temp = stats.getDrake();
	if(temp-1<=0)
	    temp=1;
	stats.setDrake(temp-1);
	event.setStats_team1(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }
	@RequestMapping(value = "/subdraket2",method = RequestMethod.POST)
    public String subdraket2(@RequestParam("id") String id)
    {
	Event event = eventRepo.findOneById(Long.parseLong(id + ""));
	Stats stats = event.getStats_team2();
	int temp = stats.getDrake();
	if(temp-1<=0)
	    temp=1;
	stats.setDrake(temp-1);
	event.setStats_team2(stats);
	eventRepo.save(event);
	return "redirect:/event?id="+id;
    }

}
