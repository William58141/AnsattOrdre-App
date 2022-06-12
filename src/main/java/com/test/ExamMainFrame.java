package com.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.models.Customer;
import com.test.db.DbManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ExamMainFrame extends JFrame {

	private JPanel contentPane;
	DbManager dbManager=new DbManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamMainFrame frame = new ExamMainFrame();
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
	public ExamMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addCustomer = new JButton("Add Customer");
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExamMainFrame().setVisible(false);
				AddCustomer addCustomer=new AddCustomer();
				addCustomer.setVisible(true);
			}
		});
		addCustomer.setBounds(10, 11, 117, 40);
		contentPane.add(addCustomer);
		
		JButton listOrderBtn = new JButton("List Orders");
		listOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExamMainFrame().setVisible(false);
				ListOrderFrame listOrderFrame=new ListOrderFrame();
				listOrderFrame.setVisible(true); 
			}
		});
		listOrderBtn.setBounds(137, 11, 110, 40);
		contentPane.add(listOrderBtn);
		
		JButton btnNewButton_2 = new JButton("Retrive All Employee");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExamMainFrame().setVisible(false);
				EmployeDataFrame employeeFrame=new EmployeDataFrame();
				employeeFrame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(271, 11, 137, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Bulk Import From File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("data.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        String[] word=data.split(":");
				        Customer customer=new Customer();
				        customer.setCustomerNumber(Integer.parseInt(word[0]));
				        customer.setCustomerName(word[1]);
				        customer.setContactFirstName(word[2]);
				        customer.setContactLastName(word[3]);
				        customer.setPhone(word[4]);
				        customer.setAddressLine1(word[5]);
				        customer.setAddressLine2(word[6]);
				        customer.setCity(word[7]);
				        customer.setState(word[8]);
				        customer.setPostalCode(word[9]);
				        customer.setCountry(word[10]);
				        customer.setSalesRepEmployeeNumber(Integer.parseInt(word[11]));
				        customer.setCreditLimit(Double.parseDouble(word[12]));
				        
				        dbManager.addCustomer(customer);
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
			}
		});
		btnNewButton.setBounds(10, 101, 154, 40);
		contentPane.add(btnNewButton);
		
		JButton storeResultsToFileBtn = new JButton("Store Results to File");
		storeResultsToFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("data.txt");
				      if (myObj.createNewFile()) {
				        System.out.println("File created: " + myObj.getName());
				      } else {
				        System.out.println("File already exists.");
				      }
				    } catch (IOException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				
				try {
				      FileWriter myWriter = new FileWriter("data.txt");
				      List<Customer> customers=dbManager.getAllCustomers();
				      for(Customer customer:customers) {
				    	  myWriter.write(customer.getCustomerNumber()+":"+customer.getCustomerName()+":"+customer.getContactFirstName()+":"+customer.getContactLastName()+":"
				    			  +customer.getPhone()+":"+customer.getAddressLine1()+":"+customer.getAddressLine2()+":"+customer.getCity()+":"+customer.getState()+":"+customer.getPostalCode()+":"
				    			  +customer.getCountry()+":"+customer.getSalesRepEmployeeNumber()+":"+customer.getCreditLimit());
				    	  myWriter.write("\r\n");
				      }
				      
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				    } catch (IOException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
			}
		});
		storeResultsToFileBtn.setBounds(197, 101, 200, 40);
		contentPane.add(storeResultsToFileBtn);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(141, 200, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
