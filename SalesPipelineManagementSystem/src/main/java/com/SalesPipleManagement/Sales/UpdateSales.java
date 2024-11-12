package com.SalesPipleManagement.Sales;

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

@WebServlet("/UpdateSales")
public class UpdateSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<h1><center>updation Successfully</center></h1>");
        
        String leadid=request.getParameter("Leadid");
        String leadname=request.getParameter("Leadname");
        String leadcontact=request.getParameter("Leadcontact");
        String salesstatus=request.getParameter("Salesstatus");
        
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        try {
        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
            String usernamedb="root";
         	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, usernamedb, passworddb);
			pst=con.prepareStatement("update sales set leadname=? , leadcontact=? , salesstatus=? where leadid=?; ");
			 pst.setString(1, leadname);
			 pst.setString(2, leadcontact);
			 pst.setString(3, salesstatus);
			 pst.setString(4, leadid);
			pst.executeUpdate();
			response.sendRedirect("view-sales.jsp");
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println(e.getMessage());
		} 
        doGet(request, response);
		
	}

}
