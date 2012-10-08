package com.ttong.app.controller;

import com.ttong.app.view.EventManagerView;
import com.ttong.app.view.LoginView;
import com.ttong.app.model.EventManagerModel;
import com.ttong.app.model.LoginModel;
import com.ttong.app.controller.LoginController;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EventManagerController {
	private EventManagerView view;
	private EventManagerModel model;

	public EventManagerController(EventManagerView view, EventManagerModel model) {
		this.view = view;
		this.model = model;

		view.addAddListener(new AddListener());
		view.addDeleteListener(new DeleteListener());
		view.addExitListener(new ExitListener());
		view.addSignOutListener(new SignOutListener());
		view.addHallTableListSelectionListener(new HallTableListSelectionListener());
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

	class HallTableListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				int selectedHall = (int) model.getHallTableModel().getValueAt(view.getHallTableSelectedRow(), 0);
				model.readSelectedBooking(selectedHall);
			}
		}
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getHallTableSelectedRow();

			if(selectedRow >= 0) {
				int selectedHall = (int) model.getHallTableModel().getValueAt(selectedRow, 0);
				model.addBookingTableRow(selectedHall);
			} else {
				JOptionPane.showMessageDialog(null, "Please select a hall row first.");
			}
		}
	}

	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int[] selectedRows = view.getBookingTableSelectedRows();

			if(selectedRows.length > 0) {
				model.removeBookingTableRow(selectedRows);
			} else {
				JOptionPane.showMessageDialog(null, "Please select a booking row first.");
			}
		}
	}
}
