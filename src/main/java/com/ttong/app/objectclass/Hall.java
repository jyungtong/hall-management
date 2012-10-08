package com.ttong.app.objectclass;

import java.util.*;
import java.io.*;
import com.ttong.app.AppConstants;

public class Hall implements Serializable {
	private static final long serialVersionUID = 324354366544L; 
	private int hallNo;
	private int floor;
	private HallType hallType;
	private HallType seatingStyle;
	private HallDimension dimension;
	private List<String> facilities;

	public Hall() {}

	public Hall(int hno, int f, HallType hType, HallType sStyle, HallDimension d, 
								List<String> fac) {
		setHallNo(hno);
		setFloor(f);
		setHallType(hType);
		setSeatingStyle(sStyle);
		setDimension(d);

		if( fac != null ) {
			setFacilities(fac);
		} else {
			facilities = new ArrayList<String>();
		}
	}

	/*
	 * Setters for Hall
	 */
	public void setHallNo(int hallNo){
		this.hallNo = hallNo;
	}

	public void setFloor(int floor){
		this.floor = floor;
	}

	public void setHallType(HallType hallType){
		this.hallType = hallType;
	}

	public void setSeatingStyle(HallType seatingStyle){
		this.seatingStyle = seatingStyle;
	}

	public void setDimension(HallDimension dimension){
		this.dimension = dimension;
	}

	public void setFacilities(List<String> facilities){
		this.facilities = facilities;
	}

	public void addFacilities(String f){
		this.facilities.add(f);
	}

	/*
	 * Getters for hall
	 */
	public int getHallNo(){
		int floor = getFloor() * 1000;
		return this.hallNo + floor;
	}

	public int getFloor(){
		return this.floor;
	}

	public HallType getHallType(){
		return this.hallType;
	}

	public HallType getSeatingStyle(){
		return this.seatingStyle;
	}

	public HallDimension getDimension(){
		return this.dimension;
	}

	public int getArea() {
		return this.dimension.getArea();
	}


	public int getCapacity(){
		int hallTypeCap = 0;
		int seatingStyleCap = 0;

		switch (this.hallType) {
			case RECEPTION:
				hallTypeCap = AppConstants.RECEPTION;
				break;
			case THEATRE:
				hallTypeCap = AppConstants.THEATRE;
				break;
			case BANQUET:
				hallTypeCap = AppConstants.BANQUET;
				break;
			case CLASSROOM:
				hallTypeCap = AppConstants.CLASSROOM;
				break;
			case USHAPE:
				hallTypeCap = AppConstants.USHAPE;
				break;
			case HOLLOWSQUARE:
				hallTypeCap = AppConstants.HOLLOWSQUARE;
				break;
			case BOARDROOM:
				hallTypeCap = AppConstants.BOARDROOM;
				break;
		}

		switch (this.seatingStyle) {
			case RECEPTION:
				seatingStyleCap = AppConstants.RECEPTION;
				break;
			case THEATRE:
				seatingStyleCap = AppConstants.THEATRE;
				break;
			case BANQUET:
				seatingStyleCap = AppConstants.BANQUET;
				break;
			case CLASSROOM:
				seatingStyleCap = AppConstants.CLASSROOM;
				break;
			case USHAPE:
				seatingStyleCap = AppConstants.USHAPE;
				break;
			case HOLLOWSQUARE:
				seatingStyleCap = AppConstants.HOLLOWSQUARE;
				break;
			case BOARDROOM:
				seatingStyleCap = AppConstants.BOARDROOM;
				break;
		}

		return hallTypeCap * seatingStyleCap;
	}

	public double getRentPerDay(){
		double area = (double) this.dimension.getArea();
		double rentPerDay = 0;

		switch (this.hallType) {
			case RECEPTION:
				rentPerDay = AppConstants.RPDRECEPTION;
				break;
			case THEATRE:
				rentPerDay = AppConstants.RPDTHEATRE;
				break;
			case BANQUET:
				rentPerDay = AppConstants.RPDBANQUET;
				break;
			case CLASSROOM:
				rentPerDay = AppConstants.RPDCLASSROOM;
				break;
			case USHAPE:
				rentPerDay = AppConstants.RPDUSHAPE;
				break;
			case HOLLOWSQUARE:
				rentPerDay = AppConstants.RPDHOLLOWSQUARE;
				break;
			case BOARDROOM:
				rentPerDay = AppConstants.RPDBOARDROOM;
				break;
		}

		return rentPerDay * area;
	}

	public List<String> getFacilities() {
		return this.facilities;
	}
	
	public String facilitiesToString() {
		StringBuilder str = new StringBuilder();
		int size = this.facilities.size();

		for(int i = 0; i < size; i++, str.append(", ")) {
			str.append(this.facilities.get(i));
		}

		return str.toString();
	}
}
