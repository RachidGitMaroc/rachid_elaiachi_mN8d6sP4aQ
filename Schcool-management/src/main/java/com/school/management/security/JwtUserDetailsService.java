package com.school.management.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            // Creating a UserDetails object for the admin user
            return User.builder()
                    .username("admin")
                    .password("admin") // Using "{noop}" to indicate plain text password (not recommended in production)
                    .roles("ADMIN")
                    .build();
        } else if ("user".equals(username)) {
            // Creating a UserDetails object for the regular user
            return User.builder()
                    .username("user")
                    .password("user") // Using "{noop}" to indicate plain text password (not recommended in production)
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}