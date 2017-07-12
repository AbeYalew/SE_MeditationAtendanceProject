package edu.mum.cs.projects.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("980201").password("123").roles("STUDENT");
        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("faculty").password("123").roles("FACULTY");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
      http.authorizeRequests()
      .antMatchers("/welcome").access("hasRole('FACULTY') or hasRole('STUDENT') or hasRole('ADMIN')")
      .and().formLogin().loginPage("/login")
       .usernameParameter("username").passwordParameter("password")
       .defaultSuccessUrl("/welcome")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
 