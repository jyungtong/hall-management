package com.ttong.app.model;

import com.ttong.app.model.HallTableModel;

public class EventManagerModel {
	private HallTableModel hallTableModel;
	private BookingTableModel bookingTableModel;

	public EventManagerModel() {
		hallTableModel = new HallTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		bookingTableModel = new BookingTableModel();
	}

	public HallTableModel getHallTableModel() {
		return hallTableModel;
	}

	public BookingTableModel getBookingTableMode() {
		return bookingTableModel;
	}

	public void addBookingTableRow(int hallNum) {
		bookingTableModel.addRow(hallNum);
	}

	public void removeBookingTableRow(int[] rows) {
		bookingTableModel.removeRows(rows);
	}

	public void readSelectedBooking(int hallId) {
		bookingTableModel.readBookings(hallId);
	}
}
