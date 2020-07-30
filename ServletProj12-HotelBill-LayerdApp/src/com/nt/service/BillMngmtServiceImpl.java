package com.nt.service;

import com.nt.bo.HotelBillBo;
import com.nt.dao.HotelBillDao;
import com.nt.dao.HotelBillDaoImpl;
import com.nt.dto.HotelBillDto;

public class BillMngmtServiceImpl implements BillMngmtService {


	@Override
	public String billCalculation(HotelBillDto dto) throws Exception {
		System.out.println("BillMngmtServiceImpl.billCalculation()");
		Double cBAmount;
		Double sgst,cgst;
		Double cTBill;
		HotelBillDao dao; 
		HotelBillBo bo;
		String rs=null;
		cBAmount=dto.getcBAmount();
		//calculate state gst 8%
		sgst=cBAmount*(0.8);
		//calculate central gst 18%
		cgst=cBAmount*(0.18);
		//total bill Amount
		cTBill=cBAmount+sgst+cgst;
		
		//create Bo class Object
		
		bo=new HotelBillBo();
		
		bo.setcName(dto.getcName());
		bo.setcMNum(dto.getcMNum());
		bo.setcBAmount(dto.getcBAmount());
		bo.setcTBill(cTBill);
    
        dao=new HotelBillDaoImpl(); 		
		rs=dao.insert(bo);
        return rs;
	}

}
