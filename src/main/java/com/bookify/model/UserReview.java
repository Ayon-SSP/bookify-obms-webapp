package com.bookify.model;

/**
 * Represents a UserReview model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_user_review")
 * 
 * @methods getBook, setBook, getCustomer, setCustomer, getBookRating, setBookRating, getBookReview, setBookReview, getReviewDate, setReviewDate.
 * @throws Exception if any of the CRUD operations fail.
 */
public class UserReview implements Comparable<UserReview> {
    private String bookId;
    private String customerId;
    private double bookRating;
    private String bookReview;
    private String reviewDate;

    public UserReview() {
        super();
    }

    public UserReview(String bookId, String customerId, double bookRating, String bookReview, String reviewDate) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.bookRating = bookRating;
        this.bookReview = bookReview;
        this.reviewDate = reviewDate;
    }

    public String getBook() {
        return bookId;
    }

    public void setBook(String bookId) {
        this.bookId = bookId;
    }

    public String getCustomer() {
        return customerId;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }

    public double getBookRating() {
        return bookRating;
    }

    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }

    public String getBookReview() {
        return bookReview;
    }

    public void setBookReview(String bookReview) {
        this.bookReview = bookReview;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserReview other = (UserReview) obj;
        if (bookId != other.bookId)
            return false;
        if (customerId != other.customerId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserReview [bookId=" + bookId + ", bookRating=" + bookRating + ", bookReview=" + bookReview + ", customerId=" + customerId
                + ", reviewDate=" + reviewDate + "]";
    }

    @Override
    public int compareTo(UserReview o) {
        return Integer.parseInt(this.bookId.substring(2)) - Integer.parseInt(o.bookId.substring(2));
    }
}