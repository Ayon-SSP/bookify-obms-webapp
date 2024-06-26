package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the Genre model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */

public class GenreDao implements IDao<Genre> {

    private DBConnection dbConnection;
    private List<Genre> genres = new ArrayList<>();

    private static final String INSERT_GENRES_SQL = "INSERT INTO tbl_genre VALUES (?,?,?,?)";
    private static final String UPDATE_GENRES_SQL = "UPDATE tbl_genre SET genre_name = ?, genre_description = ?, genre_image = ? WHERE genre_id = ?";
    private static final String DELETE_GENRES_SQL = "DELETE FROM tbl_genre WHERE genre_id = ?";
    private static final String SELECT_GENRE_BY_ID = "SELECT * FROM tbl_genre WHERE genre_id = ?";
    private static final String SELECT_ALL_GENRES = "SELECT * FROM tbl_genre";

    public GenreDao() {
        super();
    }

    public GenreDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Genre create(Genre genre) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GENRES_SQL);
        preparedStatement.setString(1, genre.getGenreId());
        preparedStatement.setString(2, genre.getGenreName());
        preparedStatement.setString(3, genre.getGenreDescription());
        preparedStatement.setString(4, genre.getGenreImage());

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("GenreDao.create() result: " + result + " | " + genre.getGenreId() + " inserted!");

        return result > 0 ? genre : null;
    }

    @Override
    public boolean update(String genreId, Genre genre) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GENRES_SQL);
        preparedStatement.setString(1, genre.getGenreName());
        preparedStatement.setString(2, genre.getGenreDescription());
        preparedStatement.setString(3, genre.getGenreImage());
        preparedStatement.setString(4, genreId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("GenreDao.update() result: " + updateResult + " | " + genreId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String genreId) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GENRES_SQL);
        preparedStatement.setString(1, genreId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Genre findOne(String genreId) throws Exception {
        Genre genre = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GENRE_BY_ID);
        preparedStatement.setString(1, genreId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            genre = new Genre(resultSet.getString("genre_id"),
                    resultSet.getString("genre_name"),
                    resultSet.getString("genre_description"), resultSet.getString("genre_image"));
        }

        return genre;
    }

    @Override
    public List<Genre> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_GENRES);

        while (resultSet.next()) {
            Genre genre = new Genre(resultSet.getString("genre_id"),
                    resultSet.getString("genre_name"),
                    resultSet.getString("genre_description"), resultSet.getString("genre_image"));
            genres.add(genre);
        }

        return genres.isEmpty() ? null : genres;
    }
}
