package com.bookify;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bookify.collection.AuthorBookList;
import com.bookify.dao.BookDao;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the AuthorBookList.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetAuthorBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorBookListTest {

    private static AuthorBookList authorBookList;

    @BeforeClass
    public static void BeforeClass() {
        authorBookList = new AuthorBookList(new BookDao(DBConnection.getDBConnection()));
    }

    @Test
    public void testGetAuthorBooks() {
        try {
            authorBookList.getAuthorBooks("au00001").stream().forEach(System.out::println);
            assertTrue(authorBookList.getAuthorBooks("au00001").size() > -1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
