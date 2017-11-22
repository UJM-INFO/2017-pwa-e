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
        
        String eventName;
        String description;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	Date dateEvent; 
	
	@ManyToOne
	Team team1;
	
	@ManyToOne
	Team team2;
	
	int status; //0 the game has not started yet / 1 the team1 won / 2 the team2 won / 3 the game is in progress

	@OneToMany(cascade = CascadeType.ALL)
	List<Comment> comments = new ArrayList<>();
	
	public Event()
	{
	}
	
	public Event(String eventName, String description, Date date, Team team1, Team team2, int status)
	{
            this.eventName = eventName;
            this.description = description;
            this.dateEvent = date;
            this.team1 = team1;
            this.team2 = team2;
            this.status = status;
	}

	

}
