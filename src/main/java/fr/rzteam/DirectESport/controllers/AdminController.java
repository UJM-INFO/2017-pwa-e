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
import fr.rzteam.DirectESport.model.UserRole;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for Admin operations / page
 */
@Controller
public class AdminController
{
    @Inject
    UserRepository userRepo;
    
    /**
     * Display the admin page, the verification is not done here
     * @param m The model to exchange data with Thymeleaf
     * @return The template admin.html
     */
    @RequestMapping("/admin")
    public String adminPage(Model m)
    {
        List<User> users = userRepo.findAllByOrderByUserName();
        m.addAttribute("users",users);
        return "admin";
    }
    
    /**
     * Receiving the order to change a user to the role "User"
     * @param token A verification for security
     * @param pseudo Pseudo of the user for changing his role
     * @return Redirection to "admin"
     */
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
    
    /**
     * Receiving the order to change a user to the role "Editor"
     * @param token A verification for security
     * @param pseudo Pseudo of the user for changing his role
     * @return Redirection to "admin"
     */
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
    
    /**
     * Receiving the order to change a user to the role "Admin"
     * @param token A verification for security
     * @param pseudo Pseudo of the user for changing his role
     * @return Redirection to "admin"
     */
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
