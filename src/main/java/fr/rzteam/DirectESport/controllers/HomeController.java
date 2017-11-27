/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.ArticleRepository;
import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.Article;
import fr.rzteam.DirectESport.model.UserRepository;

import fr.rzteam.DirectESport.model.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.extras.springsecurity4.util.SpringSecurityWebApplicationContextUtils;

/**
 *
 * @author chris
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
    
    @RequestMapping("/")
    public String intro()
    {
        return "intro";
    }
    
    @RequestMapping("/home")
    public String home(Model m)
    {
        List<Article> articles = articleRepo.findTop3ByOrderByDateDesc();
        for (int i=0; i<articles.size();i++)
        {
            if (articles.get(i).getText().length()>70)
                articles.get(i).setText(articles.get(i).getText().substring(0, 70).concat("(...)")); //Only the begining of the text for the carousel
        }
        if (articles.size()>2)
            m.addAttribute("articles", articles);
        return isConnected() ? "homeSignedIn" : "homeNotSignedIn";
    }
    
    /**
     * Test websocket
     */
    @RequestMapping("/ws")
    public String ws()
    {
        return "index";
    }

}
