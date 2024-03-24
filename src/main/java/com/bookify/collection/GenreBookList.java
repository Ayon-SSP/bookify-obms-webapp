package com.bookify.collection;

import java.util.List;

import com.bookify.dao.BookDao;
import com.bookify.model.Book;

/*
 * Represents a GenreBookList collection.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreBookList {

    private BookDao bookDao;

    public GenreBookList(BookDao bookDao) {
        super();
        this.bookDao = bookDao;
    }

    public List<Book> getGenreBooks(String genreId) throws Exception {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getGenres().stream().anyMatch(genre -> genre.getGenreId().equals(genreId)))
                .toList();
    }
}