/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Article;
import fr.rzteam.DirectESport.model.Player;
import fr.rzteam.DirectESport.model.PlayerRepository;
import fr.rzteam.DirectESport.model.PlayerRole;
import java.util.List;
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
        Player p = new Player(playerName, PlayerRole.valueOf(playerRole), Integer.parseInt(age), favoriteChampion, history);
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
            m.addAttribute("player", p);
            System.out.println(p);
            return "player";
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return "redirect:/home";
        }
    }
    
}
