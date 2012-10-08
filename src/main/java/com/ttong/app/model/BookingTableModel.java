package com.ttong.app.model;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import com.ttong.app.objectclass.*;
import com.ttong.app.AppConstants;

public class BookingTableModel extends AbstractTableModel {
	private String[] columnNames;
	private Booking[] displayBookings = null;
	private Booking[] fullBookings = null;
	private DbWrite writer;
	private DbRead reader;

	public BookingTableModel() {
		columnNames = new String[] {
			"Booking ID",
			"Booking Hall",
			"Date",
			"Customer Info"
		};

		reader = new DbRead(AppConstants.BOOKINGDB);
		displayBookings = (Booking[]) reader.getData();
		fullBookings = displayBookings;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		if(displayBookings != null) {
			return displayBookings.length;
		} else {
			return 0;
		}
	}

	public Object getValueAt(int row, int col) {
		Object value = null;

		if(displayBookings != null) {
			switch(col) {
				case 0:
					value = displayBookings[row].getBookingNum();
					break;
				case 1:
					value = displayBookings[row].getHallNum();
					break;
				case 2:
					value = displayBookings[row].getBookingDate().getTime();
					break;
				case 3:
					value = displayBookings[row].getInfo();
					break;
			}
		}

		return value;
	}

	public void setValueAt(Object value, int row, int col) {
		switch(col) {
			case 0:
				displayBookings[row].setBookingNum((int) value);
				break;
			case 1:
				displayBookings[row].setHallNum((int) value);
				break;
			case 2:
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) value);
				displayBookings[row].setBookingDate(cal);
				break;
			case 3:
				displayBookings[row].setContactInfo((Contact) value);
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
		switch(col) {
			case 2:
			case 3:
				return true;
			default:
				return false;
		}
	}

	protected void writeChanges() {
		DbWrite writer = new DbWrite(AppConstants.BOOKINGDB);
		writer.writeData(fullBookings);
	}

	protected int getUniqueId() {
		boolean exist = true;
		int randNum = 0;

		DbRead reader = new DbRead(AppConstants.BOOKINGDB);
		Booking[] temp = (Booking[]) reader.getData();

		if(temp != null) {
			while(exist) {
				randNum = RandomNumber.getNumber(0, 999);
				for(Booking b : temp) {
					if(b.getBookingNum() == randNum) {
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
		int newSize = fullBookings.length - rows.length;
		int displaySize = getRowCount();
		int selectedHall = (int) getValueAt(0, 1);
		Booking[] temp = new Booking[newSize];
		int[] toBeDeletedBookId = new int[rows.length];

		for(int i = 0; i < rows.length; i++) {
			toBeDeletedBookId[i] = (int) getValueAt(rows[i], 0);
		}

		for(int i = 0, j = 0, k = 0; i < fullBookings.length && j < newSize; i++) {
			if(toBeDeletedBookId[k] != fullBookings[i].getBookingNum()){
				temp[j++] = fullBookings[i];
			} else {
				if(k < toBeDeletedBookId.length - 1) {
					k++;
				}
			}
		}

		fullBookings = temp;
		readBookings(selectedHall);
		writeChanges();
	}

	public void addRow(int hallNum) {
		Booking tempNewBooking = new Booking(getUniqueId(), hallNum, 
								Calendar.getInstance(), new Contact("","","","",""));

		if(fullBookings != null) {
			int newSize = fullBookings.length + 1;
			Booking[] temp = new Booking[newSize];

			int i;
			for (i = 0; i < newSize - 1; i++) {
				temp[i] = fullBookings[i];
			}

			temp[i] = tempNewBooking;	
			fullBookings = temp;
		} else {
			fullBookings = new Booking[] { tempNewBooking };
		}

		readBookings(hallNum);
		writeChanges();
	}

	public void readBookings(int hallId) {
		if(fullBookings != null) {
			ArrayList<Booking> temp = new ArrayList<Booking>();
			for(Booking b : fullBookings) {
				if(hallId == b.getHallNum()) {
					temp.add(b);
				}
			}

			int size = temp.size();
			int i = 0;
			Booking[] newDisplayBookings = new Booking[size];
			
			for(Object obj : temp) {
				newDisplayBookings[i++] = (Booking) obj;
			}

			displayBookings = newDisplayBookings;
			fireTableDataChanged();
		}
	}

	public void searchBooking(String custName) {
		String pattern = ".*" + custName + ".*";
		ArrayList<Booking> matchedBookings = new ArrayList<Booking>();
		
		for(Booking b : fullBookings) {
			if(b.getInfo().getCustName().matches(pattern)) {
				matchedBookings.add(b);
			}
		}

		displayBookings = new Booking[matchedBookings.size()];

		for (int i = 0; i < displayBookings.length; i++) {
			displayBookings[i] = matchedBookings.get(i);
		}

		fireTableDataChanged();
	}
}
