package com.bookify.service;

import java.util.ArrayList;
import java.util.List;

import com.bookify.collection.BookRatingReviewList;
import com.bookify.dao.BookDao;
import com.bookify.dao.CustomerDao;
import com.bookify.dao.ShoppingCartItemDao;
import com.bookify.dao.UserReviewDao;
import com.bookify.model.Book;
import com.bookify.model.Customer;
import com.bookify.model.ShoppingCartItem;
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
    public String CurrentCustomerId;
    private BookDao bookDao;
    private CustomerDao customerDao;
    private UserReviewDao userReviewDao;
    private ShoppingCartItemDao shoppingCartItemDao;
    private BookRatingReviewList bookRatingReviewList;

    public BookService() {
        super();
    }

    public BookService(String bookId, String CurrentCustomerId) {
        super();
        
        this.CurrentCustomerId = CurrentCustomerId;
        this.bookDao = new BookDao(DBConnection.getDBConnection());
        this.userReviewDao = new UserReviewDao(DBConnection.getDBConnection());
        this.bookRatingReviewList = new BookRatingReviewList(userReviewDao);
        this.customerDao = new CustomerDao(DBConnection.getDBConnection());
        this.shoppingCartItemDao = new ShoppingCartItemDao(DBConnection.getDBConnection());
        
        try {
            this.book = bookDao.findOne(bookId);
            this.book.setUserReviews(new ArrayList<>(bookRatingReviewList.getBookReview(bookId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getBookRating() throws Exception {
        List<UserReview> userReviews = bookRatingReviewList.getBookReview(this.book.getBookId());
        return userReviews.stream()
                .mapToDouble(UserReview::getBookRating)
                .average()
                .orElse(0.0);
    }

    public Customer getCustomerDetails(String customerId) throws Exception {
        return customerDao.findOne(customerId);
    }

    public ShoppingCartItem addBookToCart(int quantity) throws Exception {
        // if already in cart, update quantity else add new item
        ShoppingCartItem shoppingCartItem = shoppingCartItemDao.findOne(this.CurrentCustomerId + "-" + this.book.getBookId());
        if (shoppingCartItem != null) {
            shoppingCartItem.setQuantity(quantity);
            if (shoppingCartItemDao.update(this.CurrentCustomerId + "-" + this.book.getBookId(), shoppingCartItem))
                return shoppingCartItem;
        }

        return shoppingCartItemDao.create(new ShoppingCartItem(this.CurrentCustomerId, new Book(this.book.getBookId()), quantity));
    }
}
