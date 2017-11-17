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
	    @RequestParam("password") String password,
	    @RequestParam("mail") String mail
    )
    {
	System.out.println("LA = " + username + " " + realname + " "+ mail + " " + password);
	
	userService.addUser(new User(username,realname,password,mail));
	
	return "redirect:/home";
    }
    
    
    @RequestMapping("/signup")
    public String page()
    {
        return "/signup";
    }
    
}
