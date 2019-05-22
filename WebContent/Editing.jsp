<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/stylesEd.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<form action="Editing" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"
						placeholder="Enter new book name"></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author"
						placeholder="Enter name of author"></td>
				<tr>
					<td><input type="submit" name="edit"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>