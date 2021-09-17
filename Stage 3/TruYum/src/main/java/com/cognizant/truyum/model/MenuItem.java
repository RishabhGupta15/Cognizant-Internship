package com.cognizant.truyum.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="menu_item")
@Data
public class MenuItem {
	@Id
	@Column(name="me_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="me_name")
	private String name;
	@Column(name="me_price", columnDefinition = "decimal", precision = 8, scale = 2)
	private double price;
	@Column(name="me_active")
	private String active;
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name="me_category")
	private String category;
	@Column(name="me_free_delivery")
	private String freeDelivery;
	
	@OneToMany(mappedBy = "menuItem", fetch = FetchType.EAGER)
	private List<Cart> carts;
}
