package com.cognizant.truyum.customerservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="user")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade =CascadeType.MERGE)
	@JoinTable(name="menuuser",joinColumns = @JoinColumn(name="menu_item_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<MenuItem> cart;

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cart=" + cart + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
