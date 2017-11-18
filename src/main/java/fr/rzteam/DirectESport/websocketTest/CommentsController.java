package fr.rzteam.DirectESport.websocketTest;

import fr.rzteam.DirectESport.model.RequestComment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CommentsController
{
    @MessageMapping("/hello")
    @SendTo("/topic/comments")
    public Greeting greeting(RequestComment request) throws Exception
    {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Ici le serveur, je t'envoi le commentaire " + request.getId() + " mon gros");
    }

}
