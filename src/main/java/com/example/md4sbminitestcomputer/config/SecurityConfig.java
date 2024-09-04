package com.example.md4sbminitestcomputer.config;

import com.example.md4sbminitestcomputer.controller.CustomSuccessHandler;
import com.example.md4sbminitestcomputer.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IAppUserService appUserService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }


    //    xac thuc
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
//        tiem app user service
        dao.setUserDetailsService(appUserService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public CustomSuccessHandler customSuccessHandle(){
        return new CustomSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(
//                        authorize -> authorize.requestMatchers( "/error_404", "/css/**", "/js/**", "/images/**").permitAll()
//                                .anyRequest().authenticated()
//                );
//        return httpSecurity.build();
        httpSecurity
                .formLogin(form -> form
                        // Use Spring Security's default login form
                        .defaultSuccessUrl("/home", true) // Redirect to /home after successful login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Trigger logout with this URL
                        .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID") // Remove cookies after logout
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/error_404", "/css/**", "/js/**", "/images/**", "/register/**").permitAll() // Public URLs
                        .anyRequest().authenticated() // Protect all other URLs
                )
                .csrf().disable();
        return httpSecurity.build();
    }
}