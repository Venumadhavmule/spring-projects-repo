package com.venu.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venu.springsecurity.model.User;
import com.venu.springsecurity.repository.UserRepository;
import com.venu.springsecurity.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthenticationManager authManager;

	private UserRepository userRepo;

	private JwtUtil jwtUtil;

	private PasswordEncoder passwordEncoder;

	public AuthController(AuthenticationManager authManager, UserRepository userRepo, JwtUtil jwtUtil,
			PasswordEncoder passwordEncoder) {
		this.authManager = authManager;
		this.userRepo = userRepo;
		this.jwtUtil = jwtUtil;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return ResponseEntity.ok("User registered");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
}
