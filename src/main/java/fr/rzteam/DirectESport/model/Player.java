/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
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

    public Player()
    {
    }

    public Player(String playerName, PlayerRole roles, int age, String favoriteChampion, String history)
    {
        this.playerName = playerName;
        this.roles = roles;
        this.age = age;
        this.favoriteChampion = favoriteChampion;
        this.history = history;
    }

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
