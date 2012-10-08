package com.ttong.app.controller;

import com.ttong.app.view.ReceptionistView;
import com.ttong.app.view.LoginView;
import com.ttong.app.model.ReceptionistModel;
import com.ttong.app.model.LoginModel;
import com.ttong.app.controller.LoginController;
import java.awt.event.*;

public class ReceptionistController {
	private ReceptionistView view;
	private ReceptionistModel model;

	public ReceptionistController(ReceptionistView view, ReceptionistModel model) {
		this.view = view;
		this.model = model;

		view.addExitListener(new ExitListener());
		view.addSignOutListener(new SignOutListener());
		view.addSearchListener(new SearchListener());
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

	class SearchListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			model.searchBooking(view.getSearchText());
		}
		
		public void keyTyped(KeyEvent e) {
		}
	}
}
