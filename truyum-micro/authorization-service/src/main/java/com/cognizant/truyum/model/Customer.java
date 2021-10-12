package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * Model class for customer
 * @author alka0
 *
 */

@Data
@Entity()
@Table(name="customer_auth")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	
	@Column(name = "name")
	@NotBlank(message = "User name cannot be emptyfrom customer")
	private String userName;
	
	@NotBlank(message = "Password cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	

}
