package com.employee.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	
	@Column
	@Id
	private String employee_id;
	@Column
	private String name ;
	@Column
	private int salary ;
	@Column
	private String address ;
	@Column
	private String designation;
	@Column
	private String primary_skill ;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPrimary_skill() {
		return primary_skill;
	}
	public void setPrimary_skill(String primary_skill) {
		this.primary_skill = primary_skill;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ ", designation=" + designation + ", primary_skill=" + primary_skill + "]";
	}
	
	
}
