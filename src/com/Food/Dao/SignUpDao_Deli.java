package com.Food.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.Food.Dao.Get_connection;

public class SignUpDao_Deli {
	String sql="insert into deli (deliname,delimail,delipass,deliphno) values (?,?,?,?)";
	Get_connection obj = new Get_connection();
	Connection con = obj.get();
	
	public boolean check(String deliname, String delimail, String delipass,String deliphno)
	{
		try
		{
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1,deliname);
			s.setString(2,delimail);
			s.setString(3,delipass);
			s.setString(4,deliphno);
			if(s.executeUpdate()==1)
			{
				return true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
