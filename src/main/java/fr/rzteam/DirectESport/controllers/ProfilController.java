    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.User;

import fr.rzteam.DirectESport.model.UserService;
import fr.rzteam.DirectESport.model.UserRepository;
import javax.inject.Inject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Inject
	UserRepository userRepo;
	@Inject
    UserService userService;
	
    public boolean isConnected()
    {
        return (SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
    }
    
    @RequestMapping("/profil")
    public String profil(Model m)
    {
		if (!isConnected())
			return "homeNotSignedIn";
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepo.findByUserName(name);
		
		m.addAttribute("u", u);
		
		return "profil";
    }    
    
    @RequestMapping(value = "/passwordChanging", method = RequestMethod.POST)
    public String passwordChanging(
            @RequestParam("newPassword") String newPassword,
            @RequestParam("repeatNewPassword") String repeatNewPassword,
			Model m)
    {
        if( !"undefined".equals(newPassword) &&
            !"undefined".equals(repeatNewPassword))
        {
			if (newPassword.equals(repeatNewPassword))
			{
				String name = SecurityContextHolder.getContext().getAuthentication().getName();
				if (userService.changeUserPassword(name, newPassword) == 1)
				{
					m.addAttribute("success", "Mot de passe modifié avec succès");
				}
				else 
				{
					m.addAttribute("error", "Votre mot de passe n'a pas été changé");	
				}
			}
			else
			{
				m.addAttribute("error", "Les mots de passe sont différents");
			}
        }
        return "forward:/profil";
    }
}
