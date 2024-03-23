package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Customer;
import com.bookify.util.DBConnection;

/*
 * Represents a CustomerDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerDao implements IDao<Customer> {

    private DBConnection dbConnection;
    private List<Customer> customers = new ArrayList<>();

    public CustomerDao() {
        super();
    }

    public CustomerDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Customer create(Customer customer) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_customer (customer_id, customer_name, customer_email, customer_phone1, password_hash) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customer.getCustomerId());
        preparedStatement.setString(2, customer.getCustomerName());
        preparedStatement.setString(3, customer.getCustomerEmail());
        preparedStatement.setString(4, customer.getCustomerPhone1());
        preparedStatement.setString(5, customer.getCustomerPassword());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("CustomerDao.create() result: " + result + " | " + customer.getCustomerId() + " inserted!");

        return result > 0 ? customer : null;
    }

    @Override
    public boolean update(String customerId, Customer customer) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_customer SET customer_name = ?, customer_email = ?, customer_phone1 = ?, password_hash = ? WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customer.getCustomerName());
        preparedStatement.setString(2, customer.getCustomerEmail());
        preparedStatement.setString(3, customer.getCustomerPhone1());
        preparedStatement.setString(4, customer.getCustomerPassword());
        preparedStatement.setString(5, customerId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("CustomerDao.update() result: " + updateResult + " | " + customerId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerId) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_customer WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("CustomerDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public Customer findOne(String customerId) throws Exception {
        Customer customer = null;

        Connection connection = dbConnection.getConnection();
        String selectQuery = "SELECT * FROM tbl_customer WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            customer = new Customer();
            customer.setCustomerId(resultSet.getString("customer_id"));
            customer.setCustomerName(resultSet.getString("customer_name"));
            customer.setCustomerEmail(resultSet.getString("customer_email"));
            customer.setCustomerPhone1(resultSet.getString("customer_phone1"));
            customer.setCustomerPassword(resultSet.getString("password_hash"));
        }

        return customer;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();

        final String selectQuery = "SELECT * FROM tbl_customer";
        ResultSet resultSet = selectStatement.executeQuery(selectQuery);

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("customer_id"));
            customer.setCustomerName(resultSet.getString("customer_name"));
            customer.setCustomerEmail(resultSet.getString("customer_email"));
            customer.setCustomerPhone1(resultSet.getString("customer_phone1"));
            customer.setCustomerPassword(resultSet.getString("password_hash"));
            customers.add(customer);
        }

        return customers.isEmpty() ? null : customers;
    }
}
