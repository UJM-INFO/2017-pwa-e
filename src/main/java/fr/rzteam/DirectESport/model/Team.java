/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
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
	
	String history; //A description of the team
	
	HashMap<String, Integer> prizeList; //Contains the name of the competition and the number of team's victories for the competition

	public Team()
	{
	}
	
	public Team(String teamName, Date dateCreation, String history, HashMap<String, Integer> prizeList)
	{
		this.teamName = teamName;
		this.dateCreation = dateCreation;
		this.history = history;
		this.prizeList = prizeList;
	}
	
	public Team(String teamName,String history)
	{
		this.teamName = teamName;
		this.dateCreation = new Date();
		this.history = history;
		this.prizeList = new HashMap<>();
	}

	
}
