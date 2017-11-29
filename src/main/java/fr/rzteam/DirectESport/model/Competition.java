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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import lombok.Data;

/**
 * Competition model class
 * A competition contains events
 */
@Entity
@Data
public class Competition
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateCompetition;

    @OneToMany(cascade = CascadeType.ALL)
    List<Event> events = new ArrayList<>();

    @ManyToMany
    List<Team> teams = new ArrayList<>();

    @ManyToOne
    Team winner;

    String name;

    /**
     * Constructor
     */
    public Competition()
    {
    }

    /**
     * Constructor
     * @param date
     * @param name
     */
    public Competition(Date date, String name)
    {
        this.dateCompetition = date;
        this.name = name;
    }

    /**
     * Comstructor
     * @param date
     * @param name
     * @param teams
     */
    public Competition(Date date, String name, List<Team> teams)
    {
        this.dateCompetition = date;
        this.name = name;
        this.teams = teams;
    }

}
