/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 */
@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long>
{
	@Override
	public List<Competition> findAll();
	public Competition findOneById(Long id);
        public void deleteOneById(Long id);
}
