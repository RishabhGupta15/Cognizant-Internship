package com.cognizant.truyumrestapi.dao;

import com.cognizant.truyumrestapi.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
