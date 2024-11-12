package com.SalesPipleManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Getting data from the login.jsp
			 String username =request.getParameter("username");
			 String email =request.getParameter("email");
			 String password=request.getParameter("password");
			 String chkpassword=request.getParameter("chkpassword");
			 String contact_no=request.getParameter("contact_no");
			 HttpSession session=request.getSession();

			 RequestDispatcher dispatcher=null;	
//			Checking we get valid username, email ,password and contact_number
			 if(username==null || username.isEmpty()) {
				 request.setAttribute("status", "invalidUname");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 else if(email==null || email.isEmpty()) {
				 request.setAttribute("status", "invalidUemail");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 if(password==null || password.isEmpty()) {
				 request.setAttribute("status", "invalidUpassword");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 else if(!password.equals(chkpassword)){
				 request.setAttribute("status","checkUpassword");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 else if(contact_no==null || contact_no.isEmpty()) {
				 request.setAttribute("status", "invalidUcontact_no");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
			 else if(contact_no.length()>12) {
				 request.setAttribute("status", "invalidContactlength");
				 dispatcher=request.getRequestDispatcher("registration.jsp");
			 	 dispatcher.forward(request, response);
			 }
//				database connection details
			 String url="jdbc:mysql://localhost:3306/sales_pipline_manaagement";
			 String usernamedb="root";
			 String passworddb="uday123";
			 Connection con=null;
			 try{
//					importing the driver used in connection with database

			       	 Class.forName("com.mysql.cj.jdbc.Driver");
//						making connection with database
			        con=DriverManager.getConnection(url, usernamedb, passworddb);
//					Writing the insert Query 
			        String sql="insert into user(username,email,password,contact_no) values(?,?,?,?)";
//				     preparing the statement ready to execute
					 PreparedStatement st=con.prepareStatement(sql);
//			  Defining the columns
			         st.setString(1, username);
			         st.setString(2, email);
				 	 st.setString(3, password);
				 	 st.setString(4, contact_no);
//				Executing the query
				 	 int rowcount=st.executeUpdate();
				 	 if(rowcount  > 0) {
				 		 request.setAttribute("status","success");
				 		 System.out.print("inserted");
				 		 session.setAttribute("uname",username);
					 	 dispatcher=request.getRequestDispatcher("welcome.jsp");
				 	 }else {
				 		 request.setAttribute("status","failed");
				 	 }
				 	 dispatcher.forward(request, response);
					}catch(Exception e) {  
						e.printStackTrace();  
						}finally {
							try {
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			 
	}
}
