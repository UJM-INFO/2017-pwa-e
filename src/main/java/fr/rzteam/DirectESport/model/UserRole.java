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
    EDITOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
