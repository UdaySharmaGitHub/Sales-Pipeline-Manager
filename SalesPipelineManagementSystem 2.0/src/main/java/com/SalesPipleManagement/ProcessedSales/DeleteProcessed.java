package com.SalesPipleManagement.ProcessedSales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProcessed
 */
@WebServlet("/DeleteProcessed")
public class DeleteProcessed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	Statement stat;
	int row;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
		        out.println("<h1><center>Deletion Successfully</center></h1>");
		        
		        String id=request.getParameter("d");
		        Integer Processedid=Integer.parseInt(id);
//		        out.println(d);
//		        out.println(Leadid);
		        
		        try {
		        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
		            String usernamedb="root";
		         	String passworddb="uday123";
			       	 Class.forName("com.mysql.cj.jdbc.Driver");
					 con=DriverManager.getConnection(url, usernamedb, passworddb);
					 stat=con.createStatement();
		            stat.executeUpdate("delete from processed where processedid='"+Processedid+"';");
					response.sendRedirect("view-processed.jsp");
				} catch (Exception e) {
		            e.printStackTrace();
					System.out.println(e.getMessage());
				}
		doGet(request, response);
	}

}
