/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;


import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Clement Colin
 */
@CrossOrigin("*")
public interface CommentRepository extends CrudRepository<Comment, Long> {
   
    public ArrayList<Comment> findAll();
//    public ArrayList<Comment> findAllByidEvent(int idEvent);
}
