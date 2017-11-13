package com.mkyong;

import java.sql.*;

public class DbConnect {
	private Connection con;
	private Statement sta;
	private ResultSet rs;
	public DbConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "650202cjo");
			sta = con.createStatement();
		}catch(Exception e){
			System.out.println("exception is "+ e);
		}
	}
	public void getData(){
		try{
			String query = "select * from userinfo";
			rs = sta.executeQuery(query);
			while(rs.next()){
				String username = rs.getString("username");
				String gender = rs.getString("gender");
				System.out.println(username + " "+ gender);
			}
		}catch(Exception e){
			System.out.println("exception "+ e);
		}
	}
}
