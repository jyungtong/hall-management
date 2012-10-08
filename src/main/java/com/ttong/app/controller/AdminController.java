package com.ttong.app.controller;

import com.ttong.app.view.*;
import com.ttong.app.model.*;
import com.ttong.app.controller.*;
import com.ttong.app.objectclass.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class AdminController {
	private AdminView view;
	private AdminModel model;

	public AdminController(AdminView view, AdminModel model) {
		this.view = view;
		this.model = model;
		
		view.addAddListener(new AddListener());
		view.addDeleteListener(new DeleteListener());

		view.addSignOutListener(new SignOutListener());
		view.addExitListener(new ExitListener());

	}

	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int[] rows = view.getHallTableSelectedRows();
			if(rows.length > 0) {
				model.removeHallTableRows(rows);
			}
		}
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.addHallTableRow();
		}
	}

	class SignOutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginModel loginModel = new LoginModel();
			LoginView loginView = new LoginView();
			LoginController loginController = new LoginController(loginView, loginModel);
			view.dispose();
		}
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			System.exit(0);
		}
	}
}
