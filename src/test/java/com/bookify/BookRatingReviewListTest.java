package com.bookify;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bookify.collection.BookRatingReviewList;
import com.bookify.dao.UserReviewDao;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the BookRatingReviewList.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetBookRating, testGetBookReview.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookRatingReviewListTest {

    private static BookRatingReviewList bookRatingReviewList;

    @BeforeClass
    public static void BeforeClass() {
        bookRatingReviewList = new BookRatingReviewList(new UserReviewDao(DBConnection.getDBConnection()));
    }

    @Test
    public void testGetBookReview() {
        try {
            bookRatingReviewList.getBookReview("bo00001").stream().forEach(System.out::println);
            assertTrue(bookRatingReviewList.getBookReview("bo00001").size() > -1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
