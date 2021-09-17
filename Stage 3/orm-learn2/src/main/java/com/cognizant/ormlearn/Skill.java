package com.cognizant.ormlearn;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int id;
	@Column(name = "skill_name")
	private String name;
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	@ManyToMany
	//@JoinTable
	@JoinColumn(name = "es_em_id")
	private Set<Employee> employeeList;

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

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
	public Skill(String name) {
		super();
		this.name = name;
	}
	public Skill() {
		
	}

	
}
