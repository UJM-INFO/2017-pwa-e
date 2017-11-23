/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import ch.qos.logback.core.CoreConstants;
import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;
import fr.rzteam.DirectESport.model.UserService;
import javax.inject.Inject;
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
public class SignupController
{
    
    @Inject
    UserService userService;
    @Inject
    UserRepository userRepo;
      
    @RequestMapping("/test")
    public String cacher()
    {
	User u = new User("admin","jacquie","toto","turlututu");
	userService.addUser(u);
	return "/signin";
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.POST )
    public String inscription(
	    @RequestParam("username") String username,
	    @RequestParam("realname") String realname,
	    @RequestParam("mail") String mail,
	    @RequestParam("password") String password,
	    @RequestParam("password2") String password2,
		Model m
	)
    {
		//System.out.println("LA = " + username + " " + realname + " "+ mail + " " + password);
		if (password.compareTo(password2)!=0) //The 2 passwords are different
		{
			m.addAttribute("error","Les mots de passes sont différents");
			return "forward:/signup";
		}
		
		int add = userService.addUser(new User(username,realname,password,mail)); //Try to add the user
		
		if (add == 1)	//The pseudo is already used
		{
			m.addAttribute("error","Ce pseudo est déjà utilisé");
			return "forward:/signup";
		}
		if (add == 2)	//The mail is already used
		{
			m.addAttribute("mailExists","Il y a déjà un compte avec cet email");
			return "forward:/signup";
		}
		m.addAttribute("user",username);
		m.addAttribute("mdp",password);
		return "/signin"; //The user has been correctly added in the database
    }
    
    
    @RequestMapping("/signup")
    public String page()
    {
        return "/signup";
    }
    
}
