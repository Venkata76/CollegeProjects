package com.cester.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.DBManager.DataBaseAccess;
@WebServlet("/RequestBook")
public class RequestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookID=request.getParameter("book_id");
		int x=0;
		DataBaseAccess db=new DataBaseAccess();
		try {
			x=db.issueBook(bookID);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(x>0)
		{
			response.sendRedirect("requestBookSuccess.html");
		}
		else
			response.sendRedirect("requestBookFailure.html");
		
	}

}
