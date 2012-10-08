package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import com.ttong.app.objectclass.*;

public class ContactCellEditor extends AbstractCellEditor 
		implements TableCellEditor, ActionListener {

	private JDialog dialog;
	private JButton btnEdit;
	private JButton btnSubmit;
	private JLabel lblCustName;
	private JLabel lblIdentityNum;
	private JLabel lblAddr;
	private JLabel lblTelNo;
	private JLabel lblEmail;
	private JTextField txtCustName;
	private JTextField txtIdentityNum;
	private JTextField txtAddr;
	private JTextField txtTelNo;
	private JTextField txtEmail;
	private Contact contact;
	
	public ContactCellEditor(Frame f) {
		dialog = new JDialog(f, "Edit Contact", true);
		btnSubmit = new JButton("Submit");
		btnEdit = new JButton("Edit");
		lblCustName = new JLabel("Customer Name: ");
		lblIdentityNum = new JLabel("Identity Number: ");
		lblAddr = new JLabel("Address: ");
		lblTelNo = new JLabel("Telephone Number: ");
		lblEmail = new JLabel("Email: ");
		txtCustName = new JTextField(25);
		txtIdentityNum = new JTextField(25);
		txtAddr = new JTextField(25);
		txtTelNo = new JTextField(25);
		txtEmail = new JTextField(25);

		btnSubmit.addActionListener(this);
		btnEdit.addActionListener(this);
		dialog.setSize(300, 350);
		dialog.setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(null);

		dialog.add(lblCustName);
		dialog.add(txtCustName);
		dialog.add(lblIdentityNum);
		dialog.add(txtIdentityNum);
		dialog.add(lblAddr);
		dialog.add(txtAddr);
		dialog.add(lblTelNo);
		dialog.add(txtTelNo);
		dialog.add(lblEmail);
		dialog.add(txtEmail);
		dialog.add(btnSubmit);
	}

	public Object getCellEditorValue() {
		return contact;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int col) {
		contact = (Contact) value;
		txtCustName.setText(contact.getCustName());
		txtIdentityNum.setText(contact.getIdentityNum());
		txtAddr.setText(contact.getAddress());
		txtTelNo.setText(contact.getTelNo());
		txtEmail.setText(contact.getEmail());
		return btnEdit;
	}

	public void actionPerformed(ActionEvent e) {
		if("Edit".equals(e.getActionCommand())) {
			dialog.setVisible(true);
			fireEditingStopped();
		} else {
			contact = new Contact(txtCustName.getText(), txtIdentityNum.getText(),
					txtAddr.getText(), txtTelNo.getText(), txtEmail.getText());
			dialog.dispose();
		}
	}
}
