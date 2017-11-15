/*
*
*/
package fr.rzteam.DirectESport.model;

import fr.rzteam.DirectESport.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @Dimitri
 */
public interface UserRepository extends CrudRepository<User, String> 
{

    public List<User> findAllByOrderByUserName();
    
}
