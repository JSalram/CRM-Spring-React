//package com.solera.crm.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Profile("!https")
//public class SecSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)
//            throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/index*", "/static/**", "/*.js", "/*.json", "/*.ico")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/index.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/index.html?error=true");
//        return http.build();
//    }
//
//}