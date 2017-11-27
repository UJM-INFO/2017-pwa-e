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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 */
@Entity
@Data
public class Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	
    String title;

    String text;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date;

    @OneToMany(cascade = CascadeType.ALL)
    List<ArticleComment> comments = new ArrayList<>();

    public Article()
    {
    }

    public Article(String title, String content)
    {
        this.title = title;
        this.text = content;
        this.date = new Date();
    }
	
	
}
