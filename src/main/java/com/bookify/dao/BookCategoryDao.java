package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.BookCategory;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the BookCategory model.
 * 
 * @author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookCategoryDao implements IDao<BookCategory> {

    private DBConnection dbConnection;
    private List<BookCategory> bookCategories = new ArrayList<>();

    private static final String INSERT_BOOKCATEGORYS_SQL = "INSERT INTO tbl_book_category VALUES (?,?,?,?)";
    private static final String UPDATE_BOOKCATEGORYS_SQL = "UPDATE tbl_book_category SET category_name = ?, category_description = ?, category_image = ? WHERE category_id = ?";
    private static final String DELETE_BOOKCATEGORYS_SQL = "DELETE FROM tbl_book_category WHERE category_id = ?";
    private static final String SELECT_BOOKCATEGORY_BY_ID = "SELECT * FROM tbl_book_category WHERE category_id = ?";
    private static final String SELECT_ALL_BOOKCATEGORYS = "SELECT * FROM tbl_book_category";

    public BookCategoryDao() {
        super();
    }

    public BookCategoryDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public BookCategory create(BookCategory bookCategory) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, bookCategory.getCategoryId());
        preparedStatement.setString(2, bookCategory.getCategoryName());
        preparedStatement.setString(3, bookCategory.getCategoryDescription());
        preparedStatement.setString(4, bookCategory.getCategoryImage());

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("BookCategoryDao.create() result: " + result + " | " + bookCategory.getCategoryId() + " inserted!");

        return result > 0 ? bookCategory : null;
    }

    @Override
    public boolean update(String categoryId, BookCategory bookCategory) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, bookCategory.getCategoryName());
        preparedStatement.setString(2, bookCategory.getCategoryDescription());
        preparedStatement.setString(3, bookCategory.getCategoryImage());
        preparedStatement.setString(4, categoryId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("BookCategoryDao.update() result: " + updateResult + " | " + bookCategory.getCategoryId() + " updated!");
        
        return updateResult > 0;
    }

    @Override
    public boolean delete(String categoryId) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, categoryId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public BookCategory findOne(String categoryId) throws Exception {
        BookCategory bookCategory = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKCATEGORY_BY_ID);
        preparedStatement.setString(1, categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            bookCategory = new BookCategory(resultSet.getString("category_id"),
                    resultSet.getString("category_name"),
                    resultSet.getString("category_description"), resultSet.getString("category_image"));
        }

        return bookCategory;
    }

    @Override
    public List<BookCategory> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_BOOKCATEGORYS);

        while (resultSet.next()) {
            BookCategory bookCategory = new BookCategory(resultSet.getString("category_id"),
                    resultSet.getString("category_name"),
                    resultSet.getString("category_description"), resultSet.getString("category_image"));
            bookCategories.add(bookCategory);
        }

        return bookCategories.isEmpty() ? null : bookCategories;
    }
}
