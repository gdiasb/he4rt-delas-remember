package com.dias.he4rt_delas_remember.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequest -> {
                    authorizeRequest
//                            .requestMatchers("/token").permitAll()
                            .requestMatchers("/v1/events/actives").permitAll()
                            .requestMatchers(HttpMethod.POST, "/v1/events").hasAuthority("ADMIN")
                            .anyRequest().hasAuthority("USER");

                })
                .oauth2Login().and()
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)

                .build();
    }
}
