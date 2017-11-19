/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class CommentSet
{
    public String eventName;
    public ArrayList<Comment> set;
    
    public CommentSet()
    {
        set = new ArrayList<>();
    }
    
    public CommentSet(String event)
    {
        this();
        eventName = event;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }
    
    public Comment get(int id)
    {
        return set.get(id);
    }
    
    public void add(Comment comment)
    {
        set.add(comment);
    }

    public ArrayList<Comment> getSet()
    {
        return set;
    }

    public void setSet(ArrayList<Comment> set)
    {
        this.set = set;
    }
}
