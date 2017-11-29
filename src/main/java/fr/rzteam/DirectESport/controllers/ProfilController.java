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
 * Controller for profil page and operations
 */
@Controller
public class ProfilController
{

    @Inject
    UserRepository userRepo;
    @Inject
    UserService userService;

    /**
     * Method to know if we are connected (the function integrated didn't work)
     * @return True if we are connected, False if not
     */
    public boolean isConnected()
    {
        return (SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
    }

    /**
     * Request of the profil page
     * @param m The model to exchange data with Thymeleaf
     * @return The template "profil" or "homeNotSignedIn" if we are not connected
     */
    @RequestMapping("/profil")
    public String profil(Model m)
    {
        if (!isConnected())
        {
            return "homeNotSignedIn";
        }

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepo.findByUserName(name);

        m.addAttribute("u", u);

        return "profil";
    }

    /**
     * Request the order to change the password
     * @param newPassword New password
     * @param repeatNewPassword Repeated new password
     * @param m The model to exchange data with Thymeleaf
     * @return Forward to "/profil"
     */
    @RequestMapping(value = "/passwordChanging", method = RequestMethod.POST)
    public String passwordChanging(
            @RequestParam("newPassword") String newPassword,
            @RequestParam("repeatNewPassword") String repeatNewPassword,
            Model m)
    {
        if (!"undefined".equals(newPassword)
                && !"undefined".equals(repeatNewPassword))
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
