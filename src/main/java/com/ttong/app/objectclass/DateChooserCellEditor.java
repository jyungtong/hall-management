package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import com.ttong.app.objectclass.*;

public class DateChooserCellEditor extends AbstractCellEditor 
		implements TableCellEditor, ActionListener {

	private JDialog dialog;
	private JButton btnEdit;
	private JButton btnSubmit;
	private SpinnerModel dateSpinnerModel;
	private JSpinner dateSpinner;
	private Date date;
	
	public DateChooserCellEditor(Frame f) {
		dialog = new JDialog(f, "Choose Date", true);
		btnSubmit = new JButton("Submit");
		btnEdit = new JButton("Edit");
		dateSpinnerModel = new SpinnerDateModel();
		dateSpinner = new JSpinner(dateSpinnerModel);

		btnSubmit.addActionListener(this);
		btnEdit.addActionListener(this);
		dialog.setSize(350, 100);
		dialog.setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(f);

		dialog.add(dateSpinner);
		dialog.add(btnSubmit);
	}

	public Object getCellEditorValue() {
		return date;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int col) {
		date = (Date) value;
		dateSpinnerModel.setValue(value);
		return btnEdit;
	}

	public void actionPerformed(ActionEvent e) {
		if("Edit".equals(e.getActionCommand())) {
			dialog.setVisible(true);
			fireEditingStopped();
		} else {
			date = (Date) dateSpinner.getValue();
			dialog.dispose();
		}
	}
}
