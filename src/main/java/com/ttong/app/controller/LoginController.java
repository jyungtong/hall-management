package com.ttong.app.controller;

import java.awt.event.*;
import com.ttong.app.view.LoginView;
import com.ttong.app.model.LoginModel;
import com.ttong.app.objectclass.User;

public class LoginController {
	private LoginView view;
	private LoginModel model;

	public LoginController(LoginView view, LoginModel model) {
		this.view = view;
		this.model = model;

		view.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String loginId = view.getLoginId();
			char[] password = view.getLoginPassword();

			User loginUser = model.login(loginId, password);

			if( loginUser != null ) {
				loginUser.openView();
				view.dispose();
			} else {
				view.popMessage("Wrong Username and Password");
			}
		}
	}
}
