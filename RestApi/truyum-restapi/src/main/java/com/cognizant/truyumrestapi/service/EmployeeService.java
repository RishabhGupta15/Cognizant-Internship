package com.cognizant.truyumrestapi.service;

import com.cognizant.truyumrestapi.dao.EmployeeRepository;
import com.cognizant.truyumrestapi.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void displayAllEmployees(){
        ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
        log.info("{}", employees.toString());
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
        log.info("{}", employee);
    }
}
