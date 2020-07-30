package com.nt.servletDataBase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ServletDBConn extends HttpServlet {
    private final static String Emp_details="SELECT EMPNO,ENAME,JOB,SAL FROM  EMP WHERE EMPNO =?";
	Connection con=null;
	PreparedStatement st=null;

	@Override
	public void init() {
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
			Connection con=ds.getConnection();
			st=con.prepareStatement(Emp_details);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//inti
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		try {
			System.out.println("inside get");
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			int no=Integer.parseInt(req.getParameter("empno"));

			st.setInt(1,no);
			ResultSet rs=st.executeQuery();
			

			if(rs.next()) {
				pw.println("<br>EmployeeNo"+rs.getInt(1));
				pw.println("<br>Employee Name"+rs.getString(2));
				pw.println("<br>Employee Desg"+rs.getString(3));
				pw.println("<br>Employee Salary"+rs.getFloat(4));
			}
			else {
				pw.println("<br> No employee Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		System.out.println("inside Post");
		doGet(req,res);
    }
	
	public void destroy() {
		System.out.println("inside destroy");
		try {
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//destory
}