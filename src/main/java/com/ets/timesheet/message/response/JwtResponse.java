package com.ets.timesheet.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
 
    public JwtResponse(String accessToken, String username, Collection<? extends GrantedAuthority> auth) {
        this.token = accessToken;
        this.username = username;
        this.authorities = auth;
    }
 

	public String getAccessToken() {
        return token;
    }
 
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }
 
    public String getTokenType() {
        return type;
    }
 
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
    
    public void setUsername(String username) {
		this.username = username;
	}
    
    public String getUsername() {
		return username;
	}
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
    
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
