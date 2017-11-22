package fr.rzteam.DirectESport.controllers;

import fr.rzteam.DirectESport.model.Comment;
import fr.rzteam.DirectESport.model.CommentRepository;
import fr.rzteam.DirectESport.model.RequestComment;
import javax.inject.Inject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentsController
{
    @Inject
    CommentRepository repo;
    //WEBSOCKET
    
    /**
     *  When we receive a adding signal of a comment, we request to all websocket to update
     * @param request adding signal from client who add a comment
     * @return a signal to all active websocket
     */
    @MessageMapping("/update")
    @SendTo("/topic/comments")
    public String updateAllWebsocketClient(RequestComment request)
    {
        //FAUDRA METTRE UN SPECIAL POUR LE SIGNAL DE L'UPDATE POUR EVITER LES HACK
               
        /* on demande au model avec request.getId()*/
        //repo.save(new Comment("La boule magique !","MisterMV","19/11/2017 06:38"));
        //CommentSet commentSet= new CommentSet("Evenement "+request.getId(),repo.findAll());
        //commentSet.add(new Comment("Ces commentaires sont ajoutés directement du serveur dans la classe CommentsController","Chris","19/11/2017 06:49"));

        return "";
    }
    
    //HTTP
    
    @RequestMapping("/comment")
    public String comment()
    {
        return "comment";
    }
}
