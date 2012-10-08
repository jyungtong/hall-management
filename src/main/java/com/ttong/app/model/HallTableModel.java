package com.ttong.app.model;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import com.ttong.app.objectclass.*;
import com.ttong.app.AppConstants;

public class HallTableModel extends AbstractTableModel {
	private String[] columnNames;
	private Hall[] data;
	private Booking[] bookings;
	private DbWrite writer;
	private DbRead reader;

	public HallTableModel() {
		columnNames = new String[] {
			"Hall ID",
			"Floor",
			"Hall Type",
			"Seating Style",
			"Dimension",
			"Area",
			"Capacity",
			"Rent Per Day",
			"Facilities"
		};

		reader = new DbRead(AppConstants.HALLDB);
		data = (Hall[]) reader.getData();
		
		reader = new DbRead(AppConstants.BOOKINGDB);
		bookings = (Booking[]) reader.getData();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if(data != null) {
			return data.length;
		} else {
			return 0;
		}
	}

	public Object getValueAt(int row, int col) {
		Object value = null;

		switch(col) {
			case 0:
				value = data[row].getHallNo();
				break;
			case 1:
				value = data[row].getFloor();
				break;
			case 2:
				value = data[row].getHallType();
				break;
			case 3:
				value = data[row].getSeatingStyle();
				break;
			case 4:
				value = data[row].getDimension();
				break;
			case 5:
				value = data[row].getArea();
				break;
			case 6:
				value = data[row].getCapacity();
				break;
			case 7:
				value = data[row].getRentPerDay();
				break;
			case 8:
				value = data[row].facilitiesToString();
				break;
			}

		return value;
	}

	public void setValueAt(Object value, int row, int col) {
		switch(col) {
			case 0:
				data[row].setHallNo((Integer) value);
				break;
			case 1:
				data[row].setFloor((Integer) value);
				break;
			case 2:
				data[row].setHallType((HallType) value);
				break;
			case 3:
				data[row].setSeatingStyle((HallType) value);
				break;
			case 4:
				data[row].setDimension((HallDimension) value);
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				data[row].setFacilities((List<String>) value);
				break;
		}

		fireTableDataChanged();
		writeChanges();
	}

	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public boolean isCellEditable(int row, int col) {
		int curHallId = (int) getValueAt(row, 0);

		for(Booking b : bookings) {
			if(curHallId == b.getHallNum()) {
				return false;
			}
		}

		switch(col) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 8:
				return true;
			default:
				return false;
		}
	}

	protected void writeChanges() {
		DbWrite writer = new DbWrite(AppConstants.HALLDB);
		writer.writeData(data);
	}

	protected int getUniqueId() {
		boolean exist = true;
		int randNum = 0;

		if(data != null) {
			while(exist) {
				randNum = RandomNumber.getNumber(0, 999);
				for(Hall h : data) {
					if(h.getHallNo() == randNum) {
						exist = true;
						break;
					} else {
						exist = false;
					}
				}
			}
		} else {
			return RandomNumber.getNumber(0, 999);
		}

		return randNum;
	}

	public void removeRows(int[] rows) {
		int newSize = getRowCount() - rows.length;
		Hall[] temp = new Hall[newSize];

		for(int i = 0, j = 0, k = 0; i < getRowCount() && j < newSize; i++) {
			if(rows[k] != i){
				temp[j++] = data[i];
			} else {
				if(k < rows.length-1) {
					k++;
				}
			}
		}

		data = temp;
		writeChanges();
		fireTableDataChanged();
	}

	public void addRow() {
		int newSize = getRowCount() + 1;
		Hall[] temp = new Hall[newSize];

		int i;
		for (i = 0; i < getRowCount(); i++) {
			temp[i] = data[i];
		}

		temp[i] = new Hall(getUniqueId(), 1, HallType.THEATRE, HallType.THEATRE, new HallDimension(1, 1), new ArrayList<String>());

		data = temp;
		fireTableRowsInserted(newSize-1, newSize-1);
		writeChanges();
	}

}
