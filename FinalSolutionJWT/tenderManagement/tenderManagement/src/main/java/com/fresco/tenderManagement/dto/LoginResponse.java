package com.fresco.tenderManagement.dto;

public class LoginResponse {

	private String token;
	private long expirationTime;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}
	
}
