package com.ttong.app.objectclass;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.ttong.app.objectclass.HallType;

public class HallTypeComboboxCellEditor extends AbstractCellEditor 
		implements TableCellEditor {
	
	private JComponent component;

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int col) {

		component = new JComboBox();

		for(HallType htype : HallType.values()) {
			((JComboBox) component).addItem(htype);
		}

		return component;
	}

	public Object getCellEditorValue() {
		return ((JComboBox) component).getSelectedItem(); 
	}
}
