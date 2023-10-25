package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //CONFIGURATION 1
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        return httpSecurity
//                .authorizeHttpRequests()
//                    .requestMatchers("v1/index2").permitAll() //No necesitan autorizacion
//                    .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                //.httpBasic()
//                //.and()
//                .build();
//    }

 //.csrf().disable() //Cross-Site Request Forgery, seguridad especial para formularios


    //Configuration 2
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                    .successHandler(successHandler()) //URL A DONDE SE VA A IR DESPUES DE INICIAR SESION
                    .permitAll()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) //ALWAYS(creará un sesion siempre y cuando no exista alguna, si ya existe una sesion abierta la usa) - IF_REQUIRED(si la sesion aún no existe la va a crear, en caso contrario la va a reutilizar... es más extricto que el always) - NEVER(no crea ninguna sesión, pero si ya existe la va a crear, igual funciona sin sesión) - STATELESS(no crea ni usa ninguna sesión)
                    .invalidSessionUrl("/loggin")
                    .maximumSessions(1)
                    .expiredUrl("/login")
                    .sessionRegistry(sessionRegistry()) //Ver los datos del usuario en tiempo real
                .and()
                    .sessionFixation()//Prevención de vulnerabilidades, ataques o fijación de una sesión
                    .migrateSession() //migrationSession(Spring genera otro ID de sesion si detecta un ataque, además hace un copia y pega de los datos de la sesion para el usuario) - newSession(hace los mismo que migrate session pero no copia los datos, creo una sesion nueva) - none(inhabilita completamente la sesion si detecta un ataque)
                .and()
                    .httpBasic()//Autenticación básica
                .and()
                .build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> {
            response.sendRedirect("/v1/session");
        });
    }
}
