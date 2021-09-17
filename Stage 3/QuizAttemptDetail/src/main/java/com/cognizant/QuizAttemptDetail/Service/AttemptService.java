package com.cognizant.QuizAttemptDetail.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttemptDetail.Model.Attempt;
import com.cognizant.QuizAttemptDetail.Repository.AttemptRepository;

@Service
public class AttemptService {
	@Autowired
	private AttemptRepository attemptRepository;
	
	@Transactional
	public void save(Attempt attempt) {
		attemptRepository.save(attempt);
	}
	@Transactional
	public Attempt getById(int id) {
		return attemptRepository.findById(id).get();
	}
	@Transactional
	public Attempt getAttempt(int userId, int attemptId) {
		return attemptRepository.getAttempt(userId, attemptId);
	}
}
