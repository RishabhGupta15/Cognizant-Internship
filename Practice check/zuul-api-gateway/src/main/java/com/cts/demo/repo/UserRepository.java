package com.cts.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findUserByUserName(String username);
}
