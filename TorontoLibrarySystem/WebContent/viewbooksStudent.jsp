<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grid View</title>
<link rel="stylesheet" type="text/css" href="CSS/style1.css"/></head>
<body>
<table class="admitable">
<tr><th><a href="StudentHome.html">Home</a></th>
<th><a href="viewbooksStudent.jsp">View Books</a></th>
<th><a href="requestBook.html">Request Book</a></th>
<th><a href="LogOut">logout</a></th></tr>
</table>
<div class="view">
<table>
<tr>
	<th>Book Id</th>
	<th>Book Name</th>
	<th>Author</th>
	<th>Quantity</th>
	</tr>
	
<%
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM Book_L");
%>
<%
while(rs.next())
{%>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getInt(4) %></td>
		</tr>
<%	
}

%>
<%}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</table>
</div>
</body>