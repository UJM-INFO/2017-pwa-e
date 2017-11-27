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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 */
@Entity
@Data
public class ArticleComment
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;

    @ManyToOne
    User author;

    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateArticleComment;

    public ArticleComment()
    {
    }

    public ArticleComment(String text, User author)
    {
        this.text = text;
        this.author = author;
        this.dateArticleComment = new Date();
    }

    public ArticleComment(String text, User author, Date dateArticleComment)
    {
        this.text = text;
        this.author = author;
        this.dateArticleComment = dateArticleComment;
    }

}
