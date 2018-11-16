package com.cester.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cester.DBManager.DataBaseAccess;


/**
 * Servlet implementation class AuthenticationCheck
 */
@WebServlet("/AuthenticationCheck")
public class AuthenticationCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		HttpSession session=request.getSession();
  		DataBaseAccess db=new DataBaseAccess();
		boolean status=false;
		String username, password, acctype;
		username = request.getParameter("email");
		password = request.getParameter("password");
		acctype = request.getParameter("acctype");

		try{
		if (acctype.equals("student")) 
		{
				status=db.studentLogin(username, password);
				if(status)
				{
					session.setAttribute("studentID", username);
					response.sendRedirect("StudentHome.html");
				}
				else
				{
					response.sendRedirect("HomeLoginfailure.html");
				}
		}
		if (acctype.equals("admin")) 
		{
			status=db.adminLogin(username, password);
			if(status)
			{
				response.sendRedirect("AdminHome.html");
			}
			else
			{
				response.sendRedirect("HomeLoginfailure.html");
			}
		}
		if (acctype.equals("librarian")) 
		{
			status=db.librarianLogin(username, password);
			if(status)
			{
				session.setAttribute("instructorID", username);
				response.sendRedirect("LibrarianHome.html");
			}
			else
			{
				response.sendRedirect("HomeLoginfailure.html");
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}


