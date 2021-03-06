package com.Food.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;


public class LoginDao extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	String sql1="select * from cust where cust_email=? and cust_pass=?";
	String sql2="select * from deli where delimail=? and delipass=?";
	Get_connection obj = new Get_connection();
	Connection con = obj.get();
	public String check(String email, String password,HttpSession session)
	{
		try 
		{
			PreparedStatement s = con.prepareStatement(sql1);
			s.setString(1,email);
			s.setString(2,password);
			ResultSet rs = s.executeQuery();
			if(rs.next())
			{
				session.setAttribute("cname", rs.getString("cust_name") );
				return "customer";
			}

			s = con.prepareStatement(sql2);
			s.setString(1,email);
			s.setString(2,password);
			rs = s.executeQuery();
			if(rs.next())
			{
				session.setAttribute("deliname", rs.getString("deliname") );			
				return "delivery";
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
