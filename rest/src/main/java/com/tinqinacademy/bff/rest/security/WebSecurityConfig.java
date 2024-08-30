package com.tinqinacademy.bff.rest.security;

import com.tinqinacademy.bff.api.exceptions.customExceptions.NotFoundException;
import com.tinqinacademy.bff.api.mapping.URLMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    UserDetailsService emptyDetailsService() {
        return username -> {
            try {
                throw new NotFoundException();
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        secureAdminEndpoints(http);
        secureUserEndpoints(http);
        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint));
        http.sessionManagement((sessionManagement)-> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    private void secureAdminEndpoints(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, URLMapping.REGISTER).hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, URLMapping.REGISTER).hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, URLMapping.POST_ROOM).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, URLMapping.SYSTEM_ROOM_BY_ID).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, URLMapping.SYSTEM_ROOM_BY_ID).hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, URLMapping.SYSTEM_ROOM_BY_ID).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, URLMapping.EDIT_A_COMMENT_BY_ADMIN).hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, URLMapping.DELETE_A_COMMENT).hasRole("ADMIN")
        );
    }

    private void secureUserEndpoints(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, URLMapping.GET_ROOM_BY_ID).hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, URLMapping.UNBOOK_ROOM_BY_ID).hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, URLMapping.LEAVE_A_COMMENT).hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.PATCH, URLMapping.EDIT_A_COMMENT).hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,URLMapping.CHECK_ROOM_AVAILABILITY).hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.GET,URLMapping.GET_ALL_COMMENTS).hasAnyRole("USER","ADMIN")
        );
    }
}