/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface PlayerRepository extends CrudRepository<Player, Long>
{
	@Override
	public List<Player> findAll();
	public Player findOneById(Long id);
}
