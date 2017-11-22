/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.ArrayList;
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
	
	int dateCreation;
	
	@OneToMany
	List<Player> players = new ArrayList<>(); //The list of players of the team
	
	String hystory; //A description of the team
	
	HashMap<String, Integer> prizeList; //Contains the name of the competition and the number of team's victories for the competition

	public Team()
	{
	}
	
	public Team(String teamName, int dateCreation, String hystory, HashMap<String, Integer> prizeList)
	{
		this.teamName = teamName;
		this.dateCreation = dateCreation;
		this.hystory = hystory;
		this.prizeList = prizeList;
	}

	
}
