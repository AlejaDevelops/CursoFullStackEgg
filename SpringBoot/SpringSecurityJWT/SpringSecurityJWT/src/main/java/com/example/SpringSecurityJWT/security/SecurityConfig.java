package com.example.SpringSecurityJWT.security;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return  httpSecurity
                .csrf(config -> config.disable()) //En este parte del proyecto no se habilitará porque no se trabajará con formularios ni directo con clientes, solo se trabajará la configuración de una autenticación
                // Cross-Site Request Forgery: is a type of attack where a malicious user can execute actions on behalf of another user without their consent. It works by tricking the victim into executing unintended actions on a different website.
                /*When CSRF protection is enabled, Spring Security automatically generates a unique token for each user session and ensures that this token is included in any POST, PUT, PATCH, and DELETE requests. This token is validated on the server side, and requests without a valid CSRF token are rejected, thus protecting against CSRF attacks.*/
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/hello").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Paquito")
                .password("123456")
                .roles()
                .build());
        return manager;
    }

     @Bean
     PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
     }

    @Bean
    AuthenticationManager authenticationManager (HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder)
                .and().build();
    }
}
