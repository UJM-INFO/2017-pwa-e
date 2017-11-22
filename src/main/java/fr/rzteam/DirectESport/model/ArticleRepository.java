/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface ArticleRepository extends CrudRepository<Article, Long>
{
	@Override
	public List<Article> findAll();
	public Article findOneById(Long id);
}
