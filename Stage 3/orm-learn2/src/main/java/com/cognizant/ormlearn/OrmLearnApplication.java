package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static Employeeservice empservice;
	private static Departmentservice deptservice;
	private static Skillservice skillservice;

//     private static void testGetEmployee() {
//
//			LOGGER.info("Start");
//
//			Employee employee = empservice.get(1);
//
//			LOGGER.debug("Employee:{}", employee);
//
//			LOGGER.debug("Department:{}", employee.getDepartment());
//
//			LOGGER.info("End");
//
//			}
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		System.out.println("context created");
		deptservice = context.getBean(Departmentservice.class);
		empservice = context.getBean(Employeeservice.class);
		skillservice = context.getBean(Skillservice.class);
//		testAddEmployee();
//		 testAddDepartment();
//		 testAddSkill();
//	     testUpdateEmployeeByEmpId(2,"Prakash");
//	      testGetEmployeeById(1);
//	      testGetEmployeeById(2);
//		 testGetEmpSkillById(2);
//		 testUpdateEmployeeSalaryByDeptId(1,400000);
//	      testAddSkillToEmpById(1,"Core Java");
//		  testFindSkillByName("AJ");
//		 testGetAllPermanentEmployees();
//		 testGetAvgSalaryEmp();
//		testgetAllEmployeeUsingNativeQuery();
	}

	private static void testgetAllEmployeeUsingNativeQuery() {
		empservice.getAllEmployeeUsingNativeQuery();
	}

	private static void testGetAvgSalaryEmp() {

		double emp = empservice.getAvgSalaryFromEmp();
	}

	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");

		List<Employee> employees = empservice.getAllPermanentEmployees();

		LOGGER.debug("Permanent Employees:{}", employees);

		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

		LOGGER.info("End");
	}

	private static void testFindSkillByName(String skillName) {
		LOGGER.info("getting skill by id started");
		Optional<Skill> optional1 = skillservice.findSkillByName(skillName);
		if (optional1.isPresent()) {
			String skill = optional1.get().getName();
			System.out.println("Employee skills are " + skill);
		} else {
			System.out.println("not found any skill");
		}
		LOGGER.info("getting skill by id ended");
	}

	private static void testGetEmpSkillById(int id) {
		LOGGER.info("getting employee skill by id started");
		Optional<Employee> optional = empservice.findEmployeeByID(id);
		if (optional.isPresent()) {
			Set<Skill> skills = optional.get().getSkillList();
			String name = optional.get().getName();
			System.out.println("Skills of " + name + " are " + skills);
		} else {
			System.out.println("Employee not found");
		}
		LOGGER.info("getting employee skill by id ended");
	}

	private static void testAddSkillToEmpById(int id, String skillname) {
		LOGGER.info("Add skill to employee by id started");
		Optional<Employee> optional = empservice.findEmployeeByID(id);
		if (optional.isPresent()) {
			Optional<Skill> optional1 = skillservice.findSkillByName(skillname);
			if (optional1.isPresent()) {
				Employee emp = optional.get();
				Set<Skill> skill = new HashSet<Skill>();
				skill.add(optional1.get());
				emp.setSkillList(skill);
				empservice.save(emp);
			} else {
				Skill skill = new Skill(skillname);
				skillservice.save(skill);
				Optional<Skill> optional2 = skillservice.findSkillByName(skillname);
				Employee emp = optional.get();
				Set<Skill> skill1 = new HashSet<Skill>();
				skill1.add(optional2.get());
				emp.setSkillList(skill1);
				empservice.save(emp);
			}
		} else {
			System.out.println("Employee not found");
		}
		LOGGER.info("Add skill to employee by id ended");
	}

	private static void testAddSkill() {
		LOGGER.info("Start of  testAddSkill");
		// Skill skillvar= new Skill();
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new Skill("Java"));
		skillList.add(new Skill("Sql"));
		skillList.add(new Skill("Html"));
		skillservice.save(skillList.get(0));
		skillservice.save(skillList.get(1));
		skillservice.save(skillList.get(2));
		LOGGER.info("End of  testAddSkill");
	}

	private static void testAddDepartment() {
		LOGGER.info("Start of  testAddDepartment");
		Department dept = new Department("training");
		deptservice.save(dept);
		LOGGER.info("End of  testAddDepartment");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start of  testAddDepartment");
		Department depobj = deptservice.get(1);
		System.out.println("dep obj =" + depobj);
		Set<Employee> empList = new HashSet<Employee>();
		Date dateobj = new Date();
		empList.add(new Employee("Rahul", depobj, 25000, true, dateobj));
		empList.add(new Employee("Rama", depobj, 50000, true, dateobj));
		depobj.setEmployeeList((Set<Employee>) empList);
		for (Employee empObj : empList) {
			empservice.save(empObj);
		}
		LOGGER.info("End of  testEmployeeDepartment");
	}

	private static Employee testGetEmployeeById(int id) {
		LOGGER.info("get employee by id started");
		Optional<Employee> optional = empservice.findEmployeeByID(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			System.out.println("no records found with this id");
		}
		LOGGER.info("get employee by id ended");
		return employee;
	}

	private static void testUpdateEmployeeByEmpId(int id, String name) {
		LOGGER.info("Employee Update started");
		Optional<Employee> optional = empservice.findEmployeeByID(id);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setName(name);
			empservice.save(employee);
		} else {
			System.out.println("no records found with this id");
		}
		LOGGER.info("Employee Update Ended");
	}

	private static void testUpdateEmployeeSalaryByDeptId(int id, double salary) {
		LOGGER.info("Employee Update started using department id");

		Optional<Department> optional2 = deptservice.findDepartmentByID(id);
		if (optional2.isPresent()) {
			Department department = optional2.get();
			// String deptname=department.getName();
			Set<Employee> optional1 = empservice.findEmpByDeptName(department);
			if (!(optional1.size() == 0)) {
				// List<Employee> employee= new ArrayList<Employee>();
				for (Employee empObj : optional1) {
					Employee emp = empObj;
					emp.setSalary(salary);
					empservice.save(emp);
//		            int id1=emp.getId();
//					Optional<Employee> optional=empservice.findEmployeeByID(id1);
//					   Employee employee1=optional.get();
//					  employee1.setSalary(salary);
//				       empservice.save(employee1);
				}
			} else {
				System.out.println("no employees are in this department found");
			}
		} else {
			System.out.println("no records found with this id");
		}
		LOGGER.info("Employee Update Ended using department id");
	}
}