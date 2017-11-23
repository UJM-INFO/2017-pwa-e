/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Article;
import fr.rzteam.DirectESport.model.ArticleRepository;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chris
 */
@Controller
public class ArticleController
{
    @Inject
    ArticleRepository articleRepo;
    
    @RequestMapping("/article")
    public String article(@RequestParam(value="id", required=false) String id, Model m)
    {
        //If the id is set and valid we display this article, otherwise we display the article menu
        try
        {
            if("undefined".equals(id) || articleRepo.findOneById(Long.parseLong(id))==null)
            {
                List<Article> list = articleRepo.findAll();
                m.addAttribute("articles",list);
                return "articleMenu";
            }
        }
        catch(NumberFormatException | NullPointerException e)
        { 
            List<Article> list = articleRepo.findAll();
            m.addAttribute("articles",list);
            return "articleMenu";
        }
	m.addAttribute("id",id);
        return "article";
    }
    
    @RequestMapping(value = "/add_article", method = RequestMethod.POST)
    public String addArticle(
            @RequestParam("article_title") String title,
            @RequestParam("article_text") String text)       
    {
        Article article = new Article(title, text);
        articleRepo.save(article);
        
        return "redirect:/article";
    }
    
}
