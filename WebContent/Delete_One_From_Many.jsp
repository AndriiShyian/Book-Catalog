<%@page import="java.sql.*"%>
<%@page import="java.lang.String"%>
<%
	String name = request.getParameter("n");
	String author = request.getParameter("a");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
	Statement st = con.createStatement();
	st.executeUpdate("delete from books where name='" + name + "'and author='" + author + "'");
	out.println(
			"<html><body style=\"background-color:#E0FFFF\"><center>Data was deleted</center></body></html>");
%>