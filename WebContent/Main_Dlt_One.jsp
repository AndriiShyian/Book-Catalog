<%@page import="java.sql.*"%>
<%@page import="java.lang.String"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E0FFFF">
	<center>
		<table border="1">
			<tr>
				<td>Name</td>
				<td>Author</td>
				<td>Delete</td>
			</tr>
			<%
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
				Statement st = con.createStatement();
				String name = (String) request.getAttribute("name");
				ResultSet rs = st.executeQuery("select * from books where name='" + name + "'");

				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("author")%></td>
				<td><a
					href='Delete_One_From_Many.jsp?n=<%=rs.getString("name")%>&&a=<%=rs.getString("author")%>'
					class="btn btn-danger">delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>