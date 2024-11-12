package com.SalesPipleManagement.mover;

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

@WebServlet("/Negotiationtoclosing")
public class Negotiationtoclosing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<h1><center>updation Successfully</center></h1>");
        
        String progressID=request.getParameter("Progressid");
        String progressleadname=request.getParameter("Progressleadname");
        String progressleadcontact=request.getParameter("Progressleadcontact");

        
        Connection conn;
        Statement stat;
        ResultSet rst;
        
        try {
        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
            String usernamedb="root";
         	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, usernamedb, passworddb);
			stat=conn.createStatement();
			String deletesql=" delete from progress where progressid='"+progressID+"';" ;
			stat.addBatch(deletesql);
			String insertsql="insert into processed(processedleadname,processedleadcontact,processedstatus)  values('"+progressleadname+"','"+progressleadcontact+"','Closing');";
			stat.addBatch(insertsql);
			stat.executeBatch();
			response.sendRedirect("Negotiation_progress.jsp");
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}

}
