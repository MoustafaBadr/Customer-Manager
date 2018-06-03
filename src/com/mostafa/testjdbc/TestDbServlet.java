package com.mostafa.testjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connetcting to Database...." + jdbcUrl);

			Class.forName(driver);

			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Connection Success!!");
			
			myconn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
