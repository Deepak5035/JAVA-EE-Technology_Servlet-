package com.nt.servletDataBase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDBConn extends HttpServlet {

	Connection con=null;
	PreparedStatement st=null;

	@Override
	public void init() {
		try {
			System.out.println("inside init");
			ServletConfig sc=getServletConfig();
			Class.forName(sc.getInitParameter("driver"));
			con=DriverManager.getConnection(sc.getInitParameter("url"),sc.getInitParameter("username"),sc.getInitParameter("pass"));
			st=con.prepareStatement("select empno,ename,job,sal from emp where empno=?");
            System.out.println(sc.getServletName());     
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