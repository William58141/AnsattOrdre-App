package com.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.models.Employee;
import com.models.Order;
import com.test.db.DbManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListOrderFrame extends JFrame {

	private JPanel contentPane;
	
	DbManager dbManager = new DbManager();
	private JTable orderTable;
	DefaultTableModel defaultTableModel= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOrderFrame frame = new ListOrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListOrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		orderTable = new JTable();
		orderTable.setSurrendersFocusOnKeystroke(true);
		orderTable.setFillsViewportHeight(true);
		orderTable.setColumnSelectionAllowed(true);
		orderTable.setCellSelectionEnabled(true);
		orderTable.setBounds(10, 40, 530, 281);
		contentPane.add(orderTable);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListOrderFrame().setVisible(false);
				ExamMainFrame examMainFrame=new ExamMainFrame();
				examMainFrame.setVisible(true);
			}
		});
		backBtn.setBounds(10, 6, 89, 23);
		contentPane.add(backBtn);
		Object columnNames[] = {"Order-Number", "Order-Date", "Required-Date", "Shipped-Date", "Status ", "Comments"};
		defaultTableModel = new DefaultTableModel(columnNames, 0);
		fillOrderTable();
	}
	
	
	 public void fillOrderTable(){
         
	        List<Order> orders =dbManager.getAllOrders(); 
	        orderTable.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"Order-Number", "Order-Date", "Required-Date", "Shipped-Date", "Status ", "Comments"
	        	}
	        ));
	        
	        for(Order e : orders) {
	                Object rowData[] = {e.getOrderNumber(),e.getOrderDate(),
	                    e.getRequireDate(),e.getShippedDate(),e.getStatus(),e.getComments()
	            };
	            defaultTableModel.addRow(rowData);
	            orderTable.setModel(defaultTableModel);
	        }
	    }

}
