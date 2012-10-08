package com.ttong.app.objectclass;

import com.ttong.app.model.EventManagerModel;
import com.ttong.app.controller.EventManagerController;
import com.ttong.app.view.EventManagerView;
import javax.swing.*;

public class EventManager extends User {

	public EventManager() {}

	public EventManager(String uid, String uname, char[] pwd) {
		super(uid, uname, pwd);
	}

	@Override
	public void openView() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EventManagerModel eventManagerModel = new EventManagerModel();
				EventManagerView eventManagerView = new EventManagerView(eventManagerModel);
				EventManagerController eventManagerController = 
								new EventManagerController(eventManagerView, eventManagerModel);
			}
		});
	}
}
