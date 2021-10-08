package com.cognizant.truyum.customerservice.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
	private List<MenuItem> cart;

	public User() {
	}

	public User(int id, String name, List<MenuItem> cart) {
		super();
		this.id = id;
		this.name = name;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuItem> getCart() {
		return cart;
	}

	public void setCart(List<MenuItem> cart) {
		this.cart = cart;
	}
	
}
