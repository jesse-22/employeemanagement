package com.sjprogramming.emapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {

	Connection con;
	
	@Override
	public void createEmployee(Employee emp) {
		con = DBConnection.createDBConnection();
		String query= "insert into employee values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());
			int cnt = pstm.executeUpdate();
			if(cnt != 0) {
				System.out.println("Employee inserted successfully.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void showAllEmployee() {
		con = DBConnection.createDBConnection();
		String query= "select * from employee";
		System.out.println("Employee Details :");
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name","Salary","Age");
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
				System.out.println("____________________________");
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedOnID(int id) {
		con = DBConnection.createDBConnection();
		String query = "select * from employee where id="+id;
		System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name","Salary","Age");
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
				System.out.println("____________________________");
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		con = DBConnection.createDBConnection();
		String query = "update employee set name=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			int cnt = pstm.executeUpdate();
			if (cnt !=0) {
				System.out.println("Employee details updated successfully");
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateEmployeeSalary(int id, double salary) {
		con = DBConnection.createDBConnection();
		String query = "update employee set salary=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setDouble(1, salary);
			pstm.setInt(2, id);
			int cnt = pstm.executeUpdate();
			if (cnt !=0) {
				System.out.println("Employee details updated successfully");
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateEmployeeAge(int id, int age) {
		con = DBConnection.createDBConnection();
		String query = "update employee set age=? where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, age);
			pstm.setInt(2, id);
			int cnt = pstm.executeUpdate();
			if (cnt !=0) {
				System.out.println("Employee details updated successfully");
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		con = DBConnection.createDBConnection();
		String query = "delete from employee where id=?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			int cnt = pstm.executeUpdate();
			if (cnt!=0) {
				System.out.println("Employee deleted successfully");
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
