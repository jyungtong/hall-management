package com.ttong.app.view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import com.ttong.app.model.AdminModel;
import com.ttong.app.objectclass.*;

public class AdminView {
	/*
	 * GUI components
	 */
	private JFrame 			frame;
	private JMenuBar 		menuBar;
	private JMenu  			actionMenu;
	private JMenuItem 	exitMenuItem;
	private JMenuItem 	signOutMenuItem;
	private JTable 			hallTable;
	private JPanel 			pnlHallTable;
	private JPanel 			pnlOptions;
	private JButton 		btnAdd;
	private JButton 		btnDelete;
	private JScrollPane hallTableScroll;
	private AdminModel 	adminModel;
	private GridBagConstraints c;

	public AdminView(AdminModel model) {
		this.adminModel = model;
		initUI();

		hallTable.setModel(adminModel.getHallTableModel());
		hallTable.getColumnModel().getColumn(2).setCellEditor(new HallTypeComboboxCellEditor());
		hallTable.getColumnModel().getColumn(3).setCellEditor(new HallTypeComboboxCellEditor());
		hallTable.getColumnModel().getColumn(4).setCellEditor(new HallDimensionCellEditor(frame));
		hallTable.getColumnModel().getColumn(8).setCellEditor(new FacilitiesCellEditor(frame));

		/*
		 *for(int i = 0; i < adminModel.getHallTableModel().getColumnCount();
		 *      i++) {
		 *  hallTable.getColumnModel().getColumn(i).setCellRenderer(
		 *      new BookingExistCellRenderer(adminModel.getHallTableModel())
		 *      );
		 *}
		 */
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
		pnlOptions = new JPanel();
		hallTable = new JTable();
		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		hallTableScroll = new JScrollPane(hallTable);

		/*
		 * Setting up hall table in panel
		 */
		pnlHallTable.setLayout(new BorderLayout());
		pnlHallTable.setBorder(BorderFactory.createTitledBorder("Hall Table"));
		pnlHallTable.add(hallTableScroll, BorderLayout.CENTER);
		hallTable.setRowHeight(40);
		hallTable.setFillsViewportHeight(true);

		/*
		 * Setting up options available in panel
		 */
		pnlOptions.setLayout(new FlowLayout());
		pnlOptions.setBorder(BorderFactory.createTitledBorder("Options"));
		pnlOptions.add(btnAdd);
		pnlOptions.add(btnDelete);
		
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
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 2.0;
		c.weighty = 2.0;
		frame.getContentPane().add(pnlHallTable, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 0.5;
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

	public void addAddListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}

	public void addDeleteListener(ActionListener listener) {
		btnDelete.addActionListener(listener);
	}

	public void addSignOutListener(ActionListener listener) {
		signOutMenuItem.addActionListener(listener);
	}

	public void addExitListener(ActionListener listener) {
		exitMenuItem.addActionListener(listener);
	}

	public void dispose() {
		this.frame.dispose();
	}

	public int[] getHallTableSelectedRows() {
		return hallTable.getSelectedRows();
	}
}
