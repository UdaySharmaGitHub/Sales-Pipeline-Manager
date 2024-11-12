package com.SalesPipleManagement.Sales;

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
 * Servlet implementation class InsertSales
 */
@WebServlet("/InsertSales")
public class InsertSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         out.println("<h1><center>Registration Successfully</center></h1>");
         
         String leadname=request.getParameter("leadname");
         String leadcontact=request.getParameter("leadcontact");
         String salesstatus=request.getParameter("salesstatus");
         out.println("<h3><center>Lead Name : "+leadname+"</center></h3>");
         out.println("<h3><center>Lead Contact : "+leadcontact+"</center></h3>");
         out.println("<h3><center>Sales Status : "+salesstatus+"</center></h3>");

         
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
			String insertsql="insert into sales(leadname, leadcontact, salesstatus) values('"+leadname+"','"+leadcontact+"','"+salesstatus+"');";
			statement.executeUpdate(insertsql);
			response.sendRedirect("view-sales.jsp");
			connection.close();
		} catch (Exception e) {
			System.out.println("Connection Not Created Successfully");
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}

}
