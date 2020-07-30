package com.nt.dto;

public class HotelBillDto {
	private String cName;
	private long cMNum;
	private Double cBAmount;
	
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcMNum() {
		return cMNum;
	}
	public void setcMNum(long cMNum) {
		this.cMNum = cMNum;
	}
	public Double getcBAmount() {
		return cBAmount;
	}
	public void setcBAmount(Double cBAmount) {
		this.cBAmount = cBAmount;
	}
}
