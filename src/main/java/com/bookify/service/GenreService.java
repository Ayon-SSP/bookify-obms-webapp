package com.bookify.service;

import java.util.List;

import com.bookify.collection.GenreBookList;
import com.bookify.dao.BookDao;
import com.bookify.dao.GenreDao;
import com.bookify.model.Book;
import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a GenreService class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getGenre, getGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreService {

    public Genre genre;
    private GenreDao genreDao;
    private BookDao bookDao;
    private GenreBookList genreBookList;

    public GenreService() {
        super();
    }

    public GenreService(String genreId) {
        super();
        
        this.genreDao = new GenreDao(DBConnection.getDBConnection());
        this.bookDao = new BookDao(DBConnection.getDBConnection());
        this.genreBookList = new GenreBookList(bookDao);
        
        try {
            this.genre = genreDao.findOne(genreId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Book> getGenreBooks(String genreId) throws Exception {
        return genreBookList.getGenreBooks(genreId);
    }
}