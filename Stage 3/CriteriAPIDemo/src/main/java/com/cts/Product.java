package com.cts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;
	private String name;
	private String customerReview;
	private String hardDiskSize;
	private String ramSize;
	private String cpuSpeed;
	private String operatingSystem;
	private double weight;
	private String cpu;



	public Product(String name, String customerReview, String hardDiskSize, String ramSize, String cpuSpeed,
			String operatingSystem, double weight, String cpu) {
		super();
		this.name = name;
		this.customerReview = customerReview;
		this.hardDiskSize = hardDiskSize;
		this.ramSize = ramSize;
		this.cpuSpeed = cpuSpeed;
		this.operatingSystem = operatingSystem;
		this.weight = weight;
		this.cpu = cpu;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerReview() {
		return customerReview;
	}

	public void setCustomerReview(String customerReview) {
		this.customerReview = customerReview;
	}

	public String getHardDiskSize() {
		return hardDiskSize;
	}

	public void setHardDiskSize(String hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", customerReview=" + customerReview + ", hardDiskSize="
				+ hardDiskSize + ", ramSize=" + ramSize + ", cpuSpeed=" + cpuSpeed + ", operatingSystem="
				+ operatingSystem + ", weight=" + weight + ", cpu=" + cpu + "]";
	}
	
	

}