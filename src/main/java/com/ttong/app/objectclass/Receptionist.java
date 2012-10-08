package com.ttong.app.objectclass;

import com.ttong.app.view.ReceptionistView;
import com.ttong.app.controller.ReceptionistController;
import com.ttong.app.model.ReceptionistModel;
import javax.swing.*;

public class Receptionist extends User {

	public Receptionist() {}

	public Receptionist(String uid, String uname, char[] pwd) {
		super(uid, uname, pwd);
	}

	@Override
	public void openView() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReceptionistModel receptionistModel = new ReceptionistModel();
				ReceptionistView receptionistView = new ReceptionistView(receptionistModel);
				ReceptionistController receptionistController = new ReceptionistController(receptionistView, receptionistModel);
			}
		});
	}
}
