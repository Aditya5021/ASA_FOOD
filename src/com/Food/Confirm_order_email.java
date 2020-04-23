package com.Food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Food.Dao.FPassDao;

@WebServlet("/Confirm_order_email")
public class Confirm_order_email extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
	    // Get recipient's email-ID, message & subject-line from fpass.jsp page
		HttpSession session = request.getSession();
		String to=(String)session.getAttribute("cemail");
		
	    String subject = "ASA FOOD Login Credential	 \r\n" ;
	    FPassDao da = new FPassDao();
	    String cpass="";
	    cpass=da.check(to,cpass);
	    String messg = "Hey Foodie, Thank you for choosing ASA FOOD! Your order has been confirmed and will be ready for you 30 mins from now please pay the appropriate amount to the delivery guy in cash.";
		// Sender's email ID and password needs to be mentioned
	    String from = "sinha.animoy@gmail.com";
	    String pass = "welovebananas98";
	    System.out.println("u");
		if(da.check(to))
		{
			System.out.println("g");
			da.send(to,subject,messg,from,pass);
			response.sendRedirect("cust_bill.jsp");
			System.out.println("Yo");
		}
	}
		
}