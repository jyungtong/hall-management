package com.ttong.app.objectclass;

import java.util.*;
import java.io.*;

public class Booking implements Serializable {
	private int bookingNum;
	private int hallNum;
	private Calendar bookingDate;
	private Contact info;

	public Booking() {}

	public Booking(int bNum, int hNum, Calendar bDate, Contact i) {
		setBookingNum(bNum);
		setHallNum(hNum);
		setBookingDate(bDate);
		setContactInfo(i);
	}

	public void setBookingNum(int bookingNum){
		this.bookingNum = bookingNum;
	}

	public void setHallNum(int hallNum){
		this.hallNum = hallNum;
	}

	public void setBookingDate(Calendar bookingDate){
		this.bookingDate = bookingDate;
	}

	public void setContactInfo(Contact info){
		this.info = info;
	}

	public int getBookingNum(){
		return this.bookingNum;
	}

	public int getHallNum(){
		return this.hallNum;
	}

	public Calendar getBookingDate(){
		return this.bookingDate;
	}

	public Contact getInfo(){
		return this.info;
	}
}
