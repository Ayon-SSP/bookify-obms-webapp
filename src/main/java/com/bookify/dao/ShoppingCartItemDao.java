package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Book;
import com.bookify.model.ShoppingCartItem;
import com.bookify.util.DBConnection;

/*
 * Represents a ShoppingCartItemDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class ShoppingCartItemDao implements IDao<ShoppingCartItem> {

    private DBConnection dbConnection;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public ShoppingCartItemDao() {
        super();
    }

    public ShoppingCartItemDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public ShoppingCartItem create(ShoppingCartItem shoppingCartItem) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_shopping_cart (customer_id, book_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, shoppingCartItem.getCustomerId());
        preparedStatement.setString(2, shoppingCartItem.getBook().getBookId());
        preparedStatement.setInt(3, shoppingCartItem.getQuantity());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("ShoppingCartItemDao.create() result: " + result + " | " + shoppingCartItem.getCustomerId() + " inserted!");

        return result > 0 ? shoppingCartItem : null;
    }

    @Override
    public boolean update(String customerBookId, ShoppingCartItem shoppingCartItem) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_shopping_cart SET quantity = ? WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, shoppingCartItem.getQuantity());
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, bookId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("ShoppingCartItemDao.update() result: " + updateResult + " | " + customerId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerBookId) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_shopping_cart WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, bookId);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("ShoppingCartItemDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }
    
    @Override
    public ShoppingCartItem findOne(String customerBookId) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_shopping_cart WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, bookId);

        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setCustomerId(resultSet.getString("customer_id"));
            shoppingCartItem.setBook(new Book(resultSet.getString("book_id")));
            shoppingCartItem.setQuantity(resultSet.getInt("quantity"));
            return shoppingCartItem;
        }

        return null;
    }

    @Override
    public List<ShoppingCartItem> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_shopping_cart";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setCustomerId(resultSet.getString("customer_id"));
            shoppingCartItem.setBook(new Book(resultSet.getString("book_id")));
            shoppingCartItem.setQuantity(resultSet.getInt("quantity"));
            shoppingCartItems.add(shoppingCartItem);
        }

        return shoppingCartItems.isEmpty() ? null : shoppingCartItems;
    }
}
