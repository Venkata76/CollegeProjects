package com.cester.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.DBManager.DataBaseAccess;
import com.cester.bean.InstructorBean;

@WebServlet("/LibrarianRegistration")
public class LibrarianRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String email,fname,lname,gender,password;
    		email=request.getParameter("email");
    		fname=request.getParameter("fname");
    		lname=request.getParameter("lname");
    		gender=request.getParameter("gender");
    		password=request.getParameter("password");
    		int x=0;
    		InstructorBean obj=new InstructorBean(email,fname,lname,gender,password);
    		
    		DataBaseAccess db=new DataBaseAccess();
    		try {
				x=db.addInstructor(obj);
			} 
    		catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
    		if(x>0)
    		{
    			response.sendRedirect("addLibrariansuccess.html");
    		}
    		else
    		{
    			response.sendRedirect("addLibrarianfail.html");
    		}
    		
	}

}
