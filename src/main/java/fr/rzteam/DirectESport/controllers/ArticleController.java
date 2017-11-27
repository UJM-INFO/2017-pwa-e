/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.mdparser.Markdown;
import fr.rzteam.DirectESport.model.Article;
import fr.rzteam.DirectESport.model.ArticleComment;
import fr.rzteam.DirectESport.model.ArticleRepository;
import fr.rzteam.DirectESport.model.User;
import fr.rzteam.DirectESport.model.UserRepository;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserRepository userRepo;

    @Inject
    ArticleRepository articleRepo;

    @RequestMapping("/article")
    public String article(@RequestParam(value = "id", required = false) String id, Model m)
    {
        //If the id is set and valid we display this article, otherwise we display the article menu
        try
        {
            if ("undefined".equals(id) || articleRepo.findOneById(Long.parseLong(id)) == null)
            {
                List<Article> list = articleRepo.findAll();
                m.addAttribute("articles", list);
                return "articleMenu";
            }
        } catch (NumberFormatException | NullPointerException e)
        {
            List<Article> list = articleRepo.findAll();
            m.addAttribute("articles", list);
            return "articleMenu";
        }
        Article articleToDisplay = articleRepo.findOneById(Long.parseLong(id));
        LinkedHashMap<ArticleComment, User> userComments = new LinkedHashMap<>();
        for (int i = 0; i < articleToDisplay.getComments().size(); i++)
        {
            ArticleComment a = articleToDisplay.getComments().get(i);
            User u = a.getAuthor();
            userComments.put(a, u);
        }
        m.addAttribute("article", articleToDisplay);
        m.addAttribute("comments", userComments);
        m.addAttribute("id", id);
        return "article";
    }

    @RequestMapping(value = "/add_article", method = RequestMethod.POST)
    public String addArticle(
        @RequestParam("article_title") String title,
        @RequestParam("article_text") String text)
    {
        String parsedText = Markdown.parse(text);
        Article article = new Article(title, parsedText);
        articleRepo.save(article);

        return "redirect:/article";
    }

    @RequestMapping(value = "/add_articleComment", method = RequestMethod.POST)
    public String save(
        @RequestParam("text") String text,
        @RequestParam("id") String id)
    {
        Long idlong = Long.parseLong(id);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUserName(name);
        Article a = articleRepo.findOneById(idlong);
        a.getComments().add(new ArticleComment(text, user));
        articleRepo.save(a);
        return "redirect:/article?id=" + id;
    }

}
