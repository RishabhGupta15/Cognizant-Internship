package com.cognizant.ormlearn;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Departmentservice {

	@Autowired
	DepartmentRepository departmentrepository;
	
	
	@Transactional
	public Department get(int id) 
	{
	return departmentrepository.findById(id).get();
     }
	@Transactional
	public void save(Department department) {
		departmentrepository.save(department);
	}
	@Transactional
	public Optional<Department> findDepartmentByID(int id) 
	{
	return departmentrepository.findById(id);
     }
}
