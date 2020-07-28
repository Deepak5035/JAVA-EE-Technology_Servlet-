package com.nt.servletDataBase;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToDataBaseConnection extends HttpServlet {
	private static final String STUDENT_REGISTRATION="INSERT INTO STUDENT_REGISTRATION VALUES(?,?,?,?,?,?)";
	                                                    
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	@Override
	public void init() {
		
		try {
			ServletContext sc=getServletContext();
			Class.forName(sc.getInitParameter("driver"));
            con=DriverManager.getConnection
                        (sc.getInitParameter("url"),sc.getInitParameter("username"),sc.getInitParameter("password"));
		    st=con.prepareStatement("STUDENT_REGISTRATION");    
		    
		} catch (Exception e) {
		  e.printStackTrace();
		}//catch		
	}//init
	
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		PrintWriter pw=null;
		String name=null;
		int age=0;
		String add=null;
		String qul=null;
		int mob=0;
		String email=null;
		
		
		try {
		pw=res.getWriter();	
		res.setContentType("text/html");
		
		 name=req.getParameter("name");
		 age=Integer.parseInt(req.getParameter("age"));
		 add=req.getParameter("add");
		 qul=req.getParameter("qul");
		 mob=Integer.parseInt(req.getParameter("mob"));
		 email=req.getParameter("email");
		 
		 st.setString(1,name);
		 st.setInt(2,age);
		 st.setString(3,add);
		 st.setString(4,qul);
		 st.setInt(5,mob);
		 st.setString(6,email);
		 
		 int count=st.executeUpdate();
		
		 if(count==0) {
			 pw.print("<h1>Internal DB Problem</h1>");
		 }
		 else
			 pw.print("<h1>Record Successfully Inserted</h1>");
		 pw.close();
		
		}catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st!=null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req,res);
	}

}
