package com.wnjd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true)
public class SecurityConfig {
   @Bean
      SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.authorizeHttpRequests((authorizeHttpRequest) -> authorizeHttpRequest
               .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()) // 모든 주소로 동작하는 것들을 permialAll()함.
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
               .csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/**")))
               .formLogin((formLogin) -> formLogin.loginPage("/user/login").defaultSuccessUrl("/sku/list"))
               .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                   .logoutSuccessUrl("/sku/list").invalidateHttpSession(true));

         return http.build();

   }
   
   @Bean
      PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
      }

}