package com.cts.sr.moviecruiser.user.model;

import java.util.Base64;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.cts.sr.moviecruiser.user.data.UserDTO;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "User")
public class User {

	@Id
	private String userId;

	private String firstName;

	@PartitionKey
	private String lastName;

	private String email;

	private String password;

	private Date createdDate;

	public User(String userId, String firstName, String lastName, String email, String password, Date createdDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void copy(UserDTO user) {
		if (user.getUserId() != null)
			this.setUserId(user.getUserId());
		if (user.getFirstName() != null)
			this.setFirstName(user.getFirstName());
		if (user.getLastName() != null)
			this.setLastName(user.getLastName());
		if (user.getEmail() != null)
			this.setEmail(user.getEmail());
		if (user.getPassword() != null)
			this.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
	}
}
