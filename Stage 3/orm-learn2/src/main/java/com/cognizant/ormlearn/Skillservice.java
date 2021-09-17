package com.cognizant.ormlearn;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Skillservice {

	@Autowired
	SkillRepository skillrepository;
	
	
//	@Transactional
//
//	public Skill get(int id) {
//
//	//LOGGER.info("Start");
//
//	return skillrepository.findById(id).get();
//
//	}
	public void save(Skill skill) {

		skillrepository.save(skill);

		//LOGGER.info("End");

		}


	public Optional<Skill> findSkillByName(String skillname) {
		// TODO Auto-generated method stub
		return skillrepository.findSkillByNameIgnoringCase(skillname);
	}
	

}
