/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;
import fr.rzteam.DirectESport.model.UserRole;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/become_user")
    public String becomeUser(
        @RequestParam("token") String token,
        @RequestParam("pseudo") String pseudo
    )
    {
        if(token.compareTo("vba7rqk6lra5fua1")==0)
        {
            User user = userRepo.findByUserName(pseudo);
            
            if(user.getRoles().contains(UserRole.ADMIN))
                user.getRoles().remove(UserRole.ADMIN);
            if(user.getRoles().contains(UserRole.EDITOR))
                user.getRoles().remove(UserRole.EDITOR);
            if(!user.getRoles().contains(UserRole.USER))
                user.getRoles().add(UserRole.USER);
            
            userRepo.save(user);
        }
        
        return "redirect:/admin";
    }
    
    @RequestMapping("/become_editor")
    public String becomeEditor(
        @RequestParam("token") String token,
        @RequestParam("pseudo") String pseudo
    )
    {
        if(token.compareTo("vba7rqk6lra5fua1")==0)
        {
            User user = userRepo.findByUserName(pseudo);
            
            if(user.getRoles().contains(UserRole.ADMIN))
                user.getRoles().remove(UserRole.ADMIN);
            if(!user.getRoles().contains(UserRole.EDITOR))
                user.getRoles().add(UserRole.EDITOR);
            if(!user.getRoles().contains(UserRole.USER))
                user.getRoles().add(UserRole.USER);
            
            userRepo.save(user);
        }
        
        return "redirect:/admin";
    }
    
    @RequestMapping("/become_admin")
    public String becomeAdmin(
        @RequestParam("token") String token,
        @RequestParam("pseudo") String pseudo
    )
    {
        if(token.compareTo("vba7rqk6lra5fua1")==0)
        {
            User user = userRepo.findByUserName(pseudo);
            
            if(!user.getRoles().contains(UserRole.ADMIN))
                user.getRoles().add(UserRole.ADMIN);
            if(!user.getRoles().contains(UserRole.EDITOR))
                user.getRoles().add(UserRole.EDITOR);
            if(!user.getRoles().contains(UserRole.USER))
                user.getRoles().add(UserRole.USER);
            
            userRepo.save(user);
        }
        
        return "redirect:/admin";
    }
    
}
