package com.SalesPipleManagement.ProcessedSales;

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

/**
 * Servlet implementation class UpdateProcessed
 */
@WebServlet("/UpdateProcessed")
public class UpdateProcessed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<h1><center>updation Successfully</center></h1>");
        
        String processedid=request.getParameter("Processedid");
        String processedleadname=request.getParameter("Processedleadname");
        String processedleadcontact=request.getParameter("Processedleadcontact");
        String processedstatus=request.getParameter("Processedstatus");
        
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        try {
        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
            String usernamedb="root";
         	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, usernamedb, passworddb);
			pst=con.prepareStatement("update processed set processedleadname=? ,processedleadcontact=? , processedstatus=? where processedid=? ; ");
			 pst.setString(1, processedleadname);
			 pst.setString(2, processedleadcontact);
			 pst.setString(3, processedstatus);
			 pst.setString(4, processedid);
			pst.executeUpdate();
			response.sendRedirect("view-processed.jsp");
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println(e.getMessage());
		} 		
		doGet(request, response);
	}

}
