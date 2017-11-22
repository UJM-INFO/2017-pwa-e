/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author chris
 */
@Entity
@Data
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String text;
    String author;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	Date dateComment;
	
    int idEvent;

    public Comment() {
    }
    
    public Comment(String comment, String author)
    {
        this.text = comment;
        this.author = author;
    }
    
    public Comment(String comment, String author,int idEvent)
    {
        this.text = comment;
        this.author = author;
	this.idEvent = idEvent;
    }
     
    public Comment(String comment, String author, Date date)
    {
        this.text = comment;
        this.author = author;
        this.dateComment = date;
	this.idEvent = 1;
    }
    
    
}
