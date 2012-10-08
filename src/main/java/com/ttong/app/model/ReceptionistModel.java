package com.ttong.app.model;

import com.ttong.app.model.HallTableModel;
import com.ttong.app.model.BookingTableModel;
import com.ttong.app.objectclass.Hall;

public class ReceptionistModel {
	private HallTableModel hallTableModel;
	private BookingTableModel bookingTableModel;

	public ReceptionistModel() {
		bookingTableModel = new BookingTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		hallTableModel = new HallTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	}

	public HallTableModel getHallTableModel() {
		return hallTableModel;
	}

	public BookingTableModel getBookingTableModel() {
		return bookingTableModel;
	}

	public void searchBooking(String custName) {
		bookingTableModel.searchBooking(custName);
	}
}
