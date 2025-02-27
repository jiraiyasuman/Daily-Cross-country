package com.aimerz.employeemanagementsystem.dao;

import java.util.List;

import com.aimerz.employeemanagementsystem.entity.Employee;

public interface EmployeeDao {

	public Employee saveEmployee(Employee employee);  // saves the Employee details
	
	public List<Employee> getAllEmployees(); // get the list of employees
	
	public Employee getEmployeeById(int id);  // get Employee by Id
	
	public Employee updateEmployee(int id,double salary);  // update employee by id
	
	public void deleteEmployeeById(int id);  // delete Employee by id
}
