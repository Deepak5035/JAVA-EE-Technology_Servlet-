package com.nt.servletRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CoronaRegistration extends HttpServlet {
	private static final String INSERT_CORONA_QUERY = "INSER INTI CORONA_REGISTRATION VALUES(CORONA_PATID_SEQ.NEXTVAL,?,?,?,?,?)";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String patName = null, patAddrs = null, gender = null, stage = null;
		int age = 0;
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		// get print writer
		pw = res.getWriter();
		// set content type
		res.setContentType("text/html");

		// read form data
		patName = req.getParameter("patName");
		patAddrs = req.getParameter("patAddrs");
		age = Integer.parseInt(req.getParameter("patAge"));
		gender = req.getParameter("gender");
		stage = req.getParameter("stage");

		try {
			// get pooled jdbc connection
			con = getPooledConnection();
			ps = con.prepareStatement(INSERT_CORONA_QUERY);
			// set value to query param
			ps.setString(1, patName);
			ps.setString(2, patAddrs);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, stage);

			// execute the query
			count = ps.executeUpdate();

			// process the result
			if (count == 0)

				pw.println("<h1 style='color:red;text-align:center'>Registration failed></h1>AZZZZZ");

			else
				pw.println("<h1 style='color:green;text-align:center>Registration sucess...</h1>");
		} catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration Failes</h1>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>unknown problem<h1>");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();// releases the jdbc connection obj back tojdbc con pool
			} catch (SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1><a href='register.html>home</a></h1>");

			try {
				if (pw != null)
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private Connection getPooledConnection() throws Exception {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		// create initial context
		ic = new InitialContext();
		// get data source object through lookup operation
		ds = (DataSource) ic.lookup("DsJndi");
		
		// get pooled JDBC con object
		con = ds.getConnection();
		return con;
	}// getPooledconnection()
}// class
