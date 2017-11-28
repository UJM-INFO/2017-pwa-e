/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rzteam.DirectESport.model;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Events
 */
public interface EventRepository extends CrudRepository<Event, Long>
{

    /**
     * @return all events
     */
    @Override
	public List<Event> findAll();

    /**
     * @param id
     * @return the event with the id
     */
    public Event findOneById(Long id);

    /**
     * @param competitionID
     * @return all event which belongs to a competition
     */
    public List<Event> findAllByCompetitionID(Long competitionID);

    /**
     * delete the event with the id
     * @param id
     */
    @Transactional
	void deleteOneById(Long id);
}
