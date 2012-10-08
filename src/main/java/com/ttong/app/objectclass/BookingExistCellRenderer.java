package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import com.ttong.app.model.HallTableModel;
import com.ttong.app.AppConstants;

public class BookingExistCellRenderer extends DefaultTableCellRenderer {
	private HallTableModel tableModel;

	public BookingExistCellRenderer(HallTableModel model) {
		super();
	}
}
