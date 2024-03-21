package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import com.bookify.model.Book;
import com.bookify.util.DBConnection;

/**
 * Represents a DAO for the Book model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @param <Book> the model to be used for CRUD operations.
 *      where Book object contains the object of Author, BookCategory, and Genre.
 * 
 * @throws Exception if any of the CRUD operations fail.
 */

public class BookDao implements IDao<Book> {

    private DBConnection dbConnection;

    private AuthorDao authorDao;
    private BookCategoryDao bookCategoryDao;
    private GenreDao genreDao;
    private List<Book> books = new ArrayList<>();

    public BookDao() {
        super();
    }

    public BookDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
        this.authorDao = new AuthorDao(dbConnection);
        this.bookCategoryDao = new BookCategoryDao(dbConnection);
        this.genreDao = new GenreDao(dbConnection);
    }

    @Override
    public Book create(Book book) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "INSERT INTO tbl_book (book_id, author_id, category_id, book_title, book_description, book_publish_date, book_price, discontinued, book_pages, book_discount, available_quantity, book_language, book_publisher, book_isbn, book_cover_image, genre_ids) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, type_genre_id_list(" + String.join(", ", Collections.nCopies(book.getGenres().size(), "?")) + "))";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, book.getBookId());
        preparedStatement.setString(2, book.getAuthor().getAuthorId());
        preparedStatement.setString(3, book.getCategory().getCategoryId());
        preparedStatement.setString(4, book.getBookTitle());
        preparedStatement.setString(5, book.getBookDescription());
        preparedStatement.setDate(6, Date.valueOf(book.getBookPublishDate()));
        preparedStatement.setDouble(7, book.getBookPrice());
        preparedStatement.setBoolean(8, book.isDiscontinued());
        preparedStatement.setInt(9, book.getBookPages());
        preparedStatement.setDouble(10, book.getBookDiscount());
        preparedStatement.setInt(11, book.getAvailableQuantity());
        preparedStatement.setString(12, book.getBookLanguage());
        preparedStatement.setString(13, book.getBookPublisher());
        preparedStatement.setString(14, book.getBookIsbn());
        preparedStatement.setString(15, book.getBookCoverImage());
        for (int i = 0; i < book.getGenres().size(); i++) {
            preparedStatement.setString(16 + i, book.getGenres().stream().map(genre -> genre.getGenreId()).collect(Collectors.toList()).get(i));
        }

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("BookDao.create() result: " + result + " | " + book.getBookId() + " inserted!");

        return result > 0 ? book : null;
    }

    
    @Override
    public boolean update(String bookId, Book book) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "UPDATE tbl_book SET author_id = ?, category_id = ?, book_title = ?, book_description = ?, book_publish_date = ?, book_price = ?, discontinued = ?, book_pages = ?, book_discount = ?, available_quantity = ?, book_language = ?, book_publisher = ?, book_isbn = ?, book_cover_image = ?, genre_ids = type_genre_id_list(" + String.join(", ", Collections.nCopies(book.getGenres().size(), "?")) + ") WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, book.getAuthor().getAuthorId());
        preparedStatement.setString(2, book.getCategory().getCategoryId());
        preparedStatement.setString(3, book.getBookTitle());
        preparedStatement.setString(4, book.getBookDescription());
        preparedStatement.setDate(5, Date.valueOf(book.getBookPublishDate()));
        preparedStatement.setDouble(6, book.getBookPrice());
        preparedStatement.setBoolean(7, book.isDiscontinued());
        preparedStatement.setInt(8, book.getBookPages());
        preparedStatement.setDouble(9, book.getBookDiscount());
        preparedStatement.setInt(10, book.getAvailableQuantity());
        preparedStatement.setString(11, book.getBookLanguage());
        preparedStatement.setString(12, book.getBookPublisher());
        preparedStatement.setString(13, book.getBookIsbn());
        preparedStatement.setString(14, book.getBookCoverImage());
        for (int i = 0; i < book.getGenres().size(); i++) {
            preparedStatement.setString(15 + i, book.getGenres().stream().map(genre -> genre.getGenreId()).collect(Collectors.toList()).get(i));
        }
        preparedStatement.setString(15 + book.getGenres().size(), bookId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("BookDao.update() result: " + updateResult + " | " + bookId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String bookId) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "DELETE FROM tbl_book WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Book findOne(String bookId) throws Exception {
        Book book = null;
        
        Connection connection = dbConnection.getConnection();
        String sqlQuery = "SELECT * FROM tbl_book WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            book = new Book();

            book.setBookId(resultSet.getString("book_id"));
            book.setAuthor(authorDao.findOne(resultSet.getString("author_id")));
            book.setCategory(bookCategoryDao.findOne(resultSet.getString("category_id")));

            // Set<Genre> genres = new HashSet<>();
            // for (String genreId : (String[]) resultSet.getArray("genre_ids").getArray()) {
            //     genres.add(genreDao.findOne(genreId));
            // }

            
            // book.setGenres(genres);

            try {
                book.setGenres(Arrays.stream((String[]) resultSet.getArray("genre_ids").getArray())
                    .map(genreId -> {
                        try {
                            return genreDao.findOne(genreId);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toSet()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            book.setBookTitle(resultSet.getString("book_title"));
            book.setBookDescription(resultSet.getString("book_description"));
            book.setBookPublishDate(resultSet.getDate("book_publish_date").toString());
            book.setBookPrice(resultSet.getDouble("book_price"));
            book.setDiscontinued(resultSet.getBoolean("discontinued"));
            book.setBookPages(resultSet.getInt("book_pages"));
            book.setBookDiscount(resultSet.getDouble("book_discount"));
            book.setAvailableQuantity(resultSet.getInt("available_quantity"));
            book.setBookLanguage(resultSet.getString("book_language"));
            book.setBookPublisher(resultSet.getString("book_publisher"));
            book.setBookIsbn(resultSet.getString("book_isbn"));
            book.setBookCoverImage(resultSet.getString("book_cover_image"));
        }

        return book;
    }

    @Override
    public List<Book> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_book";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Book book = new Book();

            book.setBookId(resultSet.getString("book_id"));
            book.setAuthor(authorDao.findOne(resultSet.getString("author_id")));
            book.setCategory(bookCategoryDao.findOne(resultSet.getString("category_id")));

            try {
                book.setGenres(Arrays.stream((String[]) resultSet.getArray("genre_ids").getArray())
                    .map(genreId -> {
                        try {
                            return genreDao.findOne(genreId);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toSet()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            book.setBookTitle(resultSet.getString("book_title"));
            book.setBookDescription(resultSet.getString("book_description"));
            book.setBookPublishDate(resultSet.getDate("book_publish_date").toString());
            book.setBookPrice(resultSet.getDouble("book_price"));
            book.setDiscontinued(resultSet.getBoolean("discontinued"));
            book.setBookPages(resultSet.getInt("book_pages"));
            book.setBookDiscount(resultSet.getDouble("book_discount"));
            book.setAvailableQuantity(resultSet.getInt("available_quantity"));
            book.setBookLanguage(resultSet.getString("book_language"));
            book.setBookPublisher(resultSet.getString("book_publisher"));
            book.setBookIsbn(resultSet.getString("book_isbn"));
            book.setBookCoverImage(resultSet.getString("book_cover_image"));

            books.add(book);
        }

        return books.isEmpty() ? null : books;
    }
}
