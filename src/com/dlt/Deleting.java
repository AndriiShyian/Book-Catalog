package com.dlt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;

/**
 * Servlet implementation class Deleting
 */
@WebServlet("/Deleting")
public class Deleting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deleting() {
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
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
			PreparedStatement pr = con.prepareStatement("select * from books where name='" + name + "'");
			ResultSet rs = pr.executeQuery();
			PrintWriter out = response.getWriter();
			List<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			if (list.size() > 1) {
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("Main_Dlt_One.jsp");
				rd.forward(request, response);
				response.sendRedirect("Main_Dlt_One.jsp");
			} else if (list.size() == 0) {
				out.println(
						"<html><body style=\"background-color:#E0FFFF\"><center>You have nulls in yout insert or such book doesn't exist in our catalog</center></body></html>");
			} else {
				try {
					String sql = "delete from books where name='" + name + "'";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.executeUpdate();
					out.println(
							"<html><body style=\"background-color:#E0FFFF\"><center>Deleted</center></body></html>");
				} catch (Exception e) {
					out.println("Error" + e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void m(ResultSet rs) {

	}
}
