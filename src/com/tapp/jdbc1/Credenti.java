package com.tapp.jdbc1;

public class Credenti {
	private static String url;
	private static String user_id;
	private static String passcode;
	static String getUrl() {
		return url;	
	}
	static String getUserid() {
		return user_id;
	}
	static String getPasscode() {
		return passcode;
	}
	 public static void Credenti1(String a,String b,String c){
		url=a;
		user_id=b;
		passcode=c;
	}
	public static void setCredti1() {
		Credenti.Credenti1("jdbc:mysql://localhost:3306/august1","root","1121");
		
	}
	
//	public static void main(String args[]) {
//		
//		System.out.println(url);
//		System.out.println(user_id);
//		System.out.println(passcode);
//	}
	

}
