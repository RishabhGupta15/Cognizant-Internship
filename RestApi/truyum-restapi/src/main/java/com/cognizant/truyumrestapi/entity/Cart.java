package com.cognizant.truyumrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
