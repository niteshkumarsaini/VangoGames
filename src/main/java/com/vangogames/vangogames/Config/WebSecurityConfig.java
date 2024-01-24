package com.vangogames.vangogames.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.getUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception

    {
        return configuration.getAuthenticationManager();

    }

    @Bean
    public UserDetailsService getUserDetailsService() {

        return new UserDetailsServiceImpl();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/", "/login", "/register", "/static/**", "/h2/**", "/css/**",
                        "/js/**", "/json/**", "/images/**", "/img/**", "/games", "/register",
                        "/jpg/**", "/png/**", "/icon_images/**", "/support", "/login", "/Game_Cover/**", "/",
                        "/signinusinggoogle/**","/oauth2/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/dashboard").successForwardUrl("/dashboard")
                .defaultSuccessUrl("/dashboard",true)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/login")
                .sessionFixation().migrateSession()
                .maximumSessions(1)
                .expiredUrl("/login")
                .maxSessionsPreventsLogin(true) // Prevents new logins when the maximum sessions is reached
                .and()
                .and()
                .authenticationProvider(daoAuthenticationProvider());

        return http.build();

    }

}
