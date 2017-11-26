/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
