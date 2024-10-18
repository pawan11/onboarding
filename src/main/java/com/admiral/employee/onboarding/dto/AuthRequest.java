package com.admiral.employee.onboarding.dto;

import java.util.Objects;

public class AuthRequest {

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthRequest other = (AuthRequest) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AuthRequest() {
		super();
		this.username = null;
		this.password = null;
	}

	@Override
	public String toString() {
		return "AuthRequest [username=" + username + ", password=" + password + "]";
	}
}
