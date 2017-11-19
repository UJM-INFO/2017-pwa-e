package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Comment;
import fr.rzteam.DirectESport.model.CommentSet;
import fr.rzteam.DirectESport.model.RequestComment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentsController
{
    //WEBSOCKET
    
    @MessageMapping("/hello")
    @SendTo("/topic/comments")
    public CommentSet sendComment(RequestComment request) throws Exception
    {
            /* on demande au model avec request.getId()*/
        CommentSet commentSet= new CommentSet("Evenement "+request.getId());
        commentSet.add(new Comment("Ces commentaires sont ajoutés directement du serveur dans la classe CommentsController","Chris","19/11/2017 06:49"));
        commentSet.add(new Comment("La boule magique !","MisterMV","19/11/2017 06:38"));
        commentSet.add(new Comment("Sa mère la chauve moldave en string latérale, ce gars est trop fort !","Chris","19/11/2017 06:37"));
        
        
        return commentSet;
    }
    
    //HTTP
    
    @RequestMapping("/comment")
    public String comment()
    {
        return "comment";
    }
}