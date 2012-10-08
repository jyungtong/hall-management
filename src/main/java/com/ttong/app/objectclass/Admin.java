package com.ttong.app.objectclass;

import com.ttong.app.view.AdminView;
import com.ttong.app.model.AdminModel;
import com.ttong.app.controller.AdminController;
import javax.swing.*;

public class Admin extends User {

	public Admin() {}

	public Admin(String uid, String uname, char[] pwd) {
		super(uid, uname, pwd);
	}

	@Override
	public void openView() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminModel adminModel = new AdminModel();
				AdminView adminView = new AdminView(adminModel);
				AdminController adminController = new AdminController(adminView, adminModel);
			}
		});
	}
}
