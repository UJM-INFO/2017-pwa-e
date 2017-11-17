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
    

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();
    
    public User() 
    {}
    
    
    public User(String userName,String realName, String password,String mail) 
	{
        this.userName = userName;
        this.realName = realName;
        this.roles.add(UserRole.USER); // be a user by default
        this.password = password;
		this.mail = mail;
    }
    
    public User(String userName, String displayName, List<String> roles, String derivedPassword, String mail) 
    {
        this.userName = userName;
        this.realName = displayName;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
        this.password = derivedPassword;
		this.mail = mail;
    }
    
}
