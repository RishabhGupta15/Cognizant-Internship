package com.cognizant.truyum.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cart")
@Data
public class Cart {
	@Id
	@Column(name="ca_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="cart_user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="cart_item_id")
	private MenuItem menuItem;
}
