package com.nt.initMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initTest extends GenericServlet{

	PrintWriter pw=null;
	ServletConfig servletconfig=null;
	@Override
	public void init(ServletConfig servletconfig) {
		System.out.println("inside life cycle inti method");
		this.servletconfig=servletconfig;
		System.out.println("servletconfig Object Assingmnet");
		init();
	}
	public void init() {
		System.out.println("inside convience init method");
	}
	@Override
	public ServletConfig getServletConfig() {
		return servletconfig;
	}
	@Override
	public void service(ServletRequest req,ServletResponse res) {
	System.out.println("inside life cycle service method");
    HttpServletRequest httpreq=(HttpServletRequest)req; 
    HttpServletResponse httpres=(HttpServletResponse)res; 
	doGet(httpreq,httpres);
	}
	//@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		try {
			pw=res.getWriter();
			res.setContentType("text/html");
			System.out.println("inside goGet");
			ServletConfig servletconfig=getServletConfig();
			String emailID=servletconfig.getInitParameter("email");
			pw.print("Date Time and EmailId:"+new Date()+"\n"+emailID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
