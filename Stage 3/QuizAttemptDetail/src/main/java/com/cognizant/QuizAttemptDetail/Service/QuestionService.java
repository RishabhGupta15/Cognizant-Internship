package com.cognizant.QuizAttemptDetail.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttemptDetail.Model.Question;
import com.cognizant.QuizAttemptDetail.Repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	 private QuestionRepository questionRepository;
	
	@Transactional
	public void save(Question question) {
		questionRepository.save(question);
	}
	@Transactional
	public Question getById(int id) {
		return questionRepository.findById(id).get();
	}
}
