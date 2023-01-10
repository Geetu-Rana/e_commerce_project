package com.eCart.project.model.auth.security.jwt;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.eCart.project.model.auth.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class jwtUtils {
	
	private final Logger logger =  LoggerFactory.getLogger(jwtUtils.class);
	
	@Value("${eCart.app.jwtCookieName}")
	private String jwtSecret;
	@Value("${eCart.app.jwtExpirationMs}")
	private Integer jwtExpirationMs;
	@Value("${eCart.app.jwtCookie}")
	private String jwtCookie;
	
	public String getJwtFromCookies(HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, jwtCookie);
		
		if(cookie != null) {
			return cookie.getValue();
		}else {
			return "No User or Admin Logged in";
		}	
	}
	public ResponseCookie generateJwtCookie(UserDetailsImpl userPrinciple ) {
		String jwt = generateTokenFromUsername(jwtCookie);
		ResponseCookie cookie = ResponseCookie.from(userPrinciple.getUsername(), jwt).path("/api")
								.maxAge(24*60*60).httpOnly(true).build();
		return cookie;
	}
	
	public ResponseCookie getCleanJwtCookie() {
		ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
		return cookie;
	}
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}catch (SignatureException e) {
			// TODO: handle exception
			logger.error("Invalid JWT signature : {} ", e.getMessage());
		}catch (MalformedJwtException e) {
			// TODO: handle exception
			logger.error("Invalid JWT token : {} ", e.getMessage());
		}catch(ExpiredJwtException e) {
			logger.error("JWT token is expired : {} ", e.getMessage());
		}catch(UnsupportedJwtException e) {
			logger.error("JWT token is unsupported : {} ", e.getMessage());
		}catch(IllegalArgumentException e) {
			logger.error("JWT claims String is empty : {} ", e.getMessage());
		}
		
		return false;
	}
	
	public String generateTokenFromUsername(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
}
