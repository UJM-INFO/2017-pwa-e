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

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Data;

/**
 * Comment model class These are the comments posted by editors
 */
@Entity
@Data
public class Comment
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;

    @ManyToOne
    User author;

    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateComment;

    /**
     * Constructor
     */
    public Comment()
    {
    }

    /**
     * Constructor
     * @param text
     * @param author
     */
    public Comment(String text, User author)
    {
        this.text = text;
        this.author = author;
        this.dateComment = new Date();
    }
}
