package com.sukumar.task_reminder.config;

import com.sukumar.task_reminder.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableMethodSecurity
@EnableScheduling
@Configuration
public class SecurityConfig {
//    This class represents the custom security configuration and validate the requests based on the requirements

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // It disables the csrf validation because , here we used JWT authentication
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login").permitAll()
                        .anyRequest().authenticated()
                ) // This represents to give access these endpoints everyone.
                .addFilterBefore(jwtAuthenticationFilter,
                        org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class) // This step validates the JWT token
                .formLogin(form -> form.disable()) // This disables the default login form on Spring Boot
                .httpBasic(basic -> basic.disable()); // This step disables the basic http request for more security

        return http.build();
    }
}
