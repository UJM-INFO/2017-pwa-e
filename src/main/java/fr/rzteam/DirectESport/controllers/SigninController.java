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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to signin page / operation
 */
@Controller
public class SigninController
{

    /**
     * Request of signin
     * @return The template "signin"
     */
    @RequestMapping("/signin")
    public String signIn()
    {
        return "signin";
    }
    
    /**
     * Method for Spring Security
     * @return
     */
    @RequestMapping("appLogin")
    public String setSession()
    {
        return "";
    }
}
