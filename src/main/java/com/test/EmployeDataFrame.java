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
import com.test.db.DbManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeDataFrame extends JFrame {

	private JPanel contentPane;

	DbManager dbManager = new DbManager();
	private JTable empTable;
	DefaultTableModel defaultTableModel= null;
	private JButton backBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeDataFrame frame = new EmployeDataFrame();
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
	public EmployeDataFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		empTable = new JTable();
		empTable.setSurrendersFocusOnKeystroke(true);
		empTable.setFillsViewportHeight(true);
		empTable.setColumnSelectionAllowed(true);
		empTable.setCellSelectionEnabled(true);
		empTable.setBounds(10, 40, 530, 281);
		contentPane.add(empTable);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeDataFrame().setVisible(false);
				ExamMainFrame examMainFrame=new ExamMainFrame();
				examMainFrame.setVisible(true);
			}
		});
		backBtn.setBounds(10, 6, 89, 23);
		contentPane.add(backBtn);
		Object columnNames[] = {"Emp-#","F-Name","L-Name","Email","Ext: ","Job-Title","Office-Code","Reports-To"};
		defaultTableModel = new DefaultTableModel(columnNames, 0);
		fillEmployeeTable();
	}
	
	public void fillEmployeeTable(){
        
        List<Employee> employees = dbManager.getAllEmployees();
        empTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Emp-#", "F-Name", "L-Name", "Email", "Ext: ", "Job-Title", "Office-Code", "Reports-To"
        	}
        ));
        
        for(Employee e : employees) {
                Object rowData[] = {e.getEmployeeNumber(),e.getFirstName(),
                    e.getLastName(),e.getEmail(),e.getExtension(),e.getJobTitle(),e.getOfficeCode(),e.getReportsTo()
            };
            defaultTableModel.addRow(rowData);
            empTable.setModel(defaultTableModel);
        }
    }

}
