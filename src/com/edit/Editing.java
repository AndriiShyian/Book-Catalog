package com.edit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Editing
 */
@WebServlet("/Editing")
public class Editing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Editing() {
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
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			List<String> list = new ArrayList<String>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
			try {
				response.setContentType("text/html");
				PreparedStatement pr = con.prepareStatement("select * from books where author='" + author + "'");
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
					list.add(rs.getString(1));
				}
			} catch (Exception e) {

			}
			PrintWriter out = response.getWriter();
			PreparedStatement pr = con
					.prepareStatement("update books set name='" + name + "'where author='" + author + "'");
			if (list.size() == 0 || author.trim().length() == 0 || name.trim().length() == 0) {
				out.println(
						"<html><body style=\"background-color:#E0FFFF\"><center>No element in db or you have nulls in yout inserts</center></body></html>");
			} else {
				pr.executeUpdate();
				out.println(
						"<html><body style=\"background-color:#E0FFFF\"><center>Data was edited</center></body></html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
