package com.cester.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cester.DBManager.DataBaseAccess;
import com.cester.bean.BookBean;
import com.cester.bean.InstructorBean;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId,bookName,author;
		bookId=request.getParameter("book_id");
		bookName=request.getParameter("book_name");
		author=request.getParameter("author");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		int x=0;
		BookBean obj=new BookBean(bookId,bookName,author,quantity);
		DataBaseAccess db=new DataBaseAccess();
		try {
			x=db.addBook(obj);
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(x>0)
		{
			response.sendRedirect("addbookSuccess.html");
		}
		else
		{
			response.sendRedirect("addbookfailure.html");
		}

	}

}
