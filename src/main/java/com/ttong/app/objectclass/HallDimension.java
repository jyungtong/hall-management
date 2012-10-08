package com.ttong.app.objectclass;

import java.io.*;

public class HallDimension implements Serializable {
	private static final long serialVersionUID = 3434654765L;
	private int x, y;

	public HallDimension() {}

	public HallDimension(int x, int y) {
		setX(x);
		setY(y);
	}

	/*
	 * Setters for HallDimension
	 */
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	/*
	 * Getters for HallDimension
	 */
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getArea(){
		return this.x * this.y;
	}

	public String toString() {
		String str = getX() + " x " + getY();
		return str;
	}
}
