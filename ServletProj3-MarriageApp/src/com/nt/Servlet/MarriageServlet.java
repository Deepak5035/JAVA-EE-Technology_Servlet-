package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MarriageServlet extends HttpServlet {
		@Override
		public void doPost(HttpServletRequest req,HttpServletResponse res)
			                             throws ServletException,IOException{

			PrintWriter pw=null;
			String name=null;
	        String tage=null;
			String gender=null;

			int age=0;

	        pw=res.getWriter();
	        res.setContentType("text/html");

	        name=req.getParameter("name");
			tage=req.getParameter("age");
			age=Integer.parseInt(tage);
			gender=req.getParameter("gender");


	        if(gender.equalsIgnoreCase("M")){
	                if(age>=21)
					 pw.println("<h1 style='color:green'>Mr "+name+" you are Eligibal for Marriage</h1>");
					else
					 pw.println("<h1 style='color:Red'>Mr "+name+" you are not Eligibal for Marriage</h1>");
			}
	       if(gender.equalsIgnoreCase("F")){

					if(age>=18)
					 pw.println("<h1 style='color:green'>Miss "+name+" you are Eligibal for Marriage</h1>");
					else
					 pw.println("<h1 style='color:Red'>Miss "+name+" you are not Eligibal for Marriage</h1>");
				
			}
				//pw.println("<a href='http://localhost:3030/MarriageApp/input.html'>Home</a>");
				pw.println("<a href='input.html'>Home</a>");
				pw.close();
	   }//doPost
	}//class


