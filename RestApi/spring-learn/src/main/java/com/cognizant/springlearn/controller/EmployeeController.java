package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.exceptions.EmployeeNotFound;
import com.cognizant.springlearn.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/employees/update/{id}")
    public void updateEmployee(@RequestBody @Valid Employee employee, @PathVariable("id") int empId ) throws EmployeeNotFound {
        logger.info("{}", employeeService.getAllEmployees());
        employeeService.updateEmployee(empId, employee);
        logger.info("{}", employeeService.getAllEmployees());
    }

    @PostMapping("/employees/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int empId) throws EmployeeNotFound {
        logger.info("{}", employeeService.getAllEmployees());
        employeeService.removeEmployee(empId);
        logger.info("{}", employeeService.getAllEmployees());
    }

    @PostMapping("employees/add")
    public void addEmployee(@RequestBody @Valid Employee employee){
        logger.info("{}", employeeService.getAllEmployees());
        employeeService.addEmployee(employee);
        logger.info("{}", employeeService.getAllEmployees());
    }
}
