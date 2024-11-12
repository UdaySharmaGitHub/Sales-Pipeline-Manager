package com.SalesPipleManagement.ProcessedSales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertProcessed
 */
@WebServlet("/InsertProcessed")
public class InsertProcessed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1><center>Registration Successfully</center></h1>");
        
        String processedleadname=request.getParameter("processedleadname");
        String processedleadcontact=request.getParameter("processedleadcontact");
        String processedstatus=request.getParameter("processedstatus");
        out.println("<h3><center>Lead Name : "+processedleadname+"</center></h3>");
        out.println("<h3><center>Lead Contact : "+processedleadcontact+"</center></h3>");
        out.println("<h3><center>Sales Status : "+processedstatus+"</center></h3>");

        
       Connection connection=null;
       Statement statement=null;
       ResultSet resultSet=null;
       
       try {
       	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
           String usernamedb="root";
        	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, usernamedb, passworddb);
			statement=connection.createStatement();
			String insertsql="insert into processed(processedleadname,processedleadcontact,processedstatus)  values('"+processedleadname+"','"+processedleadcontact+"','"+processedstatus+"');";
			statement.executeUpdate(insertsql);
			response.sendRedirect("view-processed.jsp");
			connection.close();
		} catch (Exception e) {
			System.out.println("Connection Not Created Successfully");
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}

}
