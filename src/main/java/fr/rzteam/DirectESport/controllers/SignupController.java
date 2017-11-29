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
import fr.rzteam.DirectESport.model.UserRepository;
import fr.rzteam.DirectESport.model.UserService;
import fr.rzteam.DirectESport.verif.InputDataVerification;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller to signup
 */
@Controller
public class SignupController
{

    @Inject
    UserService userService;
    @Inject
    UserRepository userRepo;

    /**
     * Request the order to register
     *
     * @param username
     * @param realname
     * @param mail
     * @param password
     * @param password2
     * @param m The model to exchange data with Thymeleaf
     * @return The template "signup"
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String inscription(
            @RequestParam("username") String username,
            @RequestParam("realname") String realname,
            @RequestParam("mail") String mail,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            Model m
    )
    {
	if (password.compareTo(password2) != 0) //The 2 passwords are different
        {
            m.addAttribute("error", "Les mots de passes sont différents");
            return "forward:/signup";
        }
        
        if (!InputDataVerification.verifEmailAddress(mail))
        {
            m.addAttribute("error", "L'adresse e-mail n'est pas valide");
            return "forward:/signup";
        }

        int add = userService.addUser(new User(username, realname, password, mail)); //Try to add the user

        if (add == 1)	//The pseudo is already used
        {
            m.addAttribute("error", "Ce pseudo est déjà utilisé");
            return "forward:/signup";
        }
        if (add == 2)	//The mail is already used
        {
            m.addAttribute("mailExists", "Il y a déjà un compte avec cet email");
            return "forward:/signup";
        }
        m.addAttribute("user", username);
        m.addAttribute("mdp", password);
        return "/signin"; //The user has been correctly added in the database
    }

    /**
     * Request signup
     * @return The template "signup"
     */
    @RequestMapping("/signup")
    public String page()
    {
        return "/signup";
    }
    
}
