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
 * Repository for Articles
 */
public interface ArticleRepository extends CrudRepository<Article, Long>
{

    /**
     * @return all Articles
     */
    @Override
    public List<Article> findAll();

    /**
     * @param id
     * @return the Article with the id 
     */
    public Article findOneById(Long id);

    /**
     * @return the 3 most recent articles
     */
    public List<Article> findTop3ByOrderByIdDesc();
}
