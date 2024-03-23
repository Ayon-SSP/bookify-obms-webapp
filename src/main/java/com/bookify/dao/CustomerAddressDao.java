package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.CustomerAddress;
import com.bookify.util.DBConnection;

/*
 * Represents a CustomerAddressDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerAddressDao implements IDao<CustomerAddress> {

    private DBConnection dbConnection;
    private List<CustomerAddress> customerAddresses = new ArrayList<>();

    public CustomerAddressDao() {
        super();
    }

    public CustomerAddressDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public CustomerAddress create(CustomerAddress customerAddress) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_customer_address (customer_address_id, address_type, customer_id, address_line1, address_line2, address_line3, city, state, country, postalcode, landmark, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerAddress.getCustomerAddressId());
        preparedStatement.setString(2, customerAddress.getAddressType());
        preparedStatement.setString(3, customerAddress.getCustomerId());
        preparedStatement.setString(4, customerAddress.getAddressLine1());
        preparedStatement.setString(5, customerAddress.getAddressLine2());
        preparedStatement.setString(6, customerAddress.getAddressLine3());
        preparedStatement.setString(7, customerAddress.getCity());
        preparedStatement.setString(8, customerAddress.getState());
        preparedStatement.setString(9, customerAddress.getCountry());
        preparedStatement.setString(10, customerAddress.getPostalCode());
        preparedStatement.setString(11, customerAddress.getLandmark());
        preparedStatement.setString(12, customerAddress.getPhone());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("CustomerAddressDao.create() result: " + result + " | " + customerAddress.getCustomerAddressId() + " inserted!");

        return result > 0 ? customerAddress : null;
    }

    @Override
    public boolean update(String customerAddressTypeId, CustomerAddress customerAddress) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_customer_address SET address_line1 = ?, address_line2 = ?, address_line3 = ?, city = ?, state = ?, country = ?, postalcode = ?, landmark = ?, phone = ? WHERE customer_id = ? AND address_type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerAddress.getAddressLine1());
        preparedStatement.setString(2, customerAddress.getAddressLine2());
        preparedStatement.setString(3, customerAddress.getAddressLine3());
        preparedStatement.setString(4, customerAddress.getCity());
        preparedStatement.setString(5, customerAddress.getState());
        preparedStatement.setString(6, customerAddress.getCountry());
        preparedStatement.setString(7, customerAddress.getPostalCode());
        preparedStatement.setString(8, customerAddress.getLandmark());
        preparedStatement.setString(9, customerAddress.getPhone());
        preparedStatement.setString(10, customerId);
        preparedStatement.setString(11, addressType);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("CustomerAddressDao.update() result: " + updateResult + " | " + customerId + addressType + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerAddressTypeId) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_customer_address WHERE customer_id = ? AND address_type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, addressType);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("CustomerAddressDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public CustomerAddress findOne(String customerAddressTypeId) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_customer_address WHERE customer_id = ? AND address_type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, addressType);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setCustomerAddressId(resultSet.getString("customer_address_id"));
            customerAddress.setAddressType(resultSet.getString("address_type"));
            customerAddress.setCustomerId(resultSet.getString("customer_id"));
            customerAddress.setAddressLine1(resultSet.getString("address_line1"));
            customerAddress.setAddressLine2(resultSet.getString("address_line2"));
            customerAddress.setAddressLine3(resultSet.getString("address_line3"));
            customerAddress.setCity(resultSet.getString("city"));
            customerAddress.setState(resultSet.getString("state"));
            customerAddress.setCountry(resultSet.getString("country"));
            customerAddress.setPostalCode(resultSet.getString("postalcode"));
            customerAddress.setLandmark(resultSet.getString("landmark"));
            customerAddress.setPhone(resultSet.getString("phone"));
            return customerAddress;
        }

        return null;
    }

    @Override
    public List<CustomerAddress> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_customer_address";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setCustomerAddressId(resultSet.getString("customer_address_id"));
            customerAddress.setAddressType(resultSet.getString("address_type"));
            customerAddress.setCustomerId(resultSet.getString("customer_id"));
            customerAddress.setAddressLine1(resultSet.getString("address_line1"));
            customerAddress.setAddressLine2(resultSet.getString("address_line2"));
            customerAddress.setAddressLine3(resultSet.getString("address_line3"));
            customerAddress.setCity(resultSet.getString("city"));
            customerAddress.setState(resultSet.getString("state"));
            customerAddress.setCountry(resultSet.getString("country"));
            customerAddress.setPostalCode(resultSet.getString("postalcode"));
            customerAddress.setLandmark(resultSet.getString("landmark"));
            customerAddress.setPhone(resultSet.getString("phone"));
            customerAddresses.add(customerAddress);
        }

        return customerAddresses.isEmpty() ? null : customerAddresses;
    }    
}
