package com.all;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class All
 */
@WebServlet("/All")
public class All extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public All() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
			PreparedStatement pr = con.prepareStatement("select * from books");
			ResultSet rs = pr.executeQuery();
			PrintWriter out = response.getWriter();
			out.println(
					"<html><body style=\"background-color:#E0FFFF\"><center><p>All data from table<table border='1'><tr><td>Name</td><td>Author</td></tr>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td></tr>");
			}
			out.println("</table></p></center></body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
