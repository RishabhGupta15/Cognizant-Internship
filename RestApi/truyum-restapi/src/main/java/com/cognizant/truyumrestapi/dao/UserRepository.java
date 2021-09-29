package com.cognizant.truyumrestapi.dao;

import com.cognizant.truyumrestapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
