package com.tapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class Connect {
	static Connection conn;
	public static Connection formBridge(String url,String username,String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		 try {
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("connection done and dusted");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return conn;
	}
	public static void shutDown(Connection conn,ResultSet result,Statement stmt){
		try {
			if(stmt!=null) {
				stmt.close();
				System.out.println("statement is closed");
			}
			if(result!=null) {
				result.close();
				System.out.println("result is closed");
				}
			if(conn!=null) {
				conn.close();
				System.out.println("Connection is closed");
				}	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
