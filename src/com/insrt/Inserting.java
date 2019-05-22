package com.insrt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inserting
 */
@WebServlet("/Inserting")
public class Inserting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inserting() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
			String sql = "insert into books values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, author);
			if (name.trim().length() == 0 || author.trim().length() == 0) {
				out.println(
						"<html><body style=\"background-color:#E0FFFF\"><center>You have nulls in yout inserts</center></body></html>");
			} else {
				ps.executeUpdate();
				out.println("<html><body style=\"background-color:#E0FFFF\"><center>Inserted</center></body></html>");
			}
		} catch (Exception e) {
			out.println("Error" + e.getMessage());
		}
	}

}
