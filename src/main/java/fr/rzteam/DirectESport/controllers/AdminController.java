/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chris
 */
@Controller
public class AdminController
{
    @Inject
    UserRepository userRepo;
    
    @RequestMapping("/admin")
    public String adminPage(Model m)
    {
        List<User> users = userRepo.findAllByOrderByUserName();
        m.addAttribute("users",users);
        return "admin";
    }
    
}
