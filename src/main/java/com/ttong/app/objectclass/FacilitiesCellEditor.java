package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import com.ttong.app.objectclass.*;

public class FacilitiesCellEditor extends AbstractCellEditor 
		implements TableCellEditor, ActionListener {
	
	private JDialog dialog;
	private JButton btnEdit;
	private JButton btnSubmit;
	private JTextField txtFacilities;
	private List<String> facilities;

	public FacilitiesCellEditor(Frame f) {
		dialog = new JDialog(f, "Edit Facilities", true);
		btnSubmit = new JButton("Submit");
		btnEdit = new JButton("Edit");
		txtFacilities = new JTextField(30);

		btnSubmit.addActionListener(this);
		btnEdit.addActionListener(this);
		dialog.setSize(350, 100);
		dialog.setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(f);

		dialog.add(txtFacilities);
		dialog.add(btnSubmit);
	}

	public void actionPerformed(ActionEvent e) {
		if("Edit".equals(e.getActionCommand())) {
			dialog.setVisible(true);
			fireEditingStopped();
		} else {
			stringToArrayList(txtFacilities.getText());
			dialog.dispose();
		}
	}

	public Component getTableCellEditorComponent(JTable table, Object value, 
			boolean isSelected, int row, int col) {
		stringToArrayList((String) value);
		txtFacilities.setText((String) value);
		return btnEdit;
	}

	public Object getCellEditorValue() {
		return facilities;
	}

	protected void stringToArrayList(String str) {
		facilities = new ArrayList<String>();
		String[] fac = str.split(",");
		for( String f : fac )
			if(!f.equals(" ")) 
				facilities.add(f.trim());
	}
}
