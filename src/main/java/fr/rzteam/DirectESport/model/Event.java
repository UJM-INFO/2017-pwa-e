/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 */
@Entity
@Data
public class Event
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
        
        String description;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	Date dateEvent; 
	
	@ManyToOne
	Team team1;
	
	@ManyToOne
	Team team2;
	
	@OneToOne
	Stats stats_team1;
	
	@OneToOne
	Stats stats_team2;
	
	int status; //0 the game has not started yet / 1 the team1 won / 2 the team2 won / 3 the game is in progress
	int type; //1:BO1,3:BO3,5:BO5
	@OneToMany(cascade = CascadeType.ALL)
	List<Comment> comments = new ArrayList<>();
	
	public Event()
	{
	}
	
	public Event(String description, Date date, Team team1, Team team2, int status,int type,Stats stats_team1,Stats stats_team2)
	{
            this.description = description;
            this.dateEvent = date;
            this.team1 = team1;
            this.team2 = team2;
            this.status = status;
	    this.type = type;
	    this.stats_team1 = stats_team1;
	    this.stats_team2 = stats_team2;
	}

	

}
