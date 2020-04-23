package com.Food;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Food.Dao.Get_connection;
import com.Food.Dao.SignUpDao_Deli;

@WebServlet("/SignUp_Deli")
public class SignUp_Deli extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("entered in delisignup");
		HttpSession session = request.getSession();
		String deliname = request.getParameter("deliname");
		String delimail = request.getParameter("delimail");
		Get_connection obj = new Get_connection();
		String sql="select delimail from deli where delimail='"+delimail+"'";
		Connection con = obj.get();
		try {
			PreparedStatement s = con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			System.out.println(sql);
			if(rs.next()) {
				System.out.println("dvfgdd");
				response.sendRedirect("deli_signup.jsp.jsp?exist=Email id already exist");
			}
			else {
				String delipass = request.getParameter("delipass");
				String deliphno = request.getParameter("deliphno");
				SignUpDao_Deli da = new SignUpDao_Deli();
				if(da.check(deliname,delimail, delipass,deliphno))
				{
					session=request.getSession(true);
					session.setAttribute("delimail", delimail);	
					session.setAttribute("deliname", deliname );
					session.setAttribute("signin_type", "deli");	
					int item_count=0;
					HttpSession session1 = request.getSession();
					session1.setAttribute("item_count", item_count);
					System.out.println("I am here");
					response.sendRedirect("rest_view_current_order.jsp");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
