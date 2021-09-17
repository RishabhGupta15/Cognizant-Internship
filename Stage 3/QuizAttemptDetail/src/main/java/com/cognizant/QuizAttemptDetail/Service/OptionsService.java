package com.cognizant.QuizAttemptDetail.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttemptDetail.Model.Options;
import com.cognizant.QuizAttemptDetail.Repository.OptionsRepository;

@Service
public class OptionsService {
	@Autowired
	private OptionsRepository optionsRepository;
	
	@Transactional
	public void save(Options options) {
		optionsRepository.save(options);
	}
	@Transactional
	public Options getById(int id) {
		return optionsRepository.findById(id).get();
	}
}
