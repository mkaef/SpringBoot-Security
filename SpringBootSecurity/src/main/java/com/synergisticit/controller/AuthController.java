package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.component.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(req.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    static class AuthRequest {
        public String username, password;

		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
    }

    static class AuthResponse {
        public String token;
        public AuthResponse(String token) { this.token = token; }
    }

}
