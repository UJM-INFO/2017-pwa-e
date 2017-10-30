/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

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
    public boolean isConnected(Model model)
    {
        return false;
    }
    
    @RequestMapping("/")
    public String basic(Model model)
    {
        Boolean login = isConnected(model);
        return login ? "homeSignedIn" : "intro";
    }
    
    @RequestMapping("/home")
    public String home(Model model)
    {
        Boolean login = isConnected(model);
        return login ? "homeSignedIn" : "homeNotSignedIn";
    }
    
    @RequestMapping("/test")
    public String test()
    {
        return "test";
    }

}
