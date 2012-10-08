package com.ttong.app.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import com.ttong.app.model.EventManagerModel;
import com.ttong.app.objectclass.*;

public class EventManagerView {
	/*
	 * GUI components
	 */
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu  actionMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem signOutMenuItem;
	private JTable hallTable;
	private JTable bookingTable;
	private JPanel pnlHallTable;
	private JPanel			pnlBooking;
	private JPanel 			pnlOptions;
	private JScrollPane hallTableScroll;
	private JScrollPane bookingTableScroll;
	private GridBagConstraints c;
	private EventManagerModel eventManagerModel;
	private JButton 		btnAdd;
	private JButton 		btnDelete;

	/*
	 * EventManager Constructor
	 */
	public EventManagerView(EventManagerModel model) {
		this.eventManagerModel = model;
		initUI();

		hallTable.setModel(eventManagerModel.getHallTableModel());
		bookingTable.setModel(eventManagerModel.getBookingTableMode());
		bookingTable.getColumnModel().getColumn(2).setCellEditor(new DateChooserCellEditor(frame));
		bookingTable.getColumnModel().getColumn(3).setCellEditor(new ContactCellEditor(frame));
	}

	/*
	 * Initialise the event manager form
	 */
	private void initUI() {
		/*
		 * Initialize all required component
		 */
		frame = new JFrame("Hall Event Management View");
		menuBar = new JMenuBar();
		actionMenu = new JMenu("Action");
		signOutMenuItem = new JMenuItem("Sign Out");
		exitMenuItem 		= new JMenuItem("Exit");
		pnlHallTable = new JPanel();
		pnlBooking = new JPanel();
		pnlOptions = new JPanel();
		hallTable = new JTable();
		bookingTable = new JTable();
		hallTableScroll = new JScrollPane(hallTable);
		bookingTableScroll = new JScrollPane(bookingTable);
		btnAdd = new JButton("Add Booking");
		btnDelete = new JButton("Delete Booking");

		/*
		 * Setting up hall table in panel
		 */
		pnlHallTable.setLayout(new BorderLayout());
		pnlHallTable.setBorder(BorderFactory.createTitledBorder("Hall Event Table"));
		pnlHallTable.add(hallTableScroll, BorderLayout.CENTER);
		hallTable.setFillsViewportHeight(true);
		hallTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hallTable.setRowHeight(40);

		/*
		 * Setting up booking table in panel
		 */
		pnlBooking.setLayout(new BorderLayout());
		pnlBooking.setBorder(BorderFactory.createTitledBorder("Booking Table"));
		pnlBooking.add(bookingTableScroll, BorderLayout.CENTER);
		bookingTable.setFillsViewportHeight(true);
		bookingTable.setRowHeight(40);

		/*
		 * Setting up options available in panel
		 */
		pnlOptions.setLayout(new FlowLayout());
		pnlOptions.setBorder(BorderFactory.createTitledBorder("Options"));
		pnlOptions.add(btnAdd);
		pnlOptions.add(btnDelete);

		/*
		 * Setting frame properties
		 */
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 2.0;
		c.weighty = 2.0;
		frame.getContentPane().add(pnlHallTable, c);

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		frame.getContentPane().add(pnlBooking, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weighty = 0.1;
		frame.getContentPane().add(pnlOptions, c);

		/*
		 * Initiate jmenubar in frame
		 */
		frame.setJMenuBar(menuBar);
		menuBar.add(actionMenu);
		actionMenu.add(exitMenuItem);
		actionMenu.add(signOutMenuItem);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void dispose() {
		this.frame.dispose();
	}

	public void addExitListener(ActionListener listener) {
		exitMenuItem.addActionListener(listener);
	}

	public void addSignOutListener(ActionListener listener) {
		signOutMenuItem.addActionListener(listener);
	}

	public void addHallTableListSelectionListener(ListSelectionListener listener) {
		hallTable.getSelectionModel().addListSelectionListener(listener);
	}

	public void addAddListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}

	public void addDeleteListener(ActionListener listener) {
		btnDelete.addActionListener(listener);
	}

	public int getHallTableSelectedRow() {
		return hallTable.getSelectedRow();
	}

	public int[] getBookingTableSelectedRows() {
		return bookingTable.getSelectedRows();
	}
}
