package com.ved.websecurityexample.config;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ved.websecurityexample.service.CustomUserDetailsSarvice;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                /*
                 * //1 this line remove defolt security whitch is by spring securty
                 * http
                 * .authorizeHttpRequests(auth -> auth
                 * .anyRequest() // all request
                 * //.permitAll()
                 * .authenticated() // all request must be authenticated
                 * )
                 * .formLogin(Customizer.withDefaults()) // default login page
                 * //.httpBasic(Customizer.withDefaults()) // popup of loing and signup default
                 * //.csrf(csrf-> csrf.disable()) // disable CSRF protection for simplicity in
                 * this example
                 * ;
                 * return http.build();
                 * //1
                 */
                http
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/home", "/signup").permitAll()
                                                .anyRequest().authenticated())
                                .httpBasic(Customizer.withDefaults())
                                .formLogin(Customizer.withDefaults())
                                .csrf(csrf -> csrf.disable());
                return http.build();
        }
        // @Bean
        // public UserDetailsService userDetailsService() {
        //         UserDetails user1 = User
        //                         .withUsername("dev")
        //                         .password("{noop}dev")
        //                         .roles("USER")
        //                         .build();
        //         UserDetails user2 = User
        //                         .withUsername("singh")
        //                         .password("{noop}singh")
        //                         .roles("USER")
        //                         .build();
        //         return new InMemoryUserDetailsManager(user1, user2);
        // }
        @Bean
        public UserDetailsService userDetailsService() {
                return new CustomUserDetailsSarvice();
                
        }
        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider() {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                authProvider.setUserDetailsService(userDetailsService());
                authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
                return authProvider;
        }
}
