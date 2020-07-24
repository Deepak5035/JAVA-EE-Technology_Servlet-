package com.nt.Servlet;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


@SuppressWarnings("serial")
public class VoterServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
								   throws ServletException,IOException{
	   
	   	PrintWriter pw=null;
		String name=null;
		String tage=null;
		int age=0;
	
		pw=res.getWriter();
        res.setContentType("text/html");

		name=req.getParameter("name");	
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);

		if(age<18)
		  pw.println("<h1 style='color:red' 'text-align:center'>Mr/Miss::"   +name+   "you are not eligibale for voting</h1>");
		else
		  pw.println("<h1 style='color:green' 'text-align:center'>Mr/Miss::"   +name+  "you are eligibale for voting</h1>");

		//pw.println("<br><a href='http://localhost:3030/VoterApps/input.html'>home</a>");
		pw.println("<br><a href='input.html'>home</a>");
		pw.close();
		
	}
}
