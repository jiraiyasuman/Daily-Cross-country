package com.aimerz.employeemanagementsystem.entity;

public class Employee {

	private int id;
	private String employeeName;
	private String department;
	private String designation;
	private double salary;
	private long phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Employee(int id, String employeeName, String department, String designation, double salary,
			long phoneNumber) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", department=" + department + ", designation="
				+ designation + ", salary=" + salary + ", phoneNumber=" + phoneNumber + ", getId()=" + getId()
				+ ", getEmployeeName()=" + getEmployeeName() + ", getDepartment()=" + getDepartment()
				+ ", getDesignation()=" + getDesignation() + ", getSalary()=" + getSalary() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
