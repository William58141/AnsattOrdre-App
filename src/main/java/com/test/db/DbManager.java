package com.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Customer;
import com.models.Employee;
import com.models.Order;
public class DbManager {

	Connection con = DbConnection.getConnection();
	
	public List<Employee> getAllEmployees() {
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery("select * from employees");
            while (resultSet.next()) {
            	Employee e = new Employee();
            	
            	e.setEmployeeNumber(resultSet.getInt("employeeNumber"));
                e.setFirstName(resultSet.getString("firstName"));
                e.setLastName(resultSet.getString("lastName"));
                e.setEmail(resultSet.getString("email"));
                e.setExtension(resultSet.getString("extension"));
                e.setOfficeCode(resultSet.getString("officeCode"));
                e.setJobTitle(resultSet.getString("jobTitle"));
                e.setReportsTo(resultSet.getInt("reportsTo"));
                
                employees.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }
	
	public void addCustomer(Customer customer) {
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO customers(`customerNumber`,`customerName`,`contactLastName`,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit) "
            		+ "VALUE ('"+customer.getCustomerNumber()+"', '"+customer.getCustomerName()+
            		"', '"+customer.getContactLastName()+"','"+customer.getContactFirstName()+"','"+
            		customer.getPhone()+"','"+customer.getAddressLine1()+"','"+customer.getAddressLine2()+"','"+customer.getCity()+"','"+
            		customer.getState()+"','"+customer.getPostalCode()+"','"+customer.getCountry()+"','"+customer.getSalesRepEmployeeNumber()+"','"+
            		customer.getCreditLimit()+"')";
            System.out.println(sql);
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //stmt.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	public List<Order> getAllOrders() {
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery("select * from orders");
            while (resultSet.next()) {
            	Order e = new Order();
            	
            	e.setOrderNumber(resultSet.getInt("orderNumber"));
                e.setOrderDate(resultSet.getDate("orderDate"));
                e.setRequireDate(resultSet.getDate("requiredDate"));
                e.setShippedDate(resultSet.getDate("shippedDate"));
                e.setStatus(resultSet.getString("status"));
                e.setComments(resultSet.getString("comments"));
               
                orders.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }
	public List<Customer> getAllCustomers() {
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery("select * from customers");
            while (resultSet.next()) {
            	Customer e = new Customer();
            	
            	e.setCustomerNumber(resultSet.getInt("customerNumber"));
                e.setCustomerName(resultSet.getString("customerName"));
                e.setContactFirstName(resultSet.getString("contactLastName"));
                e.setContactLastName(resultSet.getString("contactFirstName"));
                e.setPhone(resultSet.getString("phone"));
                e.setAddressLine1(resultSet.getString("addressLine1"));
                e.setAddressLine2(resultSet.getString("addressLine2"));
                e.setCity(resultSet.getString("city"));
                e.setState(resultSet.getString("state"));
                e.setPostalCode(resultSet.getString("postalCode"));
                e.setCountry(resultSet.getString("country"));
                e.setSalesRepEmployeeNumber(resultSet.getInt("salesRepEmployeeNumber"));
                e.setCreditLimit(resultSet.getDouble("creditLimit"));
                
                customers.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customers;
    }
}
