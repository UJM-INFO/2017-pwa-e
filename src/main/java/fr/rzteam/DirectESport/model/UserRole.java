/*
 * 
 */

package fr.rzteam.DirectESport.model;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @Dimitri 
 */
public enum UserRole implements GrantedAuthority {
    
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE : "+this.name();
    }
}
