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
public class Competition
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	Date dateCompetition;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Event> events = new ArrayList<>();
	
	@ManyToOne
	Team winner;
	
	String name;

	public Competition()
	{
	}

	public Competition(Long id, Date date, Team winner,String name)
	{
		this.id = id;
		this.dateCompetition = date;
		this.winner = winner;
		this.name = name;
	}
	
	
}
