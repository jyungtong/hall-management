package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.ttong.app.objectclass.*;

public class HallDimensionCellEditor extends AbstractCellEditor 
		implements TableCellEditor, ActionListener {
	
	private JDialog dialog;
	private JButton btnEdit;
	private JButton btnSubmit;
	private JLabel lblWidth;
	private JLabel lblLength;
	private JTextField txtWidth;
	private JTextField txtLength;
	private HallDimension dimension;

	public HallDimensionCellEditor(Frame f) {
		dialog = new JDialog(f, "Dimension Editor", true);
		btnSubmit = new JButton("Submit");
		btnEdit = new JButton("Edit");
		lblWidth = new JLabel("Width");
		lblLength = new JLabel("Length");
		txtWidth = new JTextField(4);
		txtLength = new JTextField(4);

		btnSubmit.addActionListener(this);
		btnEdit.addActionListener(this);
		dialog.setSize(230, 100);
		dialog.setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(f);

		dialog.add(lblWidth);
		dialog.add(txtWidth);
		dialog.add(lblLength);
		dialog.add(txtLength);
		dialog.add(btnSubmit);
	}

	public void actionPerformed(ActionEvent e) {
		if("Edit".equals(e.getActionCommand())) {
			dialog.setVisible(true);
			fireEditingStopped();
		} else {
			try {
				dimension.setX(Integer.parseInt(txtWidth.getText()));
				dimension.setY(Integer.parseInt(txtLength.getText()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Should be integer only.");
			}

			dialog.dispose();
		}
	}

	public Component getTableCellEditorComponent(JTable table, Object value, 
			boolean isSelected, int row, int col) {
		dimension = (HallDimension) value;
		txtWidth.setText(Integer.toString(dimension.getX()));
		txtLength.setText(Integer.toString(dimension.getY()));
		return btnEdit;
	}

	public Object getCellEditorValue() {
		return dimension;
	}
}
