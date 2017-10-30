package fr.rzteam.DirectESport.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Dimitri
 */
@Entity
@Data
public class User 
{
    @Id
    String pseudo;
    
    String name;
    
    String password;
    
    UserRole role;

    public User()
    {}
    
    public User(String pseudo, String name, String password, UserRole role) {
        this.pseudo = pseudo;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    
    
}
