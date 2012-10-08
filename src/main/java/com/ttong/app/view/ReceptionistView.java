package com.ttong.app.view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import com.ttong.app.model.ReceptionistModel;
import com.ttong.app.objectclass.*;

public class ReceptionistView {
	/*
	 * GUI components
	 */
	private JFrame 			frame;
	private JMenuBar 		menuBar;
	private JMenu  			actionMenu;
	private JMenuItem 	exitMenuItem;
	private JMenuItem 	signOutMenuItem;
	private JTable 			hallTable;
	private JTable 			bookingTable;
	private JPanel 			pnlHallTable;
	private JPanel			pnlBooking;
	private JPanel 			pnlSearch;
	private JScrollPane hallTableScroll;
	private JScrollPane bookingTableScroll;
	private JLabel 			lblSearch;
	private JTextField 	txtSearch;
	private GridBagConstraints c;
	private ReceptionistModel 	receptionistModel;

	public ReceptionistView(ReceptionistModel model) {
		this.receptionistModel = model;
		initUI();

		hallTable.setModel(receptionistModel.getHallTableModel());
		bookingTable.setModel(receptionistModel.getBookingTableModel());
	}	

	/*
	 * Initialise the Admin form.
	 */
	private void initUI() {
		/*
		 * Initialize all required component
		 */
		frame = new JFrame("Hall Management View");
		menuBar = new JMenuBar();
		actionMenu = new JMenu("Action");
		signOutMenuItem = new JMenuItem("Sign Out");
		exitMenuItem 		= new JMenuItem("Exit");
		pnlHallTable = new JPanel();
		pnlBooking = new JPanel();
		pnlSearch = new JPanel();
		hallTable = new JTable();
		bookingTable = new JTable();
		hallTableScroll = new JScrollPane(hallTable);
		bookingTableScroll = new JScrollPane(bookingTable);
		txtSearch = new JTextField(25);
		lblSearch = new JLabel("Customer Name: ");

		/*
		 * Setting up hall table in panel
		 */
		pnlHallTable.setLayout(new BorderLayout());
		pnlHallTable.setBorder(BorderFactory.createTitledBorder("Hall Table"));
		pnlHallTable.add(hallTableScroll, BorderLayout.CENTER);
		hallTable.setRowHeight(40);
		hallTable.setFillsViewportHeight(true);

		/*
		 * Setting up booking table in panel
		 */
		pnlBooking.setLayout(new BorderLayout());
		pnlBooking.setBorder(BorderFactory.createTitledBorder("Booking Table"));
		pnlBooking.add(bookingTableScroll, BorderLayout.CENTER);
		bookingTable.setRowHeight(40);
		bookingTable.setFillsViewportHeight(true);

		/*
		 * Setting up search box in panel
		 */
		pnlSearch.setLayout(new FlowLayout());
		pnlSearch.setBorder(BorderFactory.createTitledBorder("Search"));
		pnlSearch.add(lblSearch);
		pnlSearch.add(txtSearch);

		/*
		 * Setting frame properties
		 * and adding all sub panels into the main content pane
		 */
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 0.1;
		c.weighty = 0.1;
		frame.getContentPane().add(pnlSearch, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 2.0;
		c.weighty = 2.0;
		frame.getContentPane().add(pnlHallTable, c);

		c.gridx = 1;
		c.gridy = 1;
		frame.getContentPane().add(pnlBooking, c);

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

	public void addSignOutListener(ActionListener listener) {
		signOutMenuItem.addActionListener(listener);
	}

	public void addExitListener(ActionListener listener) {
		exitMenuItem.addActionListener(listener);
	}

	public void addSearchListener(KeyListener listener) {
		txtSearch.addKeyListener(listener);
	}

	public void dispose() {
		this.frame.dispose();
	}

	public int[] getHallTableSelectedRows() {
		return hallTable.getSelectedRows();
	}

	public String getSearchText() {
		return txtSearch.getText();
	}
}
