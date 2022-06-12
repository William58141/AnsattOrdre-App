package com.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.models.Customer;
import com.test.db.DbManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField customerNumber;
	private JTextField customerName;
	private JTextField contactLastName;
	private JTextField contactFirstName;
	private JTextField phone;
	private JTextField addressLine1;
	private JTextField addressLine2;
	private JTextField city;
	private JTextField state;
	private JTextField postalCode;
	private JTextField country;
	private JTextField salesRepEmployee;
	private JTextField creditLimit;
	private JButton backbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		customerNumber = new JTextField();
		customerNumber.setBounds(146, 21, 115, 20);
		contentPane.add(customerNumber);
		customerNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer Number");
		lblNewLabel.setBounds(10, 24, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setBounds(271, 24, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		customerName = new JTextField();
		customerName.setBounds(384, 21, 154, 20);
		contentPane.add(customerName);
		customerName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact Last Name");
		lblNewLabel_2.setBounds(10, 77, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		contactLastName = new JTextField();
		contactLastName.setBounds(146, 74, 115, 20);
		contentPane.add(contactLastName);
		contactLastName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contact First Name");
		lblNewLabel_3.setBounds(271, 77, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		contactFirstName = new JTextField();
		contactFirstName.setBounds(386, 74, 152, 20);
		contentPane.add(contactFirstName);
		contactFirstName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setBounds(10, 135, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		phone = new JTextField();
		phone.setBounds(146, 132, 115, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address Line1");
		lblNewLabel_5.setBounds(271, 135, 103, 14);
		contentPane.add(lblNewLabel_5);
		
		addressLine1 = new JTextField();
		addressLine1.setBounds(384, 132, 154, 20);
		contentPane.add(addressLine1);
		addressLine1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address Line2");
		lblNewLabel_6.setBounds(10, 181, 126, 14);
		contentPane.add(lblNewLabel_6);
		
		addressLine2 = new JTextField();
		addressLine2.setBounds(146, 178, 115, 20);
		contentPane.add(addressLine2);
		addressLine2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("City");
		lblNewLabel_7.setBounds(271, 181, 103, 14);
		contentPane.add(lblNewLabel_7);
		
		city = new JTextField();
		city.setBounds(384, 178, 154, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setBounds(10, 229, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		state = new JTextField();
		state.setBounds(146, 226, 115, 20);
		contentPane.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Postal Code");
		lblNewLabel_9.setBounds(271, 229, 103, 14);
		contentPane.add(lblNewLabel_9);
		
		postalCode = new JTextField();
		postalCode.setBounds(384, 226, 154, 20);
		contentPane.add(postalCode);
		postalCode.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				Customer customer=new Customer();
				customer.setCustomerNumber(Integer.parseInt(customerNumber.getText()));
				customer.setCustomerName(customerName.getText());
				customer.setContactFirstName(contactFirstName.getText());
				customer.setContactLastName(contactLastName.getText());
				customer.setAddressLine1(addressLine1.getText());
				customer.setAddressLine2(addressLine2.getText());
				customer.setContactFirstName(customer.getContactFirstName());
				customer.setContactLastName(customer.getContactLastName());
				customer.setPhone(phone.getText());
				customer.setCity(city.getText());
				customer.setState(state.getText());
				customer.setPostalCode(postalCode.getText());
				customer.setCountry(country.getText());
				customer.setSalesRepEmployeeNumber(Integer.parseInt(salesRepEmployee.getText()));
				customer.setCreditLimit(Double.parseDouble(creditLimit.getText()));
				DbManager dbManager=new DbManager();
				dbManager.addCustomer(customer);
				System.out.println("Add Successfully");
			}
		});
		btnNewButton.setBounds(225, 360, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Country");
		lblNewLabel_10.setBounds(10, 280, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		country = new JTextField();
		country.setBounds(146, 277, 115, 20);
		contentPane.add(country);
		country.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Sales RepEmployee Number");
		lblNewLabel_11.setBounds(271, 280, 103, 14);
		contentPane.add(lblNewLabel_11);
		
		salesRepEmployee = new JTextField();
		salesRepEmployee.setBounds(384, 277, 154, 20);
		contentPane.add(salesRepEmployee);
		salesRepEmployee.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Credit Limit");
		lblNewLabel_12.setBounds(10, 329, 126, 14);
		contentPane.add(lblNewLabel_12);
		
		creditLimit = new JTextField();
		creditLimit.setBounds(146, 326, 115, 20);
		contentPane.add(creditLimit);
		creditLimit.setColumns(10);
		
		backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCustomer().setVisible(false);
				ExamMainFrame examMainFrame=new ExamMainFrame();
				examMainFrame.setVisible(true);
			}
		});
		backbtn.setBounds(324, 360, 89, 23);
		contentPane.add(backbtn);
	}
}
