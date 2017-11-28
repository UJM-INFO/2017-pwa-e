/*
 *      _____   _                   _            _____                      _   
 *     |  __ \ (_) Website Project | |          / ____|                    | |  
 *     | |  | | _  _ __  ___   ___ | |_    ___ | (___   _ __    ___   _ __ | |_ 
 *     | |  | || || '__|/ _ \ / __|| __|  / _ \ \___ \ | '_ \  / _ \ | '__|| __|
 *     | |__| || || |  |  __/| (__ | |_  |  __/ ____) || |_) || (_) || |   | |_ 
 *     |_____/ |_||_|   \___| \___| \__|  \___||_____/ | .__/  \___/ |_|    \__|
 *                                                     | |                                                                                              
 *  ----Authors----                                    |_| 
 * Dimitri BRUYERE
 * Clément COLIN
 * Christopher JEAMME
 *  ---------------
 */
package fr.rzteam.DirectESport.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for teams
 */
public interface TeamRepository extends CrudRepository<Team, Long>
{

    /** 
     * @return all teams
     */
    @Override
	public List<Team> findAll();

    /**
     * @param id
     * @return the team with the id
     */
    public Team findOneById(Long id);

    /**
     * @param teamName
     * @return the team with the name
     */
    public Team findOneByTeamName(String teamName);

    /**
     * @param teamName
     * @return the list of team with the name
     */
    public List<Team> findManyByTeamName(String teamName);

    /**
     * @param id
     * @return return the list of player with the id
     */
    public List<Player> findManyById(Long id);
}
