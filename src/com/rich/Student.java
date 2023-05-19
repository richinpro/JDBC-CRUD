package com.rich;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	public void createDatabase() {
		try {
			
			//2. connection establishment
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = "rIchU@13";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			//3. statement create
			Statement stm = conn.createStatement();
		
			//4. execute query
			String query = "create database mydata";
			stm.execute(query);
			System.out.println("databse created successfully ");
			System.out.println("Connected successfully");
			
			//5. conn close
		//	conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/mydata";
			String userName = "root";
			String password = "rIchU@13";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			//3. statement create
			Statement stm = conn.createStatement();
		
			//4. execute query
			String query = "create table student (sid int(3), sname varchar(200), semail varchar(200))";
			stm.execute(query);
			System.out.println("table created successfully ");
			System.out.println("Connected successfully");
			
			//5. conn close
			//conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void InsertData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db="mydata";
			String userName = "root";
			String password = "rIchU@13";
			Connection conn = DriverManager.getConnection(url+db, userName, password);

			String query = "insert into student values (1, 'boo', 'boom@gmail.com')";
			
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.execute(query);
			System.out.println("data inserted successfully ");
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void readData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db="mydata";
			String userName = "root";
			String password = "rIchU@13";
			
			Connection conn = DriverManager.getConnection(url+db, userName, password);
			String query = "select * from student";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("id = "+rs.getInt(1));
				System.out.println("name = "+rs.getString(2));
				System.out.println("email = "+rs.getString(3));
			}
			System.out.println("read successfully "+rs);
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void updateData() {
try {
			
		String url = "jdbc:mysql://localhost:3306/";
		String db="mydata";
		String userName = "root";
		String password = "rIchU@13";
		Connection conn = DriverManager.getConnection(url+db, userName, password);
	
		String query = "UPDATE student set sid=10 where sname = 'boo'";
		
		PreparedStatement pstm = conn.prepareStatement(query);
//		pstm.setInt(1, 12);
//		pstm.setString(2, "boo");
		
	//	
		pstm.execute(query);
		System.out.println("data updated successfully ");
		
		conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void deleteData() {
		try {
			
			String url = "jdbc:mysql://localhost:3306/mydata";
			//String db="mydata";
			String userName = "root";
			String password = "rIchU@13";
			Connection conn = DriverManager.getConnection(url, userName, password);
		
			String query = "DELETE FROM student " + "WHERE sid = 10";
			
			PreparedStatement pstm = conn.prepareStatement(query);
//			pstm.setInt(1, 12);
//			pstm.setString(2, "boo");
			
		//	
			pstm.execute(query);
			System.out.println("data deleted successfully ");
			
			conn.close();
			} catch(Exception e) {
				e.printStackTrace();
				
			}
	
			
	}	
}
