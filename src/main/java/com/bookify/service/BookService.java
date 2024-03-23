package com.bookify.service;

import java.util.ArrayList;
import java.util.List;

import com.bookify.collection.BookRatingReviewList;
import com.bookify.dao.BookDao;
import com.bookify.dao.CustomerDao;
import com.bookify.dao.UserReviewDao;
import com.bookify.model.Book;
import com.bookify.model.Customer;
import com.bookify.model.UserReview;
import com.bookify.util.DBConnection;

/*
 * Represents a BookService class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getBook, getBookRating, getBookReview.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookService {

    public Book book;
    private BookDao bookDao;
    private CustomerDao customerDao;
    private UserReviewDao userReviewDao;
    private BookRatingReviewList bookRatingReviewList;

    public BookService() {
        super();
    }

    public BookService(String bookId, String CustomerId) {
        super();
        
        this.bookDao = new BookDao(DBConnection.getDBConnection());
        this.userReviewDao = new UserReviewDao(DBConnection.getDBConnection());
        this.bookRatingReviewList = new BookRatingReviewList(userReviewDao);
        this.customerDao = new CustomerDao(DBConnection.getDBConnection());
        
        try {
            this.book = bookDao.findOne(bookId);
            this.book.setUserReviews(new ArrayList<>(bookRatingReviewList.getBookReview(bookId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getBookRating(String bookId) throws Exception {
        List<UserReview> userReviews = bookRatingReviewList.getBookReview(bookId);
        return userReviews.stream()
                .mapToDouble(UserReview::getBookRating)
                .average()
                .orElse(0.0);
    }

    public Customer getCustomerDetails(String customerId) throws Exception {
        return customerDao.findOne(customerId);
    }
}
