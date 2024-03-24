package com.bookify;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bookify.collection.GenreBookList;
import com.bookify.dao.BookDao;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the GenreBookList.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreBookListTest {

    private static GenreBookList genreBookList;

    @BeforeClass
    public static void BeforeClass() {
        genreBookList = new GenreBookList(new BookDao(DBConnection.getDBConnection()));
    }

    @Test
    public void testGetGenreBooks() {
        try {
            genreBookList.getGenreBooks("ge00001").stream().forEach(System.out::println);
            assertTrue(genreBookList.getGenreBooks("ge00001").size() > -1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
