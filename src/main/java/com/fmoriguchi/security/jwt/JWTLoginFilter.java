/**
 * 
 */
package com.fmoriguchi.security.jwt;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author fmoriguchi
 *
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(url));
		this.setAuthenticationManager(authenticationManager);
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

		 Credentials creds = new ObjectMapper()
			        .readValue(request.getInputStream(), Credentials.class);
		 
		 
		 return getAuthenticationManager().authenticate(
			        new UsernamePasswordAuthenticationToken(
			            creds.getUsername(),
			            creds.getPassword(),
			            Collections.emptyList()
			        )
			    );
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
	
		TokenAuthenticationUtils.addAuthentication(response, auth.getName());
	}
}
