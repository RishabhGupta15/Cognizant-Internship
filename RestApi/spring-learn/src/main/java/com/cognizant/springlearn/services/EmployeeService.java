package com.cognizant.springlearn.services;

import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.exceptions.EmployeeNotFound;
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

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");;
    List<Employee> listOfEmployees = applicationContext.getBean("employeeList", ArrayList.class);
    List<Department> listOfDepartment = applicationContext.getBean("departmentList",ArrayList.class);

    public List<Employee> getAllEmployees(){
        return this.listOfEmployees;
    }

    public List<Department> getAllDepartments(){
        return this.listOfDepartment;
    }

    public void updateEmployee(int empId, Employee newEmp) throws EmployeeNotFound {
        for(Employee e: listOfEmployees){
            if(e.getId() == empId){
                e = newEmp;
                return;
            }
        }
        throw new EmployeeNotFound();
    }
}
