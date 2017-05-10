/**
 * 
 */
package com.fmoriguchi.security.jwt;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author japa
 *
 */
public final class TokenAuthenticationUtils {
	
	private static final long EXPIRATION_TIME = 60;//SECONDS
	private static final String SECRET = "MARIAELISAMORIGUCHI";
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STRING = "Authorization";
	
	static void addAuthentication(HttpServletResponse response, String username) {
		
		String jwt = Jwts.builder()
				         .setSubject(username)
				         .setExpiration(expiration())
				         .signWith(SignatureAlgorithm.HS512, SECRET)
				         .compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
		
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
	    
		String token = request.getHeader(HEADER_STRING);
		    
	    if (token != null) {
	      String user = Jwts.parser()
	          .setSigningKey(SECRET)
	          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
	          .getBody()
	          .getSubject();

	      return user != null ?
	          new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
	          null;
	    }
	    return null;
	}
	
	static Date expiration() {
		
		return Date.from(Instant.now().plusSeconds(EXPIRATION_TIME));
	}

}
