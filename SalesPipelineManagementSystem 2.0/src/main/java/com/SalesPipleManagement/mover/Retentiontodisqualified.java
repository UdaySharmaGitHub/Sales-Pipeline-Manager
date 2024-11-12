package com.SalesPipleManagement.mover;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Retentiontodisqualified")
public class Retentiontodisqualified extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<h1><center>updation Successfully</center></h1>");
        
        String processedID=request.getParameter("Processedid");
        
        Connection cconnectionn;
        PreparedStatement ppreparedStatementt;
        ResultSet rst4;
        
        try {
        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
            String usernamedb="root";
         	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			cconnectionn=DriverManager.getConnection(url, usernamedb, passworddb);
			ppreparedStatementt=cconnectionn.prepareStatement("update processed set processedstatus='Disqualified' where processedid='"+processedID+"'; ");
			ppreparedStatementt.executeUpdate();
			response.sendRedirect("Retention_processed.jsp");
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}
}
