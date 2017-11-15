/*
* 
*/

package fr.rzteam.DirectESport.model;

import fr.rzteam.DirectESport.model.UserRole;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @Dimitri
 */
@Entity
@Data
public class User {
    @Id
    String userName;
    
    String realName;
    
    String password;
    
    String mail;
    
    int age;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();
    
    public User() 
    {}
    
    public User(String pseudo, String name, List<String> roles, String derivedPassword, String mail, int age) 
    {
        this.userName = pseudo;
        this.realName = name;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
        this.password = derivedPassword;
	this.mail = mail;
	this.age = age;
    }
    
}
