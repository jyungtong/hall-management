package com.ttong.app.model;

import com.ttong.app.model.HallTableModel;
import com.ttong.app.objectclass.Hall;

public class AdminModel {
	private HallTableModel hallTableModel;

	public AdminModel() {
		hallTableModel = new HallTableModel();
	}

	public HallTableModel getHallTableModel() {
		return hallTableModel;
	}

	public void removeHallTableRows(int[] rows) {
		hallTableModel.removeRows(rows);
	}

	public void addHallTableRow() {
		hallTableModel.addRow();
	}
}
