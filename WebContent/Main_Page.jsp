<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<h1>Insert data</h1>
		<form action="Inserting" name="form" method="post">
			<label for="name">Name</label> <input type="text" name="name"
				id="name" placeholder="Enter book name"> <label for="author">Author</label>
			<input type="text" name="author" id="author"
				placeholder="Enter name of author"> <br> <input
				type="submit" value="Insert">
			<button type="reset" value="Reset">Reset</button>
		</form>

		<h1>Delete data</h1>
		<form action="Deleting" name="form" method="post">
			<label for="name">Name</label> <input type="text" name="name"
				id="name" placeholder="Enter book name"> <br> <input
				type="submit" value="Delete">
			<button type="reset" value="Reset">Reset</button>
		</form>

		<h1>See data</h1>
		<form action="All" name="form" method="post">
			<br> <input id="i1" type="submit" value="Show all">
		</form>

		<h1>Edit data</h1>
		<form action="Editing.jsp" name="form" method="post">
			<br> <input id="i1" type="submit" value="Edit name">
		</form>
	</center>
</body>
</html>