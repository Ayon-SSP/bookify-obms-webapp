package com.bookify.collection;

import java.util.List;

import com.bookify.dao.UserReviewDao;
import com.bookify.model.UserReview;

/*
 * Represents a BookRatingReview collection.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getBookRating, getBookReview.
 * 
 * @methods getBookRating, getBookReview.
 * @throws Exception if any of the CRUD operations fail.
 */

public class BookRatingReviewList {

    private UserReviewDao userReviewDao;

    public BookRatingReviewList(UserReviewDao userReviewDao) {
        super();
        this.userReviewDao = userReviewDao;
    }

    public List<UserReview> getBookReview(String bookId) throws Exception {
        List<UserReview> userReviews = userReviewDao.findAll();
        return userReviews.stream()
                .filter(userReview -> userReview.getBookId().equals(bookId))
                .toList();
    }
}
