package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Author;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the Author model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorDao implements IDao<Author> {

    private DBConnection dbConnection;
    private List<Author> authors = new ArrayList<>();

    private static final String INSERT_AUTHORS_SQL = "INSERT INTO tbl_author VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_AUTHORS_SQL = "UPDATE tbl_author SET author_name = ?, author_bio = ?, author_score = ?, author_image = ?, author_birth_date = ? WHERE author_id = ?";
    private static final String DELETE_AUTHORS_SQL = "DELETE FROM tbl_author WHERE author_id = ?";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM tbl_author WHERE author_id = ?";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM tbl_author";

    public AuthorDao() {
        super();
    }

    public AuthorDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Author create(Author author) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHORS_SQL);
        preparedStatement.setString(1, author.getAuthorId());
        preparedStatement.setString(2, author.getAuthorName());
        preparedStatement.setString(3, author.getAuthorBio());
        preparedStatement.setDouble(4, author.getAuthorScore());
        preparedStatement.setString(5, author.getAuthorImage());
        preparedStatement.setDate(6, Date.valueOf(author.getAuthorBirthDate()));

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("AuthorDao.create() result: " + result + " | " + author.getAuthorId() + " inserted!");

        return result > 0 ? author : null;
    }

    @Override
    public boolean update(String authorId, Author author) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTHORS_SQL);
        preparedStatement.setString(1, author.getAuthorName());
        preparedStatement.setString(2, author.getAuthorBio());
        preparedStatement.setDouble(3, author.getAuthorScore());
        preparedStatement.setString(4, author.getAuthorImage());
        preparedStatement.setDate(5, Date.valueOf(author.getAuthorBirthDate()));
        preparedStatement.setString(6, authorId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("AuthorDao.update() result: " + updateResult + " | " + authorId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String authorId) throws Exception {
        
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHORS_SQL);
        preparedStatement.setString(1, authorId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Author findOne(String authorId) throws Exception {
        Author author = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID);
        preparedStatement.setString(1, authorId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            author = new Author(resultSet.getString("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_bio"), resultSet.getDouble("author_score"),
                    resultSet.getString("author_image"), resultSet.getString("author_birth_date"));
        }

        return author;
    }

    @Override
    public List<Author> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_AUTHORS);

        while (resultSet.next()) {
            Author author = new Author(resultSet.getString("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_bio"), resultSet.getDouble("author_score"),
                    resultSet.getString("author_image"), resultSet.getString("author_birth_date"));
            authors.add(author);
        }

        return authors.isEmpty() ? null : authors;
    }
}
