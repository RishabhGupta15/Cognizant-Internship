package com.cognizant.ormlearn;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Set<Employee> findByName(String name);


	public Set<Employee> findBydepartment(Department deptname);
	
	@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();
	
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();


	
}