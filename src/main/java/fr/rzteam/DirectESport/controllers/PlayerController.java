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

import fr.rzteam.DirectESport.model.Player;
import fr.rzteam.DirectESport.model.PlayerRepository;
import fr.rzteam.DirectESport.model.PlayerRole;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class PlayerController
{
    
    @Inject
    PlayerRepository playerRepo;
    
    @RequestMapping("/add_player")
    public String page
    (
        @RequestParam("playerName") String playerName,
        @RequestParam("playerRole") String playerRole,
        @RequestParam("age") String age,
        @RequestParam("favoriteChampion") String favoriteChampion,
        @RequestParam("history") String history
    )
    {
        Player p = new Player(playerName,"test", PlayerRole.valueOf(playerRole), Integer.parseInt(age), favoriteChampion, history);
        playerRepo.save(p);
        return "view.name";
    }
    
    @RequestMapping("/player")
    public String page(@RequestParam("id") String id, Model m)
    {
        try
        {
            Player p = playerRepo.findOneById(Long.parseLong(id));
            if (p == null)
                return "redirect:/home";
            return "player";
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return "redirect:/home";
        }
    }
    
}
