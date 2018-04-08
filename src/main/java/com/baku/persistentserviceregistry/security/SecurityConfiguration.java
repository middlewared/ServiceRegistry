package com.baku.persistentserviceregistry.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user1").password("user1Pass").roles("USER")
                .and()
                .withUser("admin").password("adminPass").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/auth/login.html").permitAll()
                .antMatchers("/resources/**").hasRole("ADMIN")
                
//                .and()
//                .authorizeRequests().antMatchers("/auth/login*").anonymous().anyRequest().authenticated()
//                
                .and()
                .formLogin().loginPage("/auth/login.html")
                .defaultSuccessUrl("/PersistentServiceRegistry/resources/application.wadl", true)
                .failureUrl("/auth/login.html?error=true")
                
                .and()
                .logout().logoutSuccessUrl("/auth/login.html");  
    }
}
