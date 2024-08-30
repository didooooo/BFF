package com.tinqinacademy.bff.rest.security;

import com.tinqinacademy.authentication.api.operation.auth.AuthOutput;
import com.tinqinacademy.authentication.restexport.RestExportAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final RestExportAuthentication restExportAuthentication;
    private final JwtDecoder jwtDecoder;
    private final UserContext userContext;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        AuthOutput jwtValid = restExportAuthentication.isJwtValid(authorizationHeader);
        if (!jwtValid.getIsJwtValid()) {
            filterChain.doFilter(request, response);
            return;
        }

        Map<String, Object> claims = jwtDecoder.decodeJwt(authorizationHeader);
        String userId = (String) claims.get("sub");
        String role = (String) claims.get("role");

        UserDetailsModel userDetailsModel = UserDetailsModel.builder()
                .username(userId)
                .role(role)
                .build();
        Authentication authentication = new CustomAuthToken(userDetailsModel);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        userContext.setContext(userId);

        filterChain.doFilter(request, response);
    }

}
