package com.synergisticit.component;

import java.util.Date;
import java.security.Key;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	 private static final String SECRET = "MySuperSecretKeyForJwtGeneration123456"; // At least 32 characters!
	    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

	    public static String generateToken(String username) {
	        return ((JwtBuilder) Jwts.builder())
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
	                .signWith(key, SignatureAlgorithm.HS256)
	                .compact();
	    }

		public String extractUsername(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isTokenValid(String token, String username) {
			// TODO Auto-generated method stub
			return false;
		}

		
}
