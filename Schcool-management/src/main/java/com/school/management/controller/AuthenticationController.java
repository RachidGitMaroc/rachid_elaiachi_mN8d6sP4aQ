package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.security.AuthenticationRequest;
import com.school.management.security.AuthenticationResponse;
import com.school.management.security.JwtUserDetailsService;
import com.school.management.security.JwtUtil;


@RestController
@RequestMapping("/api")
public class AuthenticationController {

	private final JwtUserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;

	@Autowired
	public AuthenticationController(JwtUserDetailsService userDetailsService, JwtUtil jwtUtil) {
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
		// Perform authentication and generate JWT token
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		if (userDetails != null
				&& passwordEncoder().matches(authenticationRequest.getPassword(),userDetails.getPassword())) {
			String token = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(token));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}


	private PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
