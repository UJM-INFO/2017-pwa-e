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
	
 
    int kill;
    public Stats()
    {}
}
