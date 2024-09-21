package com.tap.storepro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;





public class Storeproc {
	private static Connection co;
	private static Statement stmt;
	private static ResultSet res;
	private static CallableStatement pre;
	private static boolean x;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			co=DriverManager.getConnection("jdbc:mysql://localhost:3306/august1","root","1121");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try
		{
			display();
			System.out.println("----------------------------");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			String query="{call insert_data(?,?,?,?,?)}";
			pre=co.prepareCall(query);
			System.out.println("enter id");
			int a=sc.nextInt();
			sc.nextLine();
			System.out.println("enter name");
			String b=sc.nextLine();
			System.out.println("enter accnum");
			String c=sc.nextLine();
			System.out.println("enter balance");
			String d=sc.nextLine();
			System.out.println("enter pnone num");
			int e=sc.nextInt();
			pre.setInt(1, a);
			pre.setString(2, b);
			pre.setString(3, c);
			pre.setString(4, d);
			pre.setInt(5, e);
			x=pre.execute();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("----------------------------");
			display();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	static void display() throws SQLException {
		String query="Select * from bank";
		stmt=co.createStatement();
		res=stmt.executeQuery(query);
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+
					   res.getString(2)+" "+
					   res.getString(3)+" "+
					   res.getString(4)+" "+
					   res.getInt(5)+" ");
		}
		
		
	}



	
}
