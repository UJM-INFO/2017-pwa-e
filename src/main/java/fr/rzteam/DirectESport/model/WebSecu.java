/*
 * 
 */

package fr.rzteam.DirectESport.model;

import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author 
 */
@Configuration
@EnableWebSecurity
public class WebSecu extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      

      
     http.authorizeRequests()
            .anyRequest().permitAll() //.hasAnyRole("ADMIN")
     .and().formLogin().
	    loginPage("/signin").
            loginProcessingUrl("/appLogin").
            usernameParameter("app_username").
            passwordParameter("app_password").
            defaultSuccessUrl("/home").
            permitAll().and().logout().logoutSuccessUrl("/home").permitAll();
  }
  
  @Inject
  UserService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      
      /*auth.inMemoryAuthentication()
        .withUser("robert").password("toto").roles("USER", "ADMIN")
        .and().withUser("bob").password("toto").roles("USER")*/

      auth
              .userDetailsService(userDetailsService)
              .passwordEncoder(userDetailsService.encoder);
  }
}