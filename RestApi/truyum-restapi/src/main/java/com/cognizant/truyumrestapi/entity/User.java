package com.cognizant.truyumrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public User(String name) {
        this.name = name;
    }
}
