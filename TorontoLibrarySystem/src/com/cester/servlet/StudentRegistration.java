package com.cester.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.DBManager.DataBaseAccess;
import com.cester.bean.StudentBean;



/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String email,fname,lname,gender,college,mobileno,password,repassword;
		email=request.getParameter("email");
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		gender=request.getParameter("gender");
		college=request.getParameter("college");
		mobileno=request.getParameter("mobileno");
		password=request.getParameter("password");
		repassword=request.getParameter("repassword");
		
		StudentBean obj=new StudentBean(email,fname,lname,gender,college,mobileno,password);
		
		if(password.equals(repassword))
		{
			DataBaseAccess db=new DataBaseAccess();
			try 
			{
				int x=db.studentRegistration(obj);
				if(x>0)
				{
					
					response.sendRedirect("HomeLoginSuccess.html");
				}
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("HomeLoginfailure.html");
		}
	
	}

}
