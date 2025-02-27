package com.aimerz.employeemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.aimerz.employeemanagementsystem.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	List<Employee> employeeList = new ArrayList();
	@Override
	public Employee saveEmployee(Employee employee) {
		employeeList.add(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for(int i=0 ; i<employeeList.size();i++ ) {
			employee = employeeList.get(i); 
			
			if(id==employee.getId()) {
				return employee;  // returns employee object if found succesfully
			}else {
				continue;
			}
		}
		return null;
	}

	@Override
	public Employee updateEmployee(int id, double salary) {
		Employee employee = null;
		for(int i=0 ; i<employeeList.size();i++ ) {
			employee = employeeList.get(i); 
			
			if(id==employee.getId()) {
				  employee.setSalary(salary); // updates the salary
			}else {
				continue;
			}
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee employee = null;
		for(int i=0 ; i<employeeList.size();i++ ) {
			employee = employeeList.get(i); 
			
			if(id==employee.getId()) {   
				  employeeList.remove(i);   // delete the employee details
			}else {
				continue;
			}
		}
		System.out.println("Employee details have been deleted");
	}

}
