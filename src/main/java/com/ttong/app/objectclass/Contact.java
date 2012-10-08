package com.ttong.app.objectclass;

import java.io.*;

public class Contact implements Serializable {
	private String custName;
	private String identityNum;
	private String address;
	private String telNo;
	private String email;

	public Contact() {}

	public Contact(String cName, String iNum, String addr, 
			String telNo, String email) {
		setName(cName);
		setIdentityNum(iNum);
		setAddress(addr);
		setTelNo(telNo);
		setEmail(email);
	}

	public void setName(String custName){
		this.custName = custName;
	}

	public void setIdentityNum(String identityNum){
		this.identityNum = identityNum;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setTelNo(String telNo){
		this.telNo = telNo;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getCustName(){
		return this.custName;
	}

	public String getIdentityNum(){
		return this.identityNum;
	}

	public String getAddress(){
		return this.address;
	}

	public String getTelNo(){
		return this.telNo;
	}

	public String getEmail(){
		return this.email;
	}

	public String toString() {
		String str = getCustName() + ", "
									+ getIdentityNum() + ", "
									+ getAddress() + ", "
									+ getTelNo() + ", "
									+ getEmail();
		return str;
	}
}
