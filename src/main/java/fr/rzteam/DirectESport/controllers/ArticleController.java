/*
 *      _____   _                   _            _____                      _   
 *     |  __ \ (_) Website Project | |          / ____|                    | |  
 *     | |  | | _  _ __  ___   ___ | |_    ___ | (___   _ __    ___   _ __ | |_ 
 *     | |  | || || '__|/ _ \ / __|| __|  / _ \ \___ \ | '_ \  / _ \ | '__|| __|
 *     | |__| || || |  |  __/| (__ | |_  |  __/ ____) || |_) || (_) || |   | |_ 
 *     |_____/ |_||_|   \___| \___| \__|  \___||_____/ | .__/  \___/ |_|    \__|
 *                                                     | |                                                                                              
 *  ----Authors----                                    |_| 
 * Dimitri BRUYERE
 * Clément COLIN
 * Christopher JEAMME
 *  ---------------
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
 * Controller for Article operations / pages
 */
@Controller
public class ArticleController
{

    @Inject
    UserRepository userRepo;

    @Inject
    ArticleRepository articleRepo;

    /**
     *  We redirect to the article page if the id is set, otherwise we redirect to the article menu
     * @param id Id of the article we want
     * @param m The model to exchange data with Thymeleaf
     * @return The template articleMenu.html or article.html
     */
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

    /**
     * Receiving the order to add an article
     * @param title Title of the article
     * @param text Text of the article
     * @return A redirection to /article
     */
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

    /**
     * Receiving the order to add a comment to a article
     * @param text Text of the comment
     * @param id Id of the article to add a comment
     * @return A redirection to the article page
     */
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
    
    @RequestMapping("/articleCreation")
    public String creation()
    {
        return "articleCreation";
    }
    

}
