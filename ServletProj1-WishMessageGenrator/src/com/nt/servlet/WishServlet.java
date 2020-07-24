package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		PrintWriter pw=null;
		double time=0.0;
		Date d=null;
		String task=null;
		try {
			pw=res.getWriter();
			res.setContentType("text/html");
			d=new Date();
			time=d.getHours();
					
			if(time<12) 
				pw.print("<h1>good Morning<h1>");
			
			else if(time>12&&time<16) 
				pw.print("<h1>good AfterNoon<h1>");
			
			else if(time>16&&time<20) 
				pw.print("<h1>good Evening<h1>");
			
			else  
				pw.print("<h1>good Night<h1>");
			
		   } catch (IOException e) {
			e.printStackTrace();
		   } 
		
			pw.print("<a href=input.html>Home</a>");
			
			
			//close stream
			pw.close();
	
	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		doGet(req,res);
	}
}
	

