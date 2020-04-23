package com.Food.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Get_connection
{
	String uemail="root";
	String pass="#welovebananas98";
	String url="jdbc:mysql://localhost:3306/foodgo";

	public Connection get() {

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uemail,pass);
			return con;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
