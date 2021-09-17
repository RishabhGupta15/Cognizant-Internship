package com.cognizant.QuizAttemptDetail.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttemptDetail.Model.User;
import com.cognizant.QuizAttemptDetail.Repository.UserRepository;
@Service
public class UserService {
	@Autowired
	 private UserRepository userRepository;
	
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
	@Transactional
	public User getById(int id) {
		return userRepository.findById(id).get();
	}
}
