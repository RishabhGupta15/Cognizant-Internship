package com.cognizant.truyumrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="user_name")
    private String name;
    @Column(name="user_role")
    private String role;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Cart> carts;
}
