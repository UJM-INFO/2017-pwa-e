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

import fr.rzteam.DirectESport.model.ArticleRepository;
import fr.rzteam.DirectESport.model.Article;
import fr.rzteam.DirectESport.model.UserRepository;

import fr.rzteam.DirectESport.model.UserService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for home pages and intro
 */
@Controller
public class HomeController
{   
    
    @Inject
    UserService userService;
    @Inject
    UserRepository userRepo;
    @Inject
    ArticleRepository articleRepo;
    /**
     * Fonction pour savoir si on est connecté
     * @return vrai si connecté, faux sinon
     */
    public boolean isConnected()
    {
        return (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser");
    }
    
    /**
     * Intro page conroller
     * @return Redirection to intro template
     */
    @RequestMapping("/")
    public String intro()
    {
        return "intro";
    }
    
    /**
     * Redirect to homeSignedIn if we are connected, and homeNotSignedIn if not
     * @param m The model to exchange data with Thymeleaf
     * @return The template "homeSignedIn" or "homeNotSignedIn"
     */
    @RequestMapping("/home")
    public String home(Model m)
    {
        List<Article> articles = articleRepo.findTop3ByOrderByIdDesc();
        
        if (articles.size()==3)
        {
            for (int i=0; i<3 ;i++)
            {
                if (articles.get(i).getText().length()>70)
                    articles.get(i).setText(articles.get(i).getText().substring(0, 70).concat("(...)")); //Only the begining of the text for the carousel
            }
            m.addAttribute("articles", articles);
        }
        return isConnected() ? "homeSignedIn" : "homeNotSignedIn";
    }
}
