package com.cognizant.config;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	private int id;
	private String username;
	private String password;
	private String roles;
	private boolean active;
}
