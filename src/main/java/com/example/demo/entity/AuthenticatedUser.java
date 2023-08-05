package com.example.demo.entity;


public class AuthenticatedUser {
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	private Long UserId;
	private String Email;
	

}
