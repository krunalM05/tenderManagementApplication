package com.fresco.tenderManagement.security;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JWTUtil implements Serializable{

	private static final long serialVersionUID = 654352132132L;
	
	public static final long JWT_TOKEN_VALIDITY = 500 * 60 * 60;
	
	public final String secretKey = "PDW5vPEVEqbPNvgtLKNJ9Q==";
	
	public String getUsernameFromToken(String token) {
		return null;
	}
	
	public Date getExpirationDateFromToken(String token) {
		return null;
	}

}
