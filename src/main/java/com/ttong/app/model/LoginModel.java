package com.ttong.app.model;

import com.ttong.app.objectclass.User;

public class LoginModel {
	public User login(String id, char[] pwd) {
		return User.login(id, pwd); 
	}
}
