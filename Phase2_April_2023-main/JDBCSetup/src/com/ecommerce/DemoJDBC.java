package com.ecommerce;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DemoJDBC() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			// Get the URL, username, password from the config.properties file and load into
			// props object.
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties"); // Java NIO Package.
			Properties props = new Properties();
			props.load(in);

			DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
					props.getProperty("password"));
			out.println("DB Connection Successful!<br>");	
			

			// Close the Connection.
			conn.closeConnection();
			out.println("DB Connection Closed.<br>");

			out.println("</body></html>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
