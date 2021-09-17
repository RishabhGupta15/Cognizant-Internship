package com.cognizant.truyum.service;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public User getUser(long userId) throws Exception {
		User user=null;
		//LOGGER.info("Start");
		Optional<User> userobj= userRepository.findById((int)userId);
		if(Objects.nonNull(userobj)) {
			user=userobj.get();
		//LOGGER.debug("Users are :{}"+user);
		}else {
		throw new  Exception("User not found exception");
		}
		return user;
	}
}
