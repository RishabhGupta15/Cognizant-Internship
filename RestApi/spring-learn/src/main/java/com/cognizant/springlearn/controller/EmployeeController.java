package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("departments")
    public List<Department> getAllDepartments(){
        List<Department> departments = employeeService.getAllDepartments();
        return departments;
    }
}
