package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.UserReview;
import com.bookify.util.DBConnection;

/**
 * Represents a DAO for the UserReview model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class UserReviewDao implements IDao<UserReview> {

    private DBConnection dbConnection;
    private List<UserReview> userReviews = new ArrayList<>();

    public UserReviewDao() {
        super();
    }

    public UserReviewDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public UserReview create(UserReview userReview) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "INSERT INTO tbl_user_review VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, userReview.getBook());
        preparedStatement.setString(2, userReview.getCustomer());
        preparedStatement.setDouble(3, userReview.getBookRating());
        preparedStatement.setString(4, userReview.getBookReview());
        preparedStatement.setDate(5, Date.valueOf(userReview.getReviewDate()));

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("UserReviewDao.create() result: " + result + " | " + userReview.getBook() + " inserted!");

        return result > 0 ? userReview : null;
    }

    @Override
    public boolean update(String bookIdCustomerId, UserReview userReview) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "UPDATE tbl_user_review SET customer_id = ?, book_rating = ?, book_review = ?, review_date = ? WHERE book_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, userReview.getCustomer());
        preparedStatement.setDouble(2, userReview.getBookRating());
        preparedStatement.setString(3, userReview.getBookReview());
        preparedStatement.setDate(4, Date.valueOf(userReview.getReviewDate()));
        preparedStatement.setString(5, bookId);
        preparedStatement.setString(6, customerId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("UserReviewDao.update() result: " + updateResult + " | " + bookId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String bookIdCustomerId) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "DELETE FROM tbl_user_review WHERE book_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);
        preparedStatement.setString(2, customerId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public UserReview findOne(String bookIdCustomerId) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        UserReview userReview = null;

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "SELECT * FROM tbl_user_review WHERE book_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);
        preparedStatement.setString(2, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            userReview = new UserReview(resultSet.getString("book_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getDouble("book_rating"),
                    resultSet.getString("book_review"),
                    resultSet.getString("review_date"));
        }

        return userReview;
    }

    @Override
    public List<UserReview> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();

        final String selectQuery = "SELECT * FROM tbl_user_review";
        ResultSet resultSet = selectStatement.executeQuery(selectQuery);

        while (resultSet.next()) {
            UserReview userReview = new UserReview(resultSet.getString("book_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getDouble("book_rating"),
                    resultSet.getString("book_review"),
                    resultSet.getString("review_date"));
            userReviews.add(userReview);
        }

        return userReviews.isEmpty() ? null : userReviews;
    }
}
