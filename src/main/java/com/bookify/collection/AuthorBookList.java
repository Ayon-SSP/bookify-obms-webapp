package com.bookify.collection;

import java.util.List;

import com.bookify.dao.BookDao;
import com.bookify.model.Book;

/*
 * Represents a AuthorBookList collection.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getAuthorBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorBookList {

    private BookDao bookDao;

    public AuthorBookList(BookDao bookDao) {
        super();
        this.bookDao = bookDao;
    }

    public List<Book> getAuthorBooks(String authorId) throws Exception {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getAuthor().getAuthorId().equals(authorId))
                .toList();
    }
}
