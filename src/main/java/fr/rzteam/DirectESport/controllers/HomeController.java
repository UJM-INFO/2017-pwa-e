/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chris
 */
@Controller
public class HomeController
{   
    /**
     * Fonction pour savoir si on est connecté
     * @return vrai si connecté, faux sinon
     */
    public boolean isConnected()
    {
        return (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser");
    }
    
    @RequestMapping("/")
    public String intro()
    {
        //System.out.println("SESSION "+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        
        return "intro";
    }
    
    @RequestMapping("/home")
    public String home()
    {
        return isConnected() ? "homeSignedIn" : "homeNotSignedIn";
    }
    
    @RequestMapping("/test")
    public String test()
    {
        return "test";
    }

}
