/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

/**
 *
 * @author chris
 */
public class Comment
{
    String text;
    String author;
    String date;
    
    public Comment(String comment, String author)
    {
        this.text = comment;
        this.author = author;
    }
    
    public Comment(String comment, String author, String date)
    {
        this.text = comment;
        this.author = author;
        this.date = date;
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
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    
    
}
