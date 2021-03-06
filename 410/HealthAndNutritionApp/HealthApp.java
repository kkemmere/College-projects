package Prototype1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/healthApp")
public class HeathApp extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Check for valid user name and password
		String username = request.getParameter("userName");
		String userpass = request.getParameter("userPassword");
		
		UserManager userManager = new UserManager();
		userManager.setup();
		boolean isVerified = userManager.read(username, userpass);
		userManager.exit();
		
		if (isVerified)
			System.out.println("User authentication passed.");
		else System.out.println("User authentication failed.");
		
		// Get the first 11 food items information
		FoodManager foodManager = new FoodManager();
		foodManager.setup();
		String foodTableRows = foodManager.read(11, username);
		foodManager.exit();
		
		// Send back HTML
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
		
				out.println(docType +		
				"<HTML>" +
				"<HEAD><TITLE>Health and Nutrition Prototype</TITLE>" +
				"<STYLE></STYLE>" + 
				"</HEAD><BODY>");
				
				out.println(
				"<table>" +
				"<tr>" +
				"<th>ID</th>" +
				"<th>Group</th>" +
				"<th>Name</th>" +
				"<th>Calories</th>" +
				"<th></th>" +
				"</tr>");
				
				out.println(foodTableRows);
				
				out.println("</table>");
				
				out.println(
				"</BODY></HTML>");
	}

	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}