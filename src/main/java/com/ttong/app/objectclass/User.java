package com.ttong.app.objectclass;

import com.ttong.app.AppConstants;
import java.io.*;
import java.util.*;

public class User implements Serializable {
	private String userId;
	private String username;
	private char[] password;

	/*
	 * Constructor of User
	 */
	public User() {}
	
	public User(String uid, String uname, char[] pwd) {
		setUserId(uid);
		setUsername(uname);
		setPassword(pwd);
	}

	/*
	 * Setters for User
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(char[] password){
		this.password = password;
	}

	/*
	 * Getters for User
	 */
	public String getUserId(){
		return this.userId;
	}

	public String getUsername(){
		return this.username;
	}

	public char[] getPassword(){
		return this.password;
	}

	/*
	 * Login method
	 */
	public static User login(String uname, char[] pwd) {
		DbRead reader = new DbRead(AppConstants.USERDB);
		User[] users = (User[]) reader.getData();

		for(User u : users) {
			if( u.getUsername().equals(uname) ) {
				if( Arrays.equals(u.getPassword(), pwd) ) {
					return u;
				}
			}
		}

		return null;
	}

	/*
	 * Construct a new view for successfully log in users
	 */
	public void openView() {}

	public String toString() {
		String str = "User ID: " + getUserId() + "\n"
									+ "Username: " + getUsername() + "\n"
									+ "Password: " + Arrays.toString(getPassword()) + "\n";
		return str;
	}
}
