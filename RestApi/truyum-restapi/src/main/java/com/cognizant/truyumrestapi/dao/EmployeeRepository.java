package com.cognizant.truyumrestapi.dao;

import com.cognizant.truyumrestapi.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
