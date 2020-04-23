package com.Food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Food.Dao.FPassDao;
import com.Food.Dao.Get_connection;
import java.sql.*;

@WebServlet("/PickedUp_order_email")
public class PickedUp_order_email extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Get_connection obj = new Get_connection();
		Connection con = obj.get();
		ResultSet resultSet = null;
		response.setContentType("text/html; charset=UTF-8");
	    // Get recipient's email-ID, message & subject-line from fpass.jsp page
		HttpSession session = request.getSession();
		String to=(String)request.getParameter("to");
		System.out.println(to);
		String id=(String) session.getAttribute("rest_id");
		String order_id=request.getParameter("order_id");
		Statement statement;
		System.out.println("d");
	    String subject = "ASA FOOD Login Credential	 \r\n" ;
	    FPassDao da = new FPassDao();
	    String cpass="";
	    cpass=da.check(to,cpass);
	    System.out.println("dd");
	    String messg = "Hey Foodie, Thanks for visiting ASA FOOD! Your order has been picked up.Thank you for choosing ASA FOOD!!"+"\r\n";
		// Sender's email ID and password needs to be mentioned
	    String from = "sinha.animoy@gmail.com";
	    String pass = "welovebananas98";
	    
		if(da.check(to))
		{
			da.send(to,subject,messg,from,pass);
			System.out.println("dsdsd");
			 response.sendRedirect("rest_view_current_order.jsp");
		}
	}}