package com.sjprogramming.emapp;

public interface EmployeeDaoIntrf {
	
	// Create employee
	public void createEmployee(Employee emp);
	// SHow all employee
	public void showAllEmployee();
	// Show employee based on Id
	public void showEmployeeBasedOnID(int id);
	//update employee name 
	public void updateEmployee(int id, String name);
	//update employee salary
	public void updateEmployeeSalary(int id, double salary);
	//update the employee age
	public void updateEmployeeAge(int id, int age);
	//delete employee
	public void deleteEmployee(int id);

}
