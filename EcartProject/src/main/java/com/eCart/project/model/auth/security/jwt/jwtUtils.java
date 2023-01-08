package com.eCart.project.model.auth.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class jwtUtils {
	
	private final Logger logger =  LoggerFactory.getLogger(jwtUtils.class);
	
	@Value("${eCart.app.jwtCookieName}")
	private String jwtSecret;
	@Value("${eCart.app.jwtExpirationMs}")
	private Integer jwtExpirationMs;
	@Value("${eCart.app.jwtCookie}")
	private String jwtCookie;
}
