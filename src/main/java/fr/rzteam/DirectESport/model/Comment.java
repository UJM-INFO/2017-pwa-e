/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author chris
 */
@Entity
public class Comment
{
    @Id
    String text;
    String author;
    String dates;
    int idEvent;

    public Comment() {
    }
    
    public Comment(String comment, String author)
    {
        this.text = comment;
        this.author = author;
	this.idEvent = 1;
    }
    
    public Comment(String comment, String author,int idEvent)
    {
        this.text = comment;
        this.author = author;
	this.idEvent = idEvent;
    }
     
    public Comment(String comment, String author, String date)
    {
        this.text = comment;
        this.author = author;
        this.dates = date;
	this.idEvent = 1;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String comment)
    {
        this.text = comment;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDate()
    {
        return dates;
    }

    public void setDate(String date)
    {
        this.dates = date;
    }
    
    
}
