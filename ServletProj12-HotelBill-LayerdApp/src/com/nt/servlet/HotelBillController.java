package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.HotelBillDto;
import com.nt.service.BillMngmtService;
import com.nt.service.BillMngmtServiceImpl;
import com.nt.vo.HotelBillVO;


@WebServlet("/controller")
public class HotelBillController extends HttpServlet{
	
	BillMngmtService service;	
	@Override
	public void init() throws ServletException {
		System.out.println("HotelBillController.inti()");
	 	service=new BillMngmtServiceImpl ();	
	}
	
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("HotelBillController.doGet()");
		PrintWriter pw;
		HotelBillVO vo;
		HotelBillDto dto;
		String result;
			
		try {
			pw=res.getWriter();
			res.setContentType("text/html");
			
			vo=new HotelBillVO();
			
			vo.setcName(req.getParameter("cn"));
			vo.setcMobNum(req.getParameter("mn"));
			vo.setcBAmount(req.getParameter("ba"));
			
			dto=new HotelBillDto();
			
			 dto.setcName(vo.getcName());
			 dto.setcMNum(Long.parseLong(vo.getcMobNum()));
			 dto.setcBAmount(Double.parseDouble(vo.getcBAmount()));
			
	        
			 result=service.billCalculation(dto);
			
			
			  pw.print("<h1 style='color:green;text-align:center'>Customer Name::</h1>"); 
			  pw.print("<h1 style='color:green;text-align:center'>"+dto.getcName()+"</h1><br>");
			  
			  pw.print("<h1 style='color:green;text-align:center'>Mobile NO::<tr><td>"); 
			  pw.print("<h1 style='color:green;text-align:center'>"+dto.getcMNum()+"</h1><br>");
			   
			  pw.print("<h1 style='color:red;text-align:center>"+result+"</h1>");
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("HotelBillController.doPost()");
		doGet(req,res);
	}

}
