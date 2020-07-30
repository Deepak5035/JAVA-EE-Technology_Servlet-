package com.nt.service;

import com.nt.dto.HotelBillDto;

public interface BillMngmtService {
    public String billCalculation(HotelBillDto dto)throws Exception;
}
