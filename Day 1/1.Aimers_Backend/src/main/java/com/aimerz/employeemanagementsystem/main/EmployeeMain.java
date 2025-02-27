/**
 * 
 */
package com.aimerz.employeemanagementsystem.main;
import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.aimerz.employeemanagementsystem.dao.EmployeeDao;
import com.aimerz.employeemanagementsystem.entity.Employee;
/**
 * 
 */
public class EmployeeMain {

	static private EmployeeDao employeeDao;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter 1. to add an employee ");
			System.out.println("Please enter 2. to view all employees ");
			System.out.println("Please enter 3. to view an employee ");
			System.out.println("Please enter 4. to update an employee ");
			System.out.println("Please enter 5. to delete an employee ");
			System.out.println("Please enter the choice");
			int choice=Integer.parseInt(BR.readLine());
			switch (choice) {
			case 1:
				System.out.println("Please enter the number of the employee");
				int number = Integer.parseInt(BR.readLine());
				System.out.println("Please enter the name of the employee");
				String name=BR.readLine();
				System.out.println("Please enter the department of the employee");
				String department= BR.readLine();
				System.out.println("Please enter the designation of the employee");
				String designation=BR.readLine();
				System.out.println("Please enter the salary of the employee");
				double salary = Double.parseDouble(BR.readLine());
				System.out.println("Please enter the phone Number of the employee");
				int phoneNumber=Integer.parseInt(BR.readLine());
				// enter the values in the array
				Employee emp =new Employee();
				emp.setId(number);
				emp.setEmployeeName(name);
				emp.setDepartment(department);
				emp.setDesignation(designation);
				emp.setSalary(salary);
				emp.setPhoneNumber(phoneNumber);
				employeeDao.saveEmployee(emp);
				break;
			case 2:
				List<Employee> empList = new ArrayList();
				empList = employeeDao.getAllEmployees();
				Employee employee=null;
				for(int i=0;i<empList.size();i++) {
					employee = empList.get(i);
					System.out.println(employee.getId()+" "+employee.getEmployeeName()+" "+employee.getDepartment()+" "+employee.getDesignation()+" "+employee.getSalary()+" "+employee.getPhoneNumber());
					
				}
				break;
			case 3:
				System.out.println("Please enter the id");
				int id=Integer.parseInt(BR.readLine());
				employee = employeeDao.getEmployeeById(id);
				System.out.println(employee.getId()+" "+employee.getEmployeeName()+" "+employee.getDepartment()+" "+employee.getDesignation()+" "+employee.getSalary()+" "+employee.getPhoneNumber());
				break;
			case 4:
				System.out.println("Please enter the id");
				int id1=Integer.parseInt(BR.readLine());
				System.out.println("Please enter the salary");
				double salary2 = Double.parseDouble(BR.readLine());
				employee = employeeDao.updateEmployee(id1, salary2);
				System.out.println(employee.getId()+" "+employee.getEmployeeName()+" "+employee.getDepartment()+" "+employee.getDesignation()+" "+employee.getSalary()+" "+employee.getPhoneNumber());
				break;
			case 5:
				
				System.out.println("Please enter the id");
				int id2=Integer.parseInt(BR.readLine());
				employeeDao.deleteEmployeeById(id2);
			default:
				System.out.println("Wrong choice");
				break;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
