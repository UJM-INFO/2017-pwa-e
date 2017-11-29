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
import java.util.HashMap;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 * Team model class A team contains players
 */
@Entity
@Data
public class Team
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String teamName;

    Date dateCreation;

    @OneToMany
    List<Player> players = new ArrayList<>(); //The list of players of the team

    @Column(length = 10000)
    String history; //A description of the team

    HashMap<String, Integer> prizeList; //Contains the name of the competition and the number of team's victories for the competition

    /**
     * Constructor
     */
    public Team()
    {
    }

    /**
     * Constructor
     * @param teamName
     * @param dateCreation
     * @param history
     * @param prizeList
     */
    public Team(String teamName, Date dateCreation, String history, HashMap<String, Integer> prizeList)
    {
        this.teamName = teamName;
        this.dateCreation = dateCreation;
        this.history = history;
        this.prizeList = prizeList;
    }

    /**
     * Costructor
     * @param teamName
     * @param history
     * @param players
     */
    public Team(String teamName, String history, List<Player> players)
    {
        this.teamName = teamName;
        this.dateCreation = new Date();
        this.history = history;
        this.prizeList = new HashMap<>();
        this.players = players;
    }

}
