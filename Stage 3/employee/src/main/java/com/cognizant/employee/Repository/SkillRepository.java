package com.cognizant.employee.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employee.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>  {

}
