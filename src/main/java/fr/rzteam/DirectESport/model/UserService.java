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
package fr.rzteam.DirectESport.model;

import java.util.List;
import javax.inject.Inject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @Dimitri
 */
@Component
public class UserService implements UserDetailsService {
    
    @Inject
    UserRepository repo;
    
    public final PasswordEncoder encoder = new BCryptPasswordEncoder();
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        User u = repo.findOne(username);
        if (u == null) 
		{
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(u.userName, u.password, u.getRoles());
    }
    
    public int addUser(User u)
    {
        if (repo.findByUserName(u.userName) != null)
        {
            return 1;	//A user with this userName already exists
        }
        else if (repo.findByMail(u.mail) != null)
        {
            return 2;	//A user with this mail already exists
        }
        else 
        {
            u.setPassword(encoder.encode(u.password));
            repo.save(u);
            return 0;	//The user is added in the database
        }
    }
    
    public void makeUserAdmin(String username) 
    {
        User u = repo.findByUserName(username);
        u.getRoles().add(UserRole.ADMIN);
        repo.save(u);
    }
    
    public void makeUserEditor(String username) 
    {
        User u = repo.findByUserName(username);
        u.getRoles().add(UserRole.EDITOR);
        repo.save(u);
    }

    public int changeUserPassword(String userName, String newPassword) 
    {
        User u = repo.findByUserName(userName);
        if (u != null)
        {
            u.setPassword(encoder.encode(newPassword));
            repo.save(u);
            return 1; //Success
        }
        return -1; //Never
    }
    
    public void changeRealName(String userName, String newName) 
    {
	User u = repo.findByUserName(userName);
        u.setRealName(newName);
        repo.save(u);
    }
}