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
public interface TeamRepository extends CrudRepository<Team, Long>
{
	@Override
	public List<Team> findAll();
	public Team findOneById(Long id);
        public Team findOneByTeamName(String teamName);
}
