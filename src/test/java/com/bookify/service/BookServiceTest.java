package com.bookify.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Represents a test class for the BookService.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetBook, testGetBookRating, testGetBookReview.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookServiceTest {

    private static BookService bookService;

    @BeforeClass
    public static void BeforeClass() {
        // bookService = new BookService(new BookDao(DBConnection.getDBConnection()), new UserReviewDao(DBConnection.getDBConnection()));
        bookService = new BookService("bo00001", "cu00001");
    }

    @Test
    public void testBook() {
        try {
            System.out.println(bookService.book);
            bookService.book.getUserReviews().stream().forEach(System.out::println);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookRating() {
        try {
            assertTrue(bookService.getBookRating("bo00001") > -1);
            System.out.println(bookService.getBookRating("bo00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerDetails() {
        try {
            assertNotNull(bookService.getCustomerDetails("cu00001"));
            System.out.println(bookService.getCustomerDetails("cu00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
