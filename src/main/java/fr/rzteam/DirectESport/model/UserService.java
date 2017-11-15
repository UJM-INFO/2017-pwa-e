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
        if (u == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(u.userName, u.password, u.getRoles());
    }
    
    public void addUser(User u)
    {
	if (repo.findByUserName(u.userName) != null)
	{
	    System.out.println("This userName is already used.");
	}
	else if (repo.findByMail(u.mail) != null)
	{
	    System.out.println("There is already an account with this email");
	}
	else 
	{
	    u.setPassword(encoder.encode(u.password));
	    repo.save(u);
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

    public void changeUserPassword(String userName, String newPassword) 
    {
	User u = repo.findByUserName(userName);
        u.setPassword(encoder.encode(newPassword));
        repo.save(u);
    }
}