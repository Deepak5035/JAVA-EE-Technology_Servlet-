package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
     @Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			                           throws ServletException,IOException{

	
    	 PrintWriter pw=null;
    	 
    	 //get PrintWriter Object
    	 pw=res.getWriter();
    	 
    	 //set Content Type
    	 res.setContentType("text/html");
    	 
    	String []India = {"AP","UP","TS","MS"}; 
    	String []Us = {"NY","WD","TEX","PEL"};
    	String []Pak = {"IB","KC","HYD","LAH"};
    	
    	String country=req.getParameter("counrty");
	
        if(country.equalsIgnoreCase("India"))
        	pw.println("states are::"+Arrays.toString(India));
        else if(country.equalsIgnoreCase("Us"))
        	pw.println("states are::"+Arrays.toString(India));
        else if(country.equalsIgnoreCase("Pak"))
        	pw.println("states are::"+Arrays.toString(India));
        
        pw.println("<h href= index.html>home<h>");
     }
  
        
     @Override
  public void doPost(HttpServletRequest req,HttpServletResponse res)
                                            throws ServletException,IOException{
	  doGet(req,res);
	  
  }


}
