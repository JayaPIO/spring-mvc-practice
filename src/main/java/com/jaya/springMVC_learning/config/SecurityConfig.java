package com.jaya.springMVC_learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails deep = User.builder()
                .username("Deep")
                .password("{noop}a1234")
                .roles("USER")
                .build();

        UserDetails rose = User.builder()
                .username("Rose")
                .password("{noop}a1234")
                .roles("USER","ADMIN")
                .build();

        UserDetails monica = User.builder()
                .username("monica")
                .password("{noop}a1234")
                .roles("USER","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(deep, rose, monica);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("USER")
                                .requestMatchers("/manager/**").hasRole("MANAGER")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                //login support
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll()
                )
                // logout support
                .logout(logout ->
                        logout.permitAll()
                )
                // Exception handling for forbidden page
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                );
        return http.build();
    }
}
