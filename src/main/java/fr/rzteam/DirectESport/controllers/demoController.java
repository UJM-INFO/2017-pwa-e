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

import fr.rzteam.DirectESport.mdparser.Markdown;
import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.EventRepository;
import fr.rzteam.DirectESport.model.UserRepository;
import javax.inject.Inject;
import fr.rzteam.DirectESport.model.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import fr.rzteam.DirectESport.mdparser.Markdown;
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
    @Inject
    ArticleRepository articleRepo;
    @Inject
    PlayerRepository playerRepo;
    
    /**
     * Demo data
     */
    @RequestMapping("/demo")
    public String demo()
    {        
        User user1 = new User("admin", "Administrateur", "$2a$10$cGONBnlF98pG2tLYV5GcfODgvLEbeMlRm1z/4yjpG.pRQ4SoP8nd6"/*=pass*/, "admin@rzteam.fr");
        userRepo.save(user1);
//        Team team1 = new Team("Fnatic", new Date(), "history", new HashMap<String,Integer>());
//       Team team2 = new Team("SKT", new Date(), "history", new HashMap<String,Integer>());
//      eventRepo.save(new Event("Dreamhack LoL Final", "Description de ouf", new Date(), team1, team2, 0));
//        teamRepo.save(team1);
//        teamRepo.save(team2);
//        
//        List<Event> listEvent = eventRepo.findAll();
//        listEvent.get(0).getComments().add(new Comment("Commentaire de ouf", user1, new Date()));
//        eventRepo.save(listEvent);
        Article a1 = new Article("Titre de l'article","Pas d'idée ...");
        Article a2 = new Article("Qui va gagner le trophée des pineur ?", "La compétition est enfin lancée ! Qui de Pineur Alpha, pinoir, puneur, pineur escalier ou encore Malaise Man va remporter le titre ?");
        Article a3 = new Article("Clément, petite pute ?", "La question que tout le monde se pose. Clément Colin, appelé familièrement Petite Pute, aurait démenti toute forme de prostitution. Affaire à suivre...");
        Article a4 = new Article("Christopher remporte le prix du meilleur maçon !", "Sa famille était réunie. José, Manuel, Rui, tout trois chemise ouverte sur leur torse poilu, la larme à l'oeil quand leur petit frère souleva le parpaings en or, synonyme de meilleur maçon de la région. Quel beau moment d'émotion...");
        articleRepo.save(a1);
        articleRepo.save(a2);
        articleRepo.save(a3);
        articleRepo.save(a4);
        
        Player p1 = new Player("Clément", PlayerRole.Jungle, 20, "Zelda", "Surnomé petite pute dès son plus jeune age, bla bla bla");
        Player p2 = new Player("Chris", PlayerRole.Top, 21, "La truelle", "Rageux parmi les rageux, il n'hésite pas à quitter une partie lorsqu'elle tourne en sa défaveur.");
        Player p3 = new Player("Dimitri", PlayerRole.Coach, 21, "Zizou", "Le meilleur joueur de tous les temps");
	Player p4 = new Player("Paul", PlayerRole.Support, 20, "vim", "Emacs était trop évolué");
	Player p5 = new Player("Guillaume", PlayerRole.ADC, 21, "Jus de fruit de la passion", "La plus grosse trompe de Bamoko");
	Player p6 = new Player("Lucas", PlayerRole.Mid, 21, "Lose", "L'homme le plus chiant du monde");
	Player p7 = new Player("Hugo", PlayerRole.Support, 24, "La classe", "L'homme le plus stylè");
	
	playerRepo.save(p1);
        playerRepo.save(p2);
        playerRepo.save(p3);
	playerRepo.save(p4);
	playerRepo.save(p5);
	playerRepo.save(p6);
	playerRepo.save(p7);
        
        
        return "redirect:/home";
    }
    
}
