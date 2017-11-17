    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chris
 */
@Controller
public class ProfilController
{   
    /**
     * Fonction pour savoir si on est connecté
     * @return vrai si connecté, faux sinon
     */
    public boolean isConnected()
    {
        return (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser");
    }
    
    @RequestMapping("/profil")
    public String profil()
    {
        return "profil";
    }    
    
    @RequestMapping(value = "/passwordChanging", method = RequestMethod.POST)
    public String passwordChanging(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("repeatNewPassword") String repeatNewPassword)            
    {
        System.out.println("PASS = "+oldPassword+" "+newPassword+" "+repeatNewPassword);
        
        if( !"undefined".equals(oldPassword) &&
            !"undefined".equals(newPassword) &&
            !"undefined".equals(repeatNewPassword) )
        {
            System.out.println("OK");
            passwordChanging(oldPassword,newPassword,repeatNewPassword);
        }
        return "profil";
    }
}
