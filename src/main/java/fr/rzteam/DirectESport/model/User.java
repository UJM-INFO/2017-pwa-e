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
 * User model class
 */
@Entity
@Data
public class User
{

    @Id
    String userName;

    String pseudo;

    String realName;

    String password;

    String mail;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    /**
     * Constructor
     */
    public User()
    {
    }

    /**
     * Constructor
     * @param userName
     * @param realName
     * @param password
     * @param mail
     */
    public User(String userName, String realName, String password, String mail)
    {
        this.userName = userName;
        this.realName = realName;
        this.roles.add(UserRole.ADMIN); // be a user by default
        this.password = password;
        this.mail = mail;
        this.pseudo = userName;
    }

    /**
     * Constructor
     * @param userName
     * @param displayName
     * @param roles
     * @param derivedPassword
     * @param mail
     */
    public User(String userName, String displayName, List<String> roles, String derivedPassword, String mail)
    {
        this.userName = userName;
        this.realName = displayName;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
        this.password = derivedPassword;
        this.mail = mail;
        this.pseudo = userName;
    }

}
