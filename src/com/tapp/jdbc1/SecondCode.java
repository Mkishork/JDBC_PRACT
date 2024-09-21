package com.tapp.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class SecondCode {
	 static Connection con;
	public static void main(String[] args) {
		Credenti.setCredti1();
		try {
		System.out.println(Credenti.getUrl());
		con=UseIt.formconnection(Credenti.getUrl(),Credenti.getUserid(),Credenti.getPasscode());
		String q="insert into student(student_id,student_name,student_email,student_ph) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		pstmt.setInt(1,sc.nextInt());
		sc.nextLine();
		System.out.println("enter the name");
		pstmt.setString(2,sc.nextLine());            // to update the value in the database using java.
		System.out.println("enter the emailId");
		pstmt.setString(3,sc.nextLine());
		System.out.println("enter the phoneno");
		pstmt.setInt(4,sc.nextInt());
		int i=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
