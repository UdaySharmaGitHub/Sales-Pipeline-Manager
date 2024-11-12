package com.SalesPipleManagement.ProgressSales;

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
 * Servlet implementation class UpdateProgress
 */
@WebServlet("/UpdateProgress")
public class UpdateProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<h1><center>updation Successfully</center></h1>");
        
        String progressid=request.getParameter("Progressid");
        String progressleadname=request.getParameter("Progressleadname");
        String progressleadcontact=request.getParameter("Progressleadcontact");
        String progressstatus=request.getParameter("Progressstatus");
        
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        try {
        	String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
            String usernamedb="root";
         	String passworddb="uday123";
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, usernamedb, passworddb);
			pst=con.prepareStatement("update progress set progressleadname=? ,progressleadcontact=? , progressstatus=? where progressid=? ; ");
			 pst.setString(1, progressleadname);
			 pst.setString(2, progressleadcontact);
			 pst.setString(3, progressstatus);
			 pst.setString(4, progressid);
			pst.executeUpdate();
			response.sendRedirect("view-progress.jsp");
		} catch (Exception e) {
            e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		doGet(request, response);
	}

}
