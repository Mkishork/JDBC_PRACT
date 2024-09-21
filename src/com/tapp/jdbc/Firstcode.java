package com.tapp.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Firstcode {
	 static Connection conn;
	 static ResultSet result;
	  static Statement stmt;

	public static void main(String[] args) {
		
		try {
			 conn= Connect.formBridge(Cretendials.getUrl(),Cretendials.getUsername(),Cretendials.getPassword());
			  
			   stmt =conn.createStatement();								
			   result =stmt.executeQuery("select * from student");
			   while(result.next()) {
					System.out.println(result.getInt("student_id")+" "
							+ result.getInt("student_ph")+" "+
							result.getString("student_name")+" "+
							result.getString("student_email"));
			   }
					
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			Connect.shutDown(conn,result,stmt);
			}
			
			

		
	}
}
