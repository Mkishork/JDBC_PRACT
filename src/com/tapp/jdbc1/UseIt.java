package com.tapp.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;


public class UseIt {
	static Connection conn;

	 public static Connection formconnection(String url,String username,String password){
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			System.out.println(url);
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("connected");
		} 
		 catch (Exception e){
			e.printStackTrace();
		}
	
		return conn;
	}
}
