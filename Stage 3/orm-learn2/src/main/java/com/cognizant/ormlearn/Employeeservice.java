package com.cognizant.ormlearn;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Employeeservice {

	@Autowired
	EmployeeRepository employeerepository;
	
	
	@Transactional
	public Employee getById(int id) {
	return employeerepository.findById(id).get();
	}
	
	
	@Transactional
	public void save(Employee employee) {
	employeerepository.save(employee);

	}
	@Transactional
	public Optional<Employee> findEmployeeByID(int id)
	{
		return employeerepository.findById(id);
	}
	
	@Transactional
	public Set<Employee> findEmpByName(String name)
	{
		return employeerepository.findByName(name);
	}
	//department methods


	public Set<Employee> findEmpByDeptName(Department deptname) {
		return employeerepository.findBydepartment(deptname);
	}


	public List<Employee> getAllPermanentEmployees() {
		
		return employeerepository.getAllPermanentEmployees();
	}


	public double getAvgSalaryFromEmp() {
		return employeerepository.getAverageSalary();
	}
	
     public List<Employee> getAllEmployeeUsingNativeQuery() {
		
		return employeerepository.getAllEmployeesNative();
	}

	
	//skill methods
	



}
