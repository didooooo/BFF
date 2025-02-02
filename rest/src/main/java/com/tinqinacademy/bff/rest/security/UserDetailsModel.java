package com.tinqinacademy.bff.rest.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsModel implements UserDetails {
    private String username;
    private String role;
    //todo
    //health check
    //grafana
    //blue green deployment

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE "+role.toUpperCase()));
    }

    @Override
    public String getPassword() {
        return null;
    }

}
