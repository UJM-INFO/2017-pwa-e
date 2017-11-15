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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repo.findOne(username);
        if (u == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(u.pseudo, u.password, u.getRoles());
    }

    public void saveUserComputingDerivedPassword(User u, String rawPassword) {
        setComputingDerivedPassword(u, rawPassword);
        repo.save(u);
    }

    public void setComputingDerivedPassword(User u, String rawPassword) {
        String codedPassword = encoder.encode(rawPassword);
        u.setPassword(codedPassword);
    }

    public void makeUserAdmin(String username) {
        User u = repo.findOne(username);
        u.getRoles().add(UserRole.ADMIN);
        repo.save(u);
    }

    public List<User> listAllUsers() {
        return repo.findAllByOrderByPseudo();
    }
    
    public void changeUserPassword(final User user, final String password) 
    {
        user.setPassword(encoder.encode(password));
        repo.save(user);
    }
}