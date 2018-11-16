package com.cester.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cester.bean.BookBean;
import com.cester.bean.InstructorBean;
import com.cester.bean.StudentBean;

public class DataBaseAccess {
	Connection getDbConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		con.commit();
		return con;
	}

	public int studentRegistration(StudentBean obj) throws ClassNotFoundException, SQLException {
		int status=0;
		Connection con=getDbConnection();	
		PreparedStatement ps=con.prepareStatement("INSERT INTO STUDENT_L VALUES(?,?,?,?,?,?,?)");
		ps.setString(1,obj.getEmail());
		ps.setString(2,obj.getFname());
		ps.setString(3,obj.getLname());
		ps.setString(4,obj.getGender());
		ps.setString(5,obj.getCollege());
		ps.setString(6,obj.getMobileno());
		ps.setString(7,obj.getPassword());
		status=ps.executeUpdate();
		
		return status;
		
	}

	public boolean studentLogin(String username, String password) throws SQLException, ClassNotFoundException {
		boolean flag=false;
		Connection con = getDbConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT_L");
		while (rs.next()) {
			String emaildb = rs.getString(1);
			String passworddb = rs.getString(7);
			if (emaildb!=null  && emaildb.trim().equals(username.trim()) && passworddb!=null && passworddb.trim().equals(password.trim())) 
				{
					flag = true;
				}
			
		}
		con.close();
		return flag;
	}

	public boolean adminLogin(String username, String password) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		Connection con = getDbConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN_L");
		while (rs.next()) {
			String emaildb = rs.getString(1);
			String passworddb = rs.getString(2);
			if (emaildb!=null  && emaildb.trim().equals(username.trim()) && passworddb!=null && passworddb.trim().equals(password.trim())) 
				{
					flag = true;
				}
			
		}
		con.close();
		return flag;
	}

	public boolean librarianLogin(String username, String password) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		Connection con = getDbConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LIBRARIAN_L");
		while (rs.next()) {
			String emaildb = rs.getString(1);
			String passworddb = rs.getString(5);
			if (emaildb!=null  && emaildb.trim().equals(username.trim()) && passworddb!=null && passworddb.trim().equals(password.trim())) 
				{
					flag = true;
				}
			
		}
		con.close();
		return flag;
	}

	public int addInstructor(InstructorBean obj) throws SQLException, ClassNotFoundException {
		int status=0;
		Connection con=getDbConnection();	
		PreparedStatement ps=con.prepareStatement("INSERT INTO LIBRARIAN_L VALUES(?,?,?,?,?)");
		ps.setString(1,obj.getEmail());
		ps.setString(2,obj.getFname());
		ps.setString(3,obj.getLname());
		ps.setString(4,obj.getGender());
		ps.setString(5,obj.getPassword());
		status=ps.executeUpdate();
		con.close();
		return status;
	}

	public int addBook(BookBean obj) throws ClassNotFoundException, SQLException {
		int status=0;
		Connection con=getDbConnection();	
		PreparedStatement ps=con.prepareStatement("INSERT INTO BOOK_L VALUES(?,?,?,?)");
		ps.setString(1,obj.getBookId());
		ps.setString(2,obj.getBookName());
		ps.setString(3,obj.getAuthor());
		ps.setInt(4,obj.getQuantity());
		status=ps.executeUpdate();
		con.close();
		return status;
	}

	public int issueBook(String bookID) throws ClassNotFoundException, SQLException {
		int flag=0;
		Connection con = getDbConnection();
		Statement stmt = con.createStatement();
		int value=0;
		ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK_L");
		while (rs.next()) 
		{
			String bookIDDB = rs.getString(1);
			int quantity = rs.getInt(4);
			if(bookIDDB!=null&& bookID!=null && bookID.equals(bookIDDB) && quantity>0)
			{
				flag=1;
				value=quantity;
			}
			
		}
		if(flag==1)
		{	
			PreparedStatement ps1=con.prepareStatement("UPDATE BOOK_L SET QUANTITY=? WHERE BOOK_ID=?");
			ps1.setInt(1, (value-1));
			ps1.setString(2, bookID);
			ps1.executeUpdate();
			
		}
		con.close();
		return flag;
	}

	

}
