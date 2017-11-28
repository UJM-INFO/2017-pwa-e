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

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Player model class
 */
@Entity
@Data
public class Player
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String playerName;

    PlayerRole roles;

    int age;

    String favoriteChampion; //Name of the champion the player prefers play with

    String history;		//Litle description of the player's life

    HashMap<String, Integer> prizeList; //Contains the name of the competition and the number of player's victories for the competition

    /**
     * Constructor
     */
    public Player()
    {
    }

    /**
     * Constructor
     * @param playerName
     * @param roles
     * @param age
     * @param favoriteChampion
     * @param history
     */
    public Player(String playerName, PlayerRole roles, int age, String favoriteChampion, String history)
    {
        this.playerName = playerName;
        this.roles = roles;
        this.age = age;
        this.favoriteChampion = favoriteChampion;
        this.history = history;
    }

    /**
     * Constructor
     * @param playerName
     * @param roles
     * @param age
     * @param favoriteChampion
     * @param history
     * @param prizeList
     */
    public Player(String playerName, PlayerRole roles, int age, String favoriteChampion, String history, HashMap<String, Integer> prizeList)
    {
        this.playerName = playerName;
        this.roles = roles;
        this.age = age;
        this.favoriteChampion = favoriteChampion;
        this.history = history;
        this.prizeList = prizeList;
    }

}
