package com.example.SecurityUser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usersecurity")
public class UserModel {

	@Id
	private String Id;
	private String username;
	private String password;
	
	public UserModel() {
		}

	public String getId() {
		return Id;
	}

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
	
	
}
