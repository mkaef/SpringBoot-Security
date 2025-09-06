package com.synergisticit.component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.synergisticit.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	 @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private CustomUserDetailsService userDetailsService;

	    @Override
	    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
	            throws ServletException, IOException {
	        String header = req.getHeader("Authorization");
	        if (header != null && header.startsWith("Bearer ")) {
	            String token = header.substring(7);
	            String username = jwtUtil.extractUsername(token);
	            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                if (jwtUtil.isTokenValid(token, userDetails.getUsername())) {
	                    UsernamePasswordAuthenticationToken auth =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
	                    SecurityContextHolder.getContext().setAuthentication(auth);
	                }
	            }
	        }
	        filterChain.doFilter(req, res);
	    }

}
