package com.example.demo.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	public UserDetails() {
		super();
	}
	 @Id
	 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
     
	 @Column(name = "user_id")
	private Long userId;
	 
	 @NotNull(message="Name is required")
	 @Column(name = "user_name")
private String userName;
	 
	 @NonNull()
	  @Email(message = "Invalid email format")
	 @Column(name = "user_email")
private String userEmail;
	 
	 @NotNull(message = "Password is required")
	 @Size(min = 6, message = "Password must be at least 6 characters")
	 @Column(name = "user_password")
private String password;
	 
	 
	 @NotNull(message="Role is required")
	 @Column(name = "user_type")
private String userType="user";
	 
	 
	 @Column(name="walletbalance")
	 private Long wallet;

	 @Column
	 private Long winningPrize;
public Long getWallet() {
		return wallet;
	}
	public void setWallet(Long wallet) {
		this.wallet = wallet;
	}
public Long getUser_id() {
	return userId;
}
public void setUser_id(Long user_id) {
	this.userId = user_id;
}
@Column(name = "User_ID")
public String getUser_name() {
	return userName;
}
public void setUser_name(String user_name) {
	this.userName = user_name;
}
public String getUser_email() {
	return userEmail;
}
public void setUser_email(String user_email) {
	this.userEmail = user_email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser_type() {
	return userType;
}
public void setUser_type(String user_type) {
	this.userType = user_type;
}
@Override
public String toString() {
	return "User_Registered [user_id=" + userId + ", user_name=" + userName + ", user_email=" + userEmail
			+ ", password=" + password + ", user_type=" + userType + "]";
}
public Long getWinningPrize() {
	return winningPrize;
}
public void setWinningPrize(Long winningPrize) {
	this.winningPrize = winningPrize;
}


}

