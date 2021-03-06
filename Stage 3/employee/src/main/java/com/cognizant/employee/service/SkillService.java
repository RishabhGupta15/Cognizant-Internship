package com.cognizant.employee.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employee.Repository.SkillRepository;
import com.cognizant.employee.model.Skill;

@Service
public class SkillService {
	@Autowired
	SkillRepository skillRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
	
	@Transactional
	public Skill get(int id) {
		LOGGER.info("Start");
		return skillRepository.findById(id).get();
	}

	@Transactional
	public void save(Skill skill) {
		LOGGER.info("Start");
		skillRepository.save(skill);
		LOGGER.info("End");
	}
}
