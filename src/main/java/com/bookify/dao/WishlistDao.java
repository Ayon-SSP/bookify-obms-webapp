package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Book;
import com.bookify.model.Wishlist;
import com.bookify.util.DBConnection;

/*
 * Represents a WishlistDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class WishlistDao implements IDao<Wishlist> {

    private DBConnection dbConnection;
    private List<Wishlist> wishlists = new ArrayList<>();

    public WishlistDao() {
        super();
    }

    public WishlistDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Wishlist create(Wishlist wishlist) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_wishlist (customer_wishlist_id, customer_id, wishlist_name, wishlist_description, wishlist_image) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlist.getCustomerWishlistId());
        preparedStatement.setString(2, wishlist.getCustomerId());
        preparedStatement.setString(3, wishlist.getWishlistName());
        preparedStatement.setString(4, wishlist.getWishlistDescription());
        preparedStatement.setString(5, wishlist.getWishlistImage());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.create() result: " + result + " | " + wishlist.getCustomerWishlistId() + " inserted!");

        return result > 0 ? wishlist : null;
    }

    @Override
    public boolean update(String customerWishlistId, Wishlist wishlist) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_wishlist SET customer_id = ?, wishlist_name = ?, wishlist_description = ?, wishlist_image = ? WHERE customer_wishlist_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlist.getCustomerId());
        preparedStatement.setString(2, wishlist.getWishlistName());
        preparedStatement.setString(3, wishlist.getWishlistDescription());
        preparedStatement.setString(4, wishlist.getWishlistImage());
        preparedStatement.setString(5, customerWishlistId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("WishlistDao.update() result: " + updateResult + " | " + customerWishlistId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);

        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("WishlistDao.delete() result: " + deleteResult + " | " + customerWishlistId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public Wishlist findOne(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setCustomerWishlistId(resultSet.getString("customer_wishlist_id"));
            wishlist.setCustomerId(resultSet.getString("customer_id"));
            wishlist.setWishlistName(resultSet.getString("wishlist_name"));
            wishlist.setWishlistDescription(resultSet.getString("wishlist_description"));
            wishlist.setWishlistImage(resultSet.getString("wishlist_image"));
            return wishlist;
        }

        return null;
    }

    @Override
    public List<Wishlist> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setCustomerWishlistId(resultSet.getString("customer_wishlist_id"));
            wishlist.setCustomerId(resultSet.getString("customer_id"));
            wishlist.setWishlistName(resultSet.getString("wishlist_name"));
            wishlist.setWishlistDescription(resultSet.getString("wishlist_description"));
            wishlist.setWishlistImage(resultSet.getString("wishlist_image"));
            wishlists.add(wishlist);
        }

        return wishlists.isEmpty() ? null : wishlists;
    }

    public boolean addBookToWishlist(String customerWishlistId, Book book) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_wishlist_item (customer_wishlist_id, customer_id, book_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, book.getBookId());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.addBookToWishlist() result: " + result + " | " + customerWishlistId + " inserted!");
        
        return result > 0;
    }
    
    public boolean removeBookFromWishlist(String customerWishlistId, Book book) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, book.getBookId());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.removeBookFromWishlist() result: " + result + " | " + customerWishlistId + " deleted!");

        return result > 0;
    }
    
    public List<Book> getWishlistItems(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setBookId(resultSet.getString("book_id"));
            books.add(book);
        }
        
        return books.isEmpty() ? null : books;
    }

    public boolean clearWishlist(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.clearWishlist() result: " + result + " | " + customerWishlistId + " cleared!");
        
        return result > 0;
    }
}
