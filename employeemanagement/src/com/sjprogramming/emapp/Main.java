package com.sjprogramming.emapp;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		String name;
		int id;
		
		EmployeeDaoIntrf dao = new EmployeeDaoImpl();
		System.out.println("Welcome to Employee Management");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Add Employee\n" +
						"2. Show All Employees\n"    +
					    "3. Show Employee based on ID\n" +
						"4. Update the employee\n"     +
					    "5. Delete the employee\n" +
						"6. To Exit the program");
			
			System.out.println("Enter choice");
			int ch = sc.nextInt();
			switch(ch) {
				case 1:
					Employee emp = new Employee();
					System.out.println("Enter ID");
					id = sc.nextInt();
					System.out.println("Enter name");
					name = sc.next();
					System.out.println("Enter the salary");
					double salary = sc.nextDouble();
					System.out.println("Enter the age");
					int age = sc.nextInt();
					emp.setId(id);
					emp.setName(name);
					emp.setSalary(salary);
					emp.setAge(age);
					dao.createEmployee(emp);
					break;
				case 2:
					dao.showAllEmployee();
					break;
				case 3:
					System.out.println("Enter ID to show the details.");
					int empid = sc.nextInt();
					dao.showEmployeeBasedOnID(empid);
				case 4:
					System.out.println("Enter ID to update");
					int empid1 = sc.nextInt();
					System.out.println("What would you like to update?\n" +
										"1. Name\n" +
										"2. Salary\n" + 
										"3. Age");
					int choice = sc.nextInt();
					if(choice == 1) {
						System.out.println("Enter the new name");
						name = sc.next();
						dao.updateEmployee(empid1, name);
						break;
					}
					
					if (choice == 2) {
						System.out.println("Enter the new salary");
						salary = sc.nextDouble();
						dao.updateEmployeeSalary(empid1, salary);
						break;
					}
					
					if(choice == 3) {
						System.out.println("Enter the new age");
						age = sc.nextInt();
						dao.updateEmployeeAge(empid1, age);
						break;
					}
				case 5:
					System.out.println("Enter the ID to delete");
					id = sc.nextInt();
					dao.deleteEmployee(id);
					break;
				case 6:
					System.out.println("Thanks for using the program.");
					System.exit(0);
				default:
					System.out.println("Enter valid choice!");
					break;
				
			}
			
		} while(true);
	}

}
