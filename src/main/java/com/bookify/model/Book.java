package com.bookify.model;

import java.util.ArrayList;
import java.util.Set;

/*
 * Represents a book in the library.
 * @author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_book")
 * 
 * @param bookId The unique identifier for the book. Must match the pattern 'bo[0-9]{5}'. 
 * @param author The Author object representing the author of the book.
 * @param category The BookCategory object representing the category of the book.
 * @param genres The Set of Genre objects representing the genres of the book.
 * @params bookTitle, bookDescription, bookPublishDate, bookPrice, discontinued, bookPages, bookDiscount, availableQuantity, bookLanguage, bookPublisher, bookIsbn.
 * @param bookCoverImage The cover image of the book.
 * @param userReviews The ArrayList of UserReview objects representing the user reviews for the book.
 * @methods get/setBookId, set/getAuthor, set/getCategory, set/getGenres, set/add/removeGenre, get/setBookCoverImage, getUserReviews, setUserReviews, addUserReview, removeUserReview.
 * 
 * @throws IllegalArgumentException if any of the parameters do not meet their respective constraints.
 */
public class Book implements Comparable<Book> {
    private String bookId;
    private Author author;
    private BookCategory category;
    private Set<Genre> genres;
    private String bookTitle;
    private String bookDescription;
    private String bookPublishDate;
    private double bookPrice;
    private boolean discontinued;
    private int bookPages;
    private double bookDiscount;
    private int availableQuantity;
    private String bookLanguage;
    private String bookPublisher;
    private String bookIsbn;
    private String bookCoverImage;

    public Book() {
        super();
    }

    public Book(String bookId, Author author, BookCategory category, Set<Genre> genres, String bookTitle, String bookDescription, String bookPublishDate, double bookPrice, boolean discontinued, int bookPages, double bookDiscount, int availableQuantity, String bookLanguage, String bookPublisher, String bookIsbn, String bookCoverImage) {
        this.bookId = bookId;
        this.author = author;
        this.category = category;
        this.genres = genres;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookPublishDate = bookPublishDate;
        this.bookPrice = bookPrice;
        this.discontinued = discontinued;
        this.bookPages = bookPages;
        this.bookDiscount = bookDiscount;
        this.availableQuantity = availableQuantity;
        this.bookLanguage = bookLanguage;
        this.bookPublisher = bookPublisher;
        this.bookIsbn = bookIsbn;
        this.bookCoverImage = bookCoverImage;
    }

    // you can add list of all userReviews of a book // notGoodPractice?
    ArrayList<UserReview> userReviews = new ArrayList<>();

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(String bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public double getBookDiscount() {
        return bookDiscount;
    }

    public void setBookDiscount(double bookDiscount) {
        this.bookDiscount = bookDiscount;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookCoverImage() {
        return bookCoverImage;
    }

    public void setBookCoverImage(String bookCoverImage) {
        this.bookCoverImage = bookCoverImage;
    }

    public ArrayList<UserReview> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(ArrayList<UserReview> userReviews) {
        this.userReviews = userReviews;
    }

    public void addUserReview(UserReview userReview) {
        this.userReviews.add(userReview);
    }

    public void removeUserReview(UserReview userReview) {
        this.userReviews.remove(userReview);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
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
        Book other = (Book) obj;
        if (bookId != other.bookId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", availableQuantity=" + availableQuantity + ", bookCoverImage=" + bookCoverImage
                + ", bookDescription=" + bookDescription + ", bookDiscount=" + bookDiscount + ", bookId=" + bookId
                + ", bookIsbn=" + bookIsbn + ", bookLanguage=" + bookLanguage + ", bookPages=" + bookPages
                + ", bookPrice=" + bookPrice + ", bookPublishDate=" + bookPublishDate + ", bookPublisher=" + bookPublisher
                + ", bookTitle=" + bookTitle + ", category=" + category + ", discontinued=" + discontinued + ", genres=" + genres
                + "]";
    }

    @Override
    public int compareTo(Book o) {
        return Integer.parseInt(this.bookId.substring(2)) - Integer.parseInt(o.bookId.substring(2));
    }
}

/*
 * 
 * @Object book1, author1, genre1, genre2, category1, userReview1, userReview2
 * 
 * book1.author1.<all author data>/<all category data>/genres.<all genre data>/<all book data>/userReviews.<all userReview data>.
 */
