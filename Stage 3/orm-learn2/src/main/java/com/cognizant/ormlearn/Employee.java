package com.cognizant.ormlearn;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Department department, double salary, boolean permanent, Date dateOfBirth) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int id;
	public Employee(int id, String name, Department department, double salary, boolean permanent, Date dateOfBirth) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "emp_name")
	private String name;
	@ManyToOne
	//@JoinTable
	@JoinColumn(name = "em_dp_id")
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Column(name = "emp_salary")
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "permanent")
	private boolean permanent;
	@Column(name = "DOB")
	private Date dateOfBirth;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="employee_skill",joinColumns=@JoinColumn(name="es_em_id"),inverseJoinColumns=@JoinColumn(name="es_sk_id"))
	  private Set<Skill> skillList;
	
	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	public void setSkillList(Skill skill) {
		this.skillList = skillList;
	}

}
