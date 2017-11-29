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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import lombok.Data;

/**
 * Article model class
 */
@Entity
@Data
public class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	
    String title;
    
    @Column(length = 10000)
    String text;
    
    String link;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date;

    @OneToMany(cascade = CascadeType.ALL)
    List<ArticleComment> comments = new ArrayList<>();

    /**
     * Constructor
     */
    public Article()
    {
    }

    /**
     * Constructor
     * @param title
     * @param content
     */
    public Article(String title, String content)
    {
        this.title = title;
        this.text = content;
        this.date = new Date();
    }

    /**
     * Constructor
     * @param title
     * @param text
     * @param link
     */
    public Article(String title, String text, String link)
    {
        this.title = title;
        this.text = text;
        this.link = link;
        this.date = new Date();
    }
	
	
}
