package com.SalesPipleManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Getting data from the login.jsp
			 String username =request.getParameter("username");
			 String email =request.getParameter("email");
			 String password=request.getParameter("password");
			 HttpSession session=request.getSession();
			 RequestDispatcher dispatcher=null;
// Checking we get valid username , email and password
			 if(username==null || username.isEmpty()) {
				 request.setAttribute("status", "InvalidUname");
				 dispatcher=request.getRequestDispatcher("login.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 if(email==null || email.isEmpty()) {
				 request.setAttribute("status", "InvalidUemail");
				 dispatcher=request.getRequestDispatcher("login.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 if(password==null || password.isEmpty()) {
				 request.setAttribute("status", "InvalidUpassword");
				 dispatcher=request.getRequestDispatcher("login.jsp");
			 	 dispatcher.forward(request, response);
			 }
//		database connection details
		 String sql="select * from user where username=? and email=? and password=?";
		 String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
		 String usernamedb="root";
		 String passworddb="uday123";
			try{
//				importing the driver used in connection with database

		       	 Class.forName("com.mysql.cj.jdbc.Driver");
//					making connection with database
		        Connection con=DriverManager.getConnection(url, usernamedb, passworddb);
//		     preparing the statement ready to execute
		       	 PreparedStatement st=con.prepareStatement(sql);
//		  Defining the columns
		         st.setString(1, username);
		         st.setString(2, email);
			 	 st.setString(3, password);
//			Executing the query
			 	 ResultSet rs=st.executeQuery();
			 	 if(rs.next()) {
			 		 session.setAttribute("uname",username);
//		send the Request the other page 
			 		 dispatcher=request.getRequestDispatcher("welcome.jsp");
// also sending the Response to other page to know that we are login or not
			 		 response.sendRedirect("welcome.jsp");
			 	 }else {
			 		 request.setAttribute("status","failed");
			 		 dispatcher=request.getRequestDispatcher("login.jsp");
			 	 }
			 	 dispatcher.forward(request, response);
				}catch(Exception e) {  
					e.printStackTrace();  
					}
	}
}
