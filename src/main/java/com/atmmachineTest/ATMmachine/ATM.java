package com.atmmachineTest.ATMmachine;

public class ATM 
{ 
	private long atmCardNo;
	private int atmPinNo;
	
	public ATM() 
	{
		super();
		
	}

	public ATM(long atmCardNo, int atmPinNo) 
	{
		
		this.atmCardNo = atmCardNo;
		this.atmPinNo = atmPinNo;
	}

	public long getAtmCardNo() {
		return atmCardNo;
	}

	public void setAtmCardNo(long atmCardNo) {
		this.atmCardNo = atmCardNo;
	}

	public int getAtmPinNo() {
		return atmPinNo;
	}

	public void setAtmPinNo(int atmPinNo) {
		this.atmPinNo = atmPinNo;
	}

	
	
	
	
	
	
}
