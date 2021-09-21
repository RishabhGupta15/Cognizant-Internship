package com.cognizant.springlearn.services;

import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    ApplicationContext applicationContext;

    public List<Employee> getAllEmployees(){
        applicationContext = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> listOfEmployees = applicationContext.getBean("employeeList", ArrayList.class);
        return listOfEmployees;
    }

    public List<Department> getAllDepartments(){
        applicationContext = new ClassPathXmlApplicationContext("employee.xml");
        List<Department> listOfDepartment = applicationContext.getBean("departmentList",ArrayList.class);
        return listOfDepartment;
    }
}
