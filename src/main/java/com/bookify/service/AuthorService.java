package com.bookify.service;

import java.util.List;

import com.bookify.collection.AuthorBookList;
import com.bookify.dao.AuthorDao;
import com.bookify.dao.BookDao;
import com.bookify.model.Author;
import com.bookify.model.Book;
import com.bookify.util.DBConnection;

/*
 * Represents a AuthorService class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getAuthor, getAuthorBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorService {

    public Author author;
    private AuthorDao authorDao;
    private BookDao bookDao;
    private AuthorBookList authorBookList;

    public AuthorService() {
        super();
    }

    public AuthorService(String authorId) {
        super();
        
        this.authorDao = new AuthorDao(DBConnection.getDBConnection());
        this.bookDao = new BookDao(DBConnection.getDBConnection());
        this.authorBookList = new AuthorBookList(bookDao);
        
        try {
            this.author = authorDao.findOne(authorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Author getAuthor() {
        return author;
    }

    public List<Book> getAuthorBooks(String authorId) throws Exception {
        return authorBookList.getAuthorBooks(authorId);
    }
}
