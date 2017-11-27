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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Clement Colin
 */
@Entity
@Data
public class Stats {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int win; //number of games win
    int tower; //number of tower destroyed
    int drake; //number of drake killed
    int kill; //number of ennemy killed
    int nashorbuff; //0: nothing 1: the team has the nashorbuff
    int drakebuff; //0: nothing 1; the team has the ancestral drake buff
    
    public Stats()
    {
	this.win = 0;
	this.tower = 0;
	this.drake = 0;
	this.kill = 0;
	this.nashorbuff = 0;
	this.drakebuff = 0;
    }
}
