/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;


import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Clement Colin
 */
public interface CommentRepository extends CrudRepository<Comment, String> {
   
    public ArrayList<Comment> findAll();
//    public ArrayList<Comment> findAllByidEvent(int idEvent);
}
