package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.HotelBillBo;

public class HotelBillDaoImpl implements HotelBillDao {
	 private static final String Hotel_Bill="INSERT INTO HOTEL_BILL VALUES(?,?,?,?)" ;
	
   @Override
	public String insert(HotelBillBo bo) throws Exception {
       InitialContext ic=null;
	   DataSource ds=null;
	   Connection con=null;
	   PreparedStatement st=null;
	   int rs; 
	   
	   
	   ic=new InitialContext();
	   ds=(DataSource)ic.lookup("DsJndi");
	   con=ds.getConnection();
	   st=con.prepareStatement("Hotel_Bill");
	   
	   st.setString(1,bo.getcName());
	   st.setLong(2, bo.getcMNum());
	   st.setDouble(3,bo.getcBAmount());
	   st.setDouble(4, bo.getcTBill());
	   
	   rs=st.executeUpdate();
	   
	   if(rs==0) 
	   return "Internal DB Problem";
	   else 
	   return "Record Inset Successfully";
	   
	}

}
