package com.SalesPipleManagement.ProgressSales;

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
 * Servlet implementation class InsertProgress
 */
@WebServlet("/InsertProgress")
public class InsertProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         out.println("<h1><center>Registration Successfully</center></h1>");
         
         String progressleadname=request.getParameter("progressleadname");
         String progressleadcontact=request.getParameter("progressleadcontact");
         String progressstatus=request.getParameter("progressstatus");
         out.println("<h3><center>Lead Name : "+progressleadname+"</center></h3>");
         out.println("<h3><center>Lead Contact : "+progressleadcontact+"</center></h3>");
         out.println("<h3><center>Sales Status : "+progressstatus+"</center></h3>");

         
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
			String insertsql="insert into progress(progressleadname,progressleadcontact,progressstatus)  values('"+progressleadname+"','"+progressleadcontact+"','"+progressstatus+"');";
			statement.executeUpdate(insertsql);
			response.sendRedirect("view-progress.jsp");
			connection.close();
		} catch (Exception e) {
			System.out.println("Connection Not Created Successfully");
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}

}
