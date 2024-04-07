
Topices to use in the porject:
1. lambda expression
2. Stream
3. interface, inheritance & abstract class if needed
4. use HAS-A relationship
5. exception handling must
6. JDBC
7. Servlet
8. JSP
9. JSTL
10. 


## create all java packages:
> path: src/main/java/com/bookify
com.bookify.model
com.bookify.dao
com.bookify.service
com.bookify.controller
com.bookify.util
com.bookify.demo


# 🧑‍🏭 Work: model package:
**package com.bookify.model**
> Thease are all the classes 
  1.  Author.java
  2.  Genre.java
  3.  BookCategory.java
  4.  Book.java     [M]
  5.  Wishlist.java
  6.  Subscription.java
  7.  SubscriptionLogHistory.java
  8.  UserReview.java
  9.  CustomerAddress.java
  10. Customer.java [M]
  11. OrderDetail.java
  12. Orders.java   [M]

### 🏛️ Model Classes
- tbl_book-> Book.java
  - BookCategory.java
  - Genre.java
  - Author.java
- tbl_customer -> Customer.java
  - CustomerAddress.java
  - ShoppingCart -> CartItem.java
  - Wishlist.java List<Books>
  - SubscriptionLogHistory.java
    - Subscription.java
- tbl_order-> Orders.java
  - OrderDetail.java

### Model Classes
#### model1. Author 
```java
package com.bookify.model;

/*  
 * Represents an author of books.
 * @author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_author")
 * 
 * @param authorId The ID to set. Must match the pattern 'au[0-9]{5}'.
 * @params authorName, authorBio, authorScore, authorImage, authorBirthDate.
 * @throws IllegalArgumentException if the provided author ID is null or does not match the expected pattern.
 */
public class Author implements Comparable<Author> {
    private String authorId;
    private String authorName;
    private String authorBio;
    private double authorScore;
    private String authorImage;
    private String authorBirthDate;

    public Author() {
        super();
    }

    public Author(String authorId, String authorName, String authorBio, double authorScore, String authorImage, String authorBirthDate) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorBio = authorBio;
        this.authorScore = authorScore;
        this.authorImage = authorImage;
        this.authorBirthDate = authorBirthDate;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public double getAuthorScore() {
        return authorScore;
    }

    public void setAuthorScore(double authorScore) {
        this.authorScore = authorScore;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorBirthDate() {
        return authorBirthDate;
    }

    public void setAuthorBirthDate(String authorBirthDate) {
        this.authorBirthDate = authorBirthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
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
        Author other = (Author) obj;
        if (authorId != other.authorId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorBio=" + authorBio + ", authorScore="
                + authorScore + ", authorImage=" + authorImage + ", authorBirthDate=" + authorBirthDate + "]";
    }

    @Override
    public int compareTo(Author o) {
        return Integer.parseInt(this.authorId.substring(2)) - Integer.parseInt(o.authorId.substring(2));
    }
}

```
#### model2. Genre 
```java
package com.bookify.model;

/*  
 * Represents a genre of books.
 * @author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_genre")
 * 
 * @param genreId The ID to set. Must match the pattern 'ge[0-9]{5}'.
 * @params genreName, genreDescription, genreImage.
 */
public class Genre implements Comparable<Genre> {
    private String genreId;
    private String genreName;
    private String genreDescription;
    private String genreImage;

    public Genre() {
        super();
    }

    public Genre(String genreId, String genreName, String genreDescription, String genreImage) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
        this.genreImage = genreImage;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    public String getGenreImage() {
        return genreImage;
    }

    public void setGenreImage(String genreImage) {
        this.genreImage = genreImage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
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
        Genre other = (Genre) obj;
        if (genreId != other.genreId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", genreDescription=" + genreDescription
                + ", genreImage=" + genreImage + "]";
    }

    @Override
    public int compareTo(Genre o) {
        return Integer.parseInt(this.genreId.substring(2)) - Integer.parseInt(o.genreId.substring(2));
    }
}

```
#### model3. BookCategory 
```java
package com.bookify.model;

/*  
 * Represents a category of books.
 * @Author: Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_book_category")
 * 
 * @param categoryId The ID to set. Must match the pattern 'bc[0-9]{5}'.
 * @throws IllegalArgumentException if the provided category ID is null or does not match the expected pattern.
 */
public class BookCategory implements Comparable<BookCategory> {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImage;

    public BookCategory() {
        super();
    }

    // TODO: Implement auto-generation of categoryId with the format "bc00001" and "bc00002"
    // private static int counter = 1;

    // public static String generateCategoryId() {
    //     String categoryId = "bc" + String.format("%05d", counter);
    //     counter++;
    //     return categoryId;
    // }
    public BookCategory(String categoryId, String categoryName, String categoryDescription, String categoryImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
        BookCategory other = (BookCategory) obj;
        if (categoryId != other.categoryId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BookCategory [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + ", categoryImage="
                + categoryImage + ", categoryName=" + categoryName + "]";
    }

    @Override
    public int compareTo(BookCategory o) {
        return Integer.parseInt(this.categoryId.substring(2)) - Integer.parseInt(o.categoryId.substring(2));
    }
}

```

#### model4. Book 
```java
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

    public Book(String bookId) {
        this.bookId = bookId;
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
```
#### dao1. IDao<T>
```java
package com.bookify.dao;

import java.util.List;

/*
 * Represents a generic DAO interface.
 * 
 * @author @Ayon-SSP
 * 
 * @param <T> The type of the object to be persisted.
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public interface IDao<T> {
    T create(T t) throws Exception;
    boolean update(String id, T t) throws Exception;
    boolean delete(String id) throws Exception;
    T findOne(String id) throws Exception;
    List<T> findAll() throws Exception;
}
```

#### dao2. BookCategoryDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.BookCategory;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the BookCategory model.
 * 
 * @author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookCategoryDao implements IDao<BookCategory> {

    private DBConnection dbConnection;
    private List<BookCategory> bookCategories = new ArrayList<>();

    private static final String INSERT_BOOKCATEGORYS_SQL = "INSERT INTO tbl_book_category VALUES (?,?,?,?)";
    private static final String UPDATE_BOOKCATEGORYS_SQL = "UPDATE tbl_book_category SET category_name = ?, category_description = ?, category_image = ? WHERE category_id = ?";
    private static final String DELETE_BOOKCATEGORYS_SQL = "DELETE FROM tbl_book_category WHERE category_id = ?";
    private static final String SELECT_BOOKCATEGORY_BY_ID = "SELECT * FROM tbl_book_category WHERE category_id = ?";
    private static final String SELECT_ALL_BOOKCATEGORYS = "SELECT * FROM tbl_book_category";

    public BookCategoryDao() {
        super();
    }

    public BookCategoryDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public BookCategory create(BookCategory bookCategory) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, bookCategory.getCategoryId());
        preparedStatement.setString(2, bookCategory.getCategoryName());
        preparedStatement.setString(3, bookCategory.getCategoryDescription());
        preparedStatement.setString(4, bookCategory.getCategoryImage());

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("BookCategoryDao.create() result: " + result + " | " + bookCategory.getCategoryId() + " inserted!");

        return result > 0 ? bookCategory : null;
    }

    @Override
    public boolean update(String categoryId, BookCategory bookCategory) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, bookCategory.getCategoryName());
        preparedStatement.setString(2, bookCategory.getCategoryDescription());
        preparedStatement.setString(3, bookCategory.getCategoryImage());
        preparedStatement.setString(4, categoryId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("BookCategoryDao.update() result: " + updateResult + " | " + bookCategory.getCategoryId() + " updated!");
        
        return updateResult > 0;
    }

    @Override
    public boolean delete(String categoryId) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKCATEGORYS_SQL);
        preparedStatement.setString(1, categoryId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public BookCategory findOne(String categoryId) throws Exception {
        BookCategory bookCategory = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKCATEGORY_BY_ID);
        preparedStatement.setString(1, categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            bookCategory = new BookCategory(resultSet.getString("category_id"),
                    resultSet.getString("category_name"),
                    resultSet.getString("category_description"), resultSet.getString("category_image"));
        }

        return bookCategory;
    }

    @Override
    public List<BookCategory> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_BOOKCATEGORYS);

        while (resultSet.next()) {
            BookCategory bookCategory = new BookCategory(resultSet.getString("category_id"),
                    resultSet.getString("category_name"),
                    resultSet.getString("category_description"), resultSet.getString("category_image"));
            bookCategories.add(bookCategory);
        }

        return bookCategories.isEmpty() ? null : bookCategories;
    }
}   
```
test2. BookCategoryDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.BookCategoryDao;
import com.bookify.model.BookCategory;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the BookCategoryDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateBookCategoryDao, testUpdateBookCategoryDao, testFindOneBookCategoryDao, testDeleteBookCategoryDao, testFindAllBookCategoryDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class BookCategoryDaoTest {

    private static BookCategoryDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new BookCategoryDao(DBConnection.getDBConnection());
    }

    @Test
	public void testCreateUserDao() {
		try {
			assertNotNull(dao.create(new BookCategory("bc91002","baby's Book","Book for small childrens","science.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Test
    public void testUpdateBookCategoryDao() {
        try {
            assertTrue(dao.update("bc91002",new BookCategory("bc91002","Childrens's Book","Book for small childrens","science.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteBookCategoryDao() {
        try {
            assertTrue(dao.delete("bc90002"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testFindOneBookCategoryDao() {
    
        try {
            assertNotNull(dao.findOne("bc91002"));
            System.out.println(dao.findOne("bc91002"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllBookCategoryDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}

```

#### dao3. AuthorDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Author;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the Author model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorDao implements IDao<Author> {

    private DBConnection dbConnection;
    private List<Author> authors = new ArrayList<>();

    private static final String INSERT_AUTHORS_SQL = "INSERT INTO tbl_author VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_AUTHORS_SQL = "UPDATE tbl_author SET author_name = ?, author_bio = ?, author_score = ?, author_image = ?, author_birth_date = ? WHERE author_id = ?";
    private static final String DELETE_AUTHORS_SQL = "DELETE FROM tbl_author WHERE author_id = ?";
    private static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM tbl_author WHERE author_id = ?";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM tbl_author";

    public AuthorDao() {
        super();
    }

    public AuthorDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Author create(Author author) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHORS_SQL);
        preparedStatement.setString(1, author.getAuthorId());
        preparedStatement.setString(2, author.getAuthorName());
        preparedStatement.setString(3, author.getAuthorBio());
        preparedStatement.setDouble(4, author.getAuthorScore());
        preparedStatement.setString(5, author.getAuthorImage());
        preparedStatement.setDate(6, Date.valueOf(author.getAuthorBirthDate()));

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("AuthorDao.create() result: " + result + " | " + author.getAuthorId() + " inserted!");

        return result > 0 ? author : null;
    }

    @Override
    public boolean update(String authorId, Author author) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTHORS_SQL);
        preparedStatement.setString(1, author.getAuthorName());
        preparedStatement.setString(2, author.getAuthorBio());
        preparedStatement.setDouble(3, author.getAuthorScore());
        preparedStatement.setString(4, author.getAuthorImage());
        preparedStatement.setDate(5, Date.valueOf(author.getAuthorBirthDate()));
        preparedStatement.setString(6, authorId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("AuthorDao.update() result: " + updateResult + " | " + authorId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String authorId) throws Exception {
        
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_AUTHORS_SQL);
        preparedStatement.setString(1, authorId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Author findOne(String authorId) throws Exception {
        Author author = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID);
        preparedStatement.setString(1, authorId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            author = new Author(resultSet.getString("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_bio"), resultSet.getDouble("author_score"),
                    resultSet.getString("author_image"), resultSet.getString("author_birth_date"));
        }

        return author;
    }

    @Override
    public List<Author> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_AUTHORS);

        while (resultSet.next()) {
            Author author = new Author(resultSet.getString("author_id"),
                    resultSet.getString("author_name"),
                    resultSet.getString("author_bio"), resultSet.getDouble("author_score"),
                    resultSet.getString("author_image"), resultSet.getString("author_birth_date"));
            authors.add(author);
        }

        return authors.isEmpty() ? null : authors;
    }
}
```

test3. AuthorDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.AuthorDao;
import com.bookify.model.Author;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the AuthorDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateAuthorDao, testUpdateAuthorDao, testFindOneAuthorDao, testDeleteAuthorDao, testFindAllAuthorDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorDaoTest {

    private static AuthorDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new AuthorDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateAuthorDao() {
        try {
            assertNotNull(dao.create(new Author("au91009","J.K. Rowling","J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series.",4.5, "jkrowling.jpg","1965-07-31")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateAuthorDao() {
        try {
            assertNotNull(dao.update("au91009", new Author("au91009","J.K. Rowling222","J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series.",4.5, "jkrowling.jpg","1965-07-31")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteAuthorDao() {
        try {
            assertNotNull(dao.delete("au91009"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testFindOneAuthorDao() {
        try {
            assertNotNull(dao.findOne("au91009"));
            System.out.println(dao.findOne("au91009"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllAuthorDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}

```

#### dao4. GenreDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the Genre model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */

public class GenreDao implements IDao<Genre> {

    private DBConnection dbConnection;
    private List<Genre> genres = new ArrayList<>();

    private static final String INSERT_GENRES_SQL = "INSERT INTO tbl_genre VALUES (?,?,?,?)";
    private static final String UPDATE_GENRES_SQL = "UPDATE tbl_genre SET genre_name = ?, genre_description = ?, genre_image = ? WHERE genre_id = ?";
    private static final String DELETE_GENRES_SQL = "DELETE FROM tbl_genre WHERE genre_id = ?";
    private static final String SELECT_GENRE_BY_ID = "SELECT * FROM tbl_genre WHERE genre_id = ?";
    private static final String SELECT_ALL_GENRES = "SELECT * FROM tbl_genre";

    public GenreDao() {
        super();
    }

    public GenreDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Genre create(Genre genre) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GENRES_SQL);
        preparedStatement.setString(1, genre.getGenreId());
        preparedStatement.setString(2, genre.getGenreName());
        preparedStatement.setString(3, genre.getGenreDescription());
        preparedStatement.setString(4, genre.getGenreImage());

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("GenreDao.create() result: " + result + " | " + genre.getGenreId() + " inserted!");

        return result > 0 ? genre : null;
    }

    @Override
    public boolean update(String genreId, Genre genre) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GENRES_SQL);
        preparedStatement.setString(1, genre.getGenreName());
        preparedStatement.setString(2, genre.getGenreDescription());
        preparedStatement.setString(3, genre.getGenreImage());
        preparedStatement.setString(4, genreId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("GenreDao.update() result: " + updateResult + " | " + genreId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String genreId) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GENRES_SQL);
        preparedStatement.setString(1, genreId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Genre findOne(String genreId) throws Exception {
        Genre genre = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GENRE_BY_ID);
        preparedStatement.setString(1, genreId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            genre = new Genre(resultSet.getString("genre_id"),
                    resultSet.getString("genre_name"),
                    resultSet.getString("genre_description"), resultSet.getString("genre_image"));
        }

        return genre;
    }

    @Override
    public List<Genre> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_GENRES);

        while (resultSet.next()) {
            Genre genre = new Genre(resultSet.getString("genre_id"),
                    resultSet.getString("genre_name"),
                    resultSet.getString("genre_description"), resultSet.getString("genre_image"));
            genres.add(genre);
        }

        return genres.isEmpty() ? null : genres;
    }
}
```

test4. GenreDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.GenreDao;
import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the GenreDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateGenreDao, testUpdateGenreDao, testFindOneGenreDao, testDeleteGenreDao, testFindAllGenreDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreDaoTest {

    private static GenreDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new GenreDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateGenreDao() {
        try {
            assertNotNull(dao.create(new Genre("ge91002","Science Fiction","Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life." ,"science.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateGenreDao() {
        try {
            assertTrue(dao.update("ge91002", new Genre("ge91002","Science Fictionupadofjaodfkljadfjalfdkja","Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life." ,"science.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteGenreDao() {
        try {
            assertTrue(dao.delete("ge91002"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testFindOneGenreDao() {
        try {
            assertNotNull(dao.findOne("ge91002"));
            System.out.println(dao.findOne("ge91002"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllGenreDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}
```

#### dao5. BookDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import com.bookify.model.Book;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the Book model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @param <Book> the model to be used for CRUD operations.
 *      where Book object contains the object of Author, BookCategory, and Genre.
 * 
 * @throws Exception if any of the CRUD operations fail.
 */

public class BookDao implements IDao<Book> {

    private DBConnection dbConnection;

    private AuthorDao authorDao;
    private BookCategoryDao bookCategoryDao;
    private GenreDao genreDao;
    private List<Book> books = new ArrayList<>();

    public BookDao() {
        super();
    }

    public BookDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
        this.authorDao = new AuthorDao(dbConnection);
        this.bookCategoryDao = new BookCategoryDao(dbConnection);
        this.genreDao = new GenreDao(dbConnection);
    }

    @Override
    public Book create(Book book) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "INSERT INTO tbl_book (book_id, author_id, category_id, book_title, book_description, book_publish_date, book_price, discontinued, book_pages, book_discount, available_quantity, book_language, book_publisher, book_isbn, book_cover_image, genre_ids) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, type_genre_id_list(" + String.join(", ", Collections.nCopies(book.getGenres().size(), "?")) + "))";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, book.getBookId());
        preparedStatement.setString(2, book.getAuthor().getAuthorId());
        preparedStatement.setString(3, book.getCategory().getCategoryId());
        preparedStatement.setString(4, book.getBookTitle());
        preparedStatement.setString(5, book.getBookDescription());
        preparedStatement.setDate(6, Date.valueOf(book.getBookPublishDate()));
        preparedStatement.setDouble(7, book.getBookPrice());
        preparedStatement.setBoolean(8, book.isDiscontinued());
        preparedStatement.setInt(9, book.getBookPages());
        preparedStatement.setDouble(10, book.getBookDiscount());
        preparedStatement.setInt(11, book.getAvailableQuantity());
        preparedStatement.setString(12, book.getBookLanguage());
        preparedStatement.setString(13, book.getBookPublisher());
        preparedStatement.setString(14, book.getBookIsbn());
        preparedStatement.setString(15, book.getBookCoverImage());
        for (int i = 0; i < book.getGenres().size(); i++) {
            preparedStatement.setString(16 + i, book.getGenres().stream().map(genre -> genre.getGenreId()).collect(Collectors.toList()).get(i));
        }

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("BookDao.create() result: " + result + " | " + book.getBookId() + " inserted!");

        return result > 0 ? book : null;
    }

    
    @Override
    public boolean update(String bookId, Book book) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "UPDATE tbl_book SET author_id = ?, category_id = ?, book_title = ?, book_description = ?, book_publish_date = ?, book_price = ?, discontinued = ?, book_pages = ?, book_discount = ?, available_quantity = ?, book_language = ?, book_publisher = ?, book_isbn = ?, book_cover_image = ?, genre_ids = type_genre_id_list(" + String.join(", ", Collections.nCopies(book.getGenres().size(), "?")) + ") WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, book.getAuthor().getAuthorId());
        preparedStatement.setString(2, book.getCategory().getCategoryId());
        preparedStatement.setString(3, book.getBookTitle());
        preparedStatement.setString(4, book.getBookDescription());
        preparedStatement.setDate(5, Date.valueOf(book.getBookPublishDate()));
        preparedStatement.setDouble(6, book.getBookPrice());
        preparedStatement.setBoolean(7, book.isDiscontinued());
        preparedStatement.setInt(8, book.getBookPages());
        preparedStatement.setDouble(9, book.getBookDiscount());
        preparedStatement.setInt(10, book.getAvailableQuantity());
        preparedStatement.setString(11, book.getBookLanguage());
        preparedStatement.setString(12, book.getBookPublisher());
        preparedStatement.setString(13, book.getBookIsbn());
        preparedStatement.setString(14, book.getBookCoverImage());
        for (int i = 0; i < book.getGenres().size(); i++) {
            preparedStatement.setString(15 + i, book.getGenres().stream().map(genre -> genre.getGenreId()).collect(Collectors.toList()).get(i));
        }
        preparedStatement.setString(15 + book.getGenres().size(), bookId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("BookDao.update() result: " + updateResult + " | " + bookId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String bookId) throws Exception {

        Connection connection = dbConnection.getConnection();
        String sqlQuery = "DELETE FROM tbl_book WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public Book findOne(String bookId) throws Exception {
        Book book = null;
        
        Connection connection = dbConnection.getConnection();
        String sqlQuery = "SELECT * FROM tbl_book WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            book = new Book();

            book.setBookId(resultSet.getString("book_id"));
            book.setAuthor(authorDao.findOne(resultSet.getString("author_id")));
            book.setCategory(bookCategoryDao.findOne(resultSet.getString("category_id")));

            // Set<Genre> genres = new HashSet<>();
            // for (String genreId : (String[]) resultSet.getArray("genre_ids").getArray()) {
            //     genres.add(genreDao.findOne(genreId));
            // }

            
            // book.setGenres(genres);

            try {
                book.setGenres(Arrays.stream((String[]) resultSet.getArray("genre_ids").getArray())
                    .map(genreId -> {
                        try {
                            return genreDao.findOne(genreId);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toSet()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            book.setBookTitle(resultSet.getString("book_title"));
            book.setBookDescription(resultSet.getString("book_description"));
            book.setBookPublishDate(resultSet.getDate("book_publish_date").toString());
            book.setBookPrice(resultSet.getDouble("book_price"));
            book.setDiscontinued(resultSet.getBoolean("discontinued"));
            book.setBookPages(resultSet.getInt("book_pages"));
            book.setBookDiscount(resultSet.getDouble("book_discount"));
            book.setAvailableQuantity(resultSet.getInt("available_quantity"));
            book.setBookLanguage(resultSet.getString("book_language"));
            book.setBookPublisher(resultSet.getString("book_publisher"));
            book.setBookIsbn(resultSet.getString("book_isbn"));
            book.setBookCoverImage(resultSet.getString("book_cover_image"));
        }

        return book;
    }

    @Override
    public List<Book> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_book";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Book book = new Book();

            book.setBookId(resultSet.getString("book_id"));
            book.setAuthor(authorDao.findOne(resultSet.getString("author_id")));
            book.setCategory(bookCategoryDao.findOne(resultSet.getString("category_id")));

            try {
                book.setGenres(Arrays.stream((String[]) resultSet.getArray("genre_ids").getArray())
                    .map(genreId -> {
                        try {
                            return genreDao.findOne(genreId);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toSet()));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            book.setBookTitle(resultSet.getString("book_title"));
            book.setBookDescription(resultSet.getString("book_description"));
            book.setBookPublishDate(resultSet.getDate("book_publish_date").toString());
            book.setBookPrice(resultSet.getDouble("book_price"));
            book.setDiscontinued(resultSet.getBoolean("discontinued"));
            book.setBookPages(resultSet.getInt("book_pages"));
            book.setBookDiscount(resultSet.getDouble("book_discount"));
            book.setAvailableQuantity(resultSet.getInt("available_quantity"));
            book.setBookLanguage(resultSet.getString("book_language"));
            book.setBookPublisher(resultSet.getString("book_publisher"));
            book.setBookIsbn(resultSet.getString("book_isbn"));
            book.setBookCoverImage(resultSet.getString("book_cover_image"));

            books.add(book);
        }

        return books.isEmpty() ? null : books;
    }
}

```

test5. BookDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;

import com.bookify.dao.BookDao;
import com.bookify.model.Author;
import com.bookify.model.Book;
import com.bookify.model.BookCategory;
import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the BookDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateBookDao, testUpdateBookDao, testFindOneBookDao, testDeleteBookDao, testFindAllBookDao.
 * @throws Exception if any of the CRUD operations fail.
 */

public class BookDaoTest {

    private static BookDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new BookDao(DBConnection.getDBConnection());
    }
    
    @Test
    public void testCreateBookDao() {
        try {
            Set<Genre> genres = new HashSet<>();
            genres.add(new Genre("ge91002","Science Fiction","Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life." ,"science.jpg"));
            genres.add(new Genre("ge91003","Fantasy","Fantasy is a genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore." ,"fantasy.jpg"));
            
            assertNotNull(dao.create(
                new Book(
                    "bo16118",
                    new Author("au91009","J.K. Rowling","J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series.",4.5, "jkrowling.jpg","1965-07-31"), 
                    new BookCategory("bc91002","baby's Book","Book for small childrens","science.jpg"), 
                    genres,
                    "Harry Potter and the Philosopher's Stone", 
                    "Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.", 
                    "1997-06-26", 
                    1000.00,    
                    false, 
                    223, 
                    0.2, 
                    100, 
                    "English", 
                    "Bloomsbury Publishing", 
                    "9780747532743", 
                    "harrypotter.jpg"))
            );
            System.out.println("Book created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateBookDao() {
        try {
            Set<Genre> genres = new HashSet<>();
            genres.add(new Genre("ge91002","Science Fiction","Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life." ,"science.jpg"));
            genres.add(new Genre("ge91003","Fantasy","Fantasy is a genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore." ,"fantasy.jpg"));
            
            assertNotNull(dao.update(
                "bo16118",
                new Book(
                    "bo16118", 
                    new Author("au91009","________________xxxxx____________","J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series.",4.5, "jkrowling.jpg","1965-07-31"), 
                    new BookCategory("bc91002","baby's Book","Book for small childrens","science.jpg"), 
                    genres,
                    "Harry Potter and the Philosopher's Stone", 
                    "This is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry.", 
                    "1999-06-26", 
                    10.00,    
                    false, 
                    223, 
                    0.2, 
                    100, 
                    "English", 
                    "Bloomsbury Publishing", 
                    "9780747532743", 
                    "harrypotter.jpg"))
            );
            System.out.println("Book updated successfully");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Ignore
    @Test
    public void testDeleteBookDao() {
        try {
            assertTrue(dao.delete("bo16118"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneBookDao() {
        try{
            assertNotNull(dao.findOne("bo16118"));
            System.out.println(dao.findOne("bo16118"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
            Book [
                author=Author [authorId=au91009, authorName=J.K. Rowling, authorBio=J.K. Rowling is a British author, best known for creating the Harry Potter fantasy series., authorScore=4.5, authorImage=jkrowling.jpg, authorBirthDate=1965-07-31 00:00:00.0], 
                category=BookCategory [categoryId=bc91002, categoryDescription=Book for small childrens, categoryImage=science.jpg, categoryName=Childrens's Book], 
                genres=[Genre [genreId=ge91003, genreName=Fantasy, genreDescription=Fantasy is a genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore., genreImage=fantasy.jpg], Genre [genreId=ge91002, genreName=Science Fiction, genreDescription=Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life., genreImage=science.jpg]]
                availableQuantity=100, 
                bookCoverImage=harrypotter.jpg, 
                bookDescription=This is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, 
                it follows Harry Potter, 
                a young wizard who discovers his magical heritage on his eleventh birthday, 
                when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry., 
                bookDiscount=0.2, 
                bookId=bo16118, 
                bookIsbn=9780747532743, 
                bookLanguage=English, 
                bookPages=223, 
                bookPrice=10.0, 
                bookPublishDate=1999-06-26, 
                bookPublisher=Bloomsbury Publishing, 
                bookTitle=Harry Potter and the Philosopher's Stone, 
                discontinued=false, 
            ]
         */
    }

    @Test
    public void testFindAllBookDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}
```

#### model5. UserReview
```java
package com.bookify.model;

/*
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
```
Dao6. UserReviewDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.UserReview;
import com.bookify.util.DBConnection;

/*
 * Represents a DAO for the UserReview model.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class UserReviewDao implements IDao<UserReview> {

    private DBConnection dbConnection;
    private List<UserReview> userReviews = new ArrayList<>();

    private static final String INSERT_USERREVIEWS_SQL = "INSERT INTO tbl_user_review VALUES (?,?,?,?,?)";
    private static final String UPDATE_USERREVIEWS_SQL = "UPDATE tbl_user_review SET customer_id = ?, book_rating = ?, book_review = ?, review_date = ? WHERE book_id = ? AND customer_id = ?";
    private static final String DELETE_USERREVIEWS_SQL = "DELETE FROM tbl_user_review WHERE book_id = ? AND customer_id = ?";
    private static final String SELECT_USERREVIEW_BY_ID = "SELECT * FROM tbl_user_review WHERE book_id = ? AND customer_id = ?";
    private static final String SELECT_ALL_USERREVIEWS = "SELECT * FROM tbl_user_review";

    public UserReviewDao() {
        super();
    }

    public UserReviewDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public UserReview create(UserReview userReview) throws Exception {

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERREVIEWS_SQL);
        preparedStatement.setString(1, userReview.getBookId());
        preparedStatement.setString(2, userReview.getCustomerId());
        preparedStatement.setDouble(3, userReview.getBookRating());
        preparedStatement.setString(4, userReview.getBookReview());
        preparedStatement.setDate(5, Date.valueOf(userReview.getReviewDate()));

        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("UserReviewDao.create() result: " + result + " | " + userReview.getBookId() + " " + userReview.getCustomerId() + " inserted!");

        return result > 0 ? userReview : null;
    }

    @Override
    public boolean update(String bookIdCustomerId, UserReview userReview) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERREVIEWS_SQL);
        preparedStatement.setString(1, userReview.getCustomerId());
        preparedStatement.setDouble(2, userReview.getBookRating());
        preparedStatement.setString(3, userReview.getBookReview());
        preparedStatement.setDate(4, Date.valueOf(userReview.getReviewDate()));
        preparedStatement.setString(5, bookId);
        preparedStatement.setString(6, customerId);

        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("UserReviewDao.update() result: " + updateResult + " | " + bookId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String bookIdCustomerId) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERREVIEWS_SQL);
        preparedStatement.setString(1, bookId);
        preparedStatement.setString(2, customerId);

        int deleteResult = preparedStatement.executeUpdate();
        return deleteResult > 0;
    }

    @Override
    public UserReview findOne(String bookIdCustomerId) throws Exception {
        String[] bookIdCustomerIdArray = bookIdCustomerId.split(" ");
        String bookId = bookIdCustomerIdArray[0], customerId = bookIdCustomerIdArray[1];

        UserReview userReview = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERREVIEW_BY_ID);
        preparedStatement.setString(1, bookId);
        preparedStatement.setString(2, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            userReview = new UserReview(resultSet.getString("book_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getDouble("book_rating"),
                    resultSet.getString("book_review"),
                    resultSet.getString("review_date"));
        }

        return userReview;
    }

    @Override
    public List<UserReview> findAll() throws Exception {

        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_USERREVIEWS);

        while (resultSet.next()) {
            UserReview userReview = new UserReview(resultSet.getString("book_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getDouble("book_rating"),
                    resultSet.getString("book_review"),
                    resultSet.getString("review_date"));
            userReviews.add(userReview);
        }

        return userReviews.isEmpty() ? null : userReviews;
    }
}
```

test6. UserReviewDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.UserReviewDao;
import com.bookify.model.UserReview;
import com.bookify.util.DBConnection;


/*
 * Represents a test class for the UserReviewDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateUserReviewDao, testUpdateUserReviewDao, testFindOneUserReviewDao, testDeleteUserReviewDao, testFindAllUserReviewDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class UserReviewDaoTest {

    private static UserReviewDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new UserReviewDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateUserReviewDao() {
        try {
            assertNotNull(dao.create(new UserReview("bo00001","cu00001",4.5,"This is a great book!","2021-09-01")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUserReviewDao() {
        try {
            assertTrue(dao.update("bo00001 cu00001", new UserReview("bo00001","cu00001",0.5,"Worst Book ever!","2021-09-02")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteUserReviewDao() {
        try {
            assertTrue(dao.delete("bo00001 cu00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneUserReviewDao() {
        try {
            assertNotNull(dao.findOne("bo00001 cu00001"));
            System.out.println(dao.findOne("bo00001 cu00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllUserReviewDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}
```

#### model6. Customer
```java
package com.bookify.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Represents a Customer model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_customer")
 * 
 * @methods getCustomerId, setCustomerId, getCustomerName, setCustomerName, getCustomerEmail, setCustomerEmail, getCustomerPhone1, setCustomerPhone1, getCustomerPassword, setCustomerPassword, getCustomerAddresses, setCustomerAddresses, addCustomerAddress, removeCustomerAddress, getCustomerAddress, getShopingCart, setShopingCart, addCartItem, removeCartItem, clearShopingCart, getCartTotal, getWishlists, setWishlists, addWishlist, removeWishlist, clearWishlists, getSubscriptionLogHistory, setSubscriptionLogHistory, addSubscriptionLogHistory, removeSubscriptionLogHistory.
 * @throws Exception if any of the CRUD operations fail.
 */
public class Customer implements Comparable<Customer> {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone1;
    private String customerPassword;

    // create a hashmap with if <CustomerAddress.addressType, CustomerAddress> //
    // notGoodPractice? all
    /*
     * 'Home' -> customerAddress1
     * 'Office' -> customerAddress2
     */
    Map<String, CustomerAddress> customerAddresses = new HashMap<>();

    // shoping cart list of books
    ArrayList<ShoppingCartItem> shopingCart = new ArrayList<>(); // customer.shopingCart.add(new ShoppingCartItem(book, quantity))

    // List of all Wishlists
    ArrayList<Wishlist> wishlists = new ArrayList<>();

    /*
    list of subscription log history of a customer eg.
    [
        subscriptionLogHistory1[subscriptionLogId, customer, subscription, subscriptionStartDate, subscriptionEndDate],
        subscriptionLogHistory2[subscriptionLogId, customer, subscription, subscriptionStartDate, subscriptionEndDate],
        ...
    ]
    */
    ArrayList<SubscriptionLogHistory> subscriptionLogHistory = new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer(String customerId, String customerName, String customerEmail, String customerPhone1,
            String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone1 = customerPhone1;
        this.customerPassword = customerPassword;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone1() {
        return customerPhone1;
    }

    public void setCustomerPhone1(String customerPhone1) {
        this.customerPhone1 = customerPhone1;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Map<String, CustomerAddress> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(Map<String, CustomerAddress> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    public void addCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddresses.put(customerAddress.getAddressType(), customerAddress);
    }

    public void removeCustomerAddress(String addressType) {
        this.customerAddresses.remove(addressType);
    }

    public CustomerAddress getCustomerAddress(String addressType) {
        return this.customerAddresses.get(addressType);
    }

    public ArrayList<ShoppingCartItem> getShopingCart() {
        return shopingCart;
    }

    public void setShopingCart(ArrayList<ShoppingCartItem> shopingCart) {
        this.shopingCart = shopingCart;
    }

    public void addCartItem(ShoppingCartItem cartItem) {
        this.shopingCart.add(cartItem);
    }

    public void removeCartItem(ShoppingCartItem cartItem) {
        this.shopingCart.remove(cartItem);
    }

    public void clearShopingCart() {
        this.shopingCart.clear();
    }

    // to remove if notGoodPractice?
    // public double getCartTotal() {
    //     double total = 0;
    //     for (ShoppingCartItem cartItem : this.shopingCart) {
    //         total += (cartItem.getBookId().getBookPrice() * (1 - cartItem.getBookId().getBookDiscount()))
    //                 * cartItem.getQuantity();
    //     }
    //     return total;
    // }

    public ArrayList<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(ArrayList<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    public void addWishlist(Wishlist wishlist) {
        this.wishlists.add(wishlist);
    }

    public void removeWishlist(Wishlist wishlist) {
        this.wishlists.remove(wishlist);
    }

    public void clearWishlists() {
        this.wishlists.clear();
    }

    public ArrayList<SubscriptionLogHistory> getSubscriptionLogHistory() {
        return subscriptionLogHistory;
    }

    public void setSubscriptionLogHistory(ArrayList<SubscriptionLogHistory> subscriptionLogHistory) {
        this.subscriptionLogHistory = subscriptionLogHistory;
    }

    public void addSubscriptionLogHistory(SubscriptionLogHistory subscriptionLogHistory) {
        this.subscriptionLogHistory.add(subscriptionLogHistory);
    }

    public void removeSubscriptionLogHistory(SubscriptionLogHistory subscriptionLogHistory) {
        this.subscriptionLogHistory.remove(subscriptionLogHistory);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Customer other = (Customer) obj;
        if (customerId != other.customerId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [customerEmail=" + customerEmail + ", customerId=" + customerId + ", customerName="
                + customerName
                + ", customerPassword=" + customerPassword + ", customerPhone1=" + customerPhone1 + "]";
    }

    // FIXME: Implement the compareTo method LIKE return
    // this.stringValue.compareTo(other.stringValue);
    @Override
    public int compareTo(Customer o) {
        return Integer.parseInt(this.customerId.substring(2)) - Integer.parseInt(o.customerId.substring(2));
    }
}

```

#### model7. CustomerAddress
```java
package com.bookify.model;

/*
 * Represents a CustomerAddress model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_customer_address")
 * 
 * @methods getCustomerAddressId, setCustomerAddressId, getCustomer, setCustomer, getAddressType, setAddressType, getAddressLine1, setAddressLine1, getAddressLine2, setAddressLine2, getCity, setCity, getState, setState, getCountry, setCountry, getPostalCode, setPostalCode, getLandmark, setLandmark, getPhone, setPhone.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerAddress implements Comparable<CustomerAddress> {
    private String customerAddressId;
    private String customerId;
    private String addressType;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String landmark;
    private String phone;

    public CustomerAddress() {
        super();
    }

    public CustomerAddress(String customerAddressId, String customerId, String addressType, String addressLine1, String addressLine2, String city, String state, String country, String postalCode, String landmark, String phone) {
        this.customerAddressId = customerAddressId;
        this.customerId = customerId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.landmark = landmark;
        this.phone = phone;
    }

    public String getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(String customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerAddressId == null) ? 0 : customerAddressId.hashCode());
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
        CustomerAddress other = (CustomerAddress) obj;
        if (customerAddressId != other.customerAddressId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAddress [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressType=" + addressType
                + ", city=" + city + ", country=" + country + ", customer=" + customerId + ", customerAddressId=" + customerAddressId
                + ", landmark=" + landmark + ", phone=" + phone + ", postalCode=" + postalCode + ", state=" + state + "]";
    }

    // TODO: Implement the compareTo method for multiple primary keys
    @Override
    public int compareTo(CustomerAddress o) {
        return Integer.parseInt(this.customerAddressId.substring(2)) - Integer.parseInt(o.customerAddressId.substring(2));
    }
}
```
#### dao7. CustomerAddressDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.CustomerAddress;
import com.bookify.util.DBConnection;

/*
 * Represents a CustomerAddressDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerAddressDao implements IDao<CustomerAddress> {

    private DBConnection dbConnection;
    private List<CustomerAddress> customerAddresses = new ArrayList<>();

    private static final String INSERT_CUSTOMERADDRESSES_SQL = "INSERT INTO tbl_customer_address (customer_address_id, address_type, customer_id, address_line1, address_line2, address_line3, city, state, country, postalcode, landmark, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMERADDRESSES_SQL = "UPDATE tbl_customer_address SET address_line1 = ?, address_line2 = ?, address_line3 = ?, city = ?, state = ?, country = ?, postalcode = ?, landmark = ?, phone = ? WHERE customer_id = ? AND address_type = ?";
    private static final String DELETE_CUSTOMERADDRESSES_SQL = "DELETE FROM tbl_customer_address WHERE customer_id = ? AND address_type = ?";
    private static final String SELECT_CUSTOMERADDRESS_BY_ID = "SELECT * FROM tbl_customer_address WHERE customer_id = ? AND address_type = ?";
    private static final String SELECT_ALL_CUSTOMERADDRESSES = "SELECT * FROM tbl_customer_address";

    public CustomerAddressDao() {
        super();
    }

    public CustomerAddressDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public CustomerAddress create(CustomerAddress customerAddress) throws Exception {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERADDRESSES_SQL);
        preparedStatement.setString(1, customerAddress.getCustomerAddressId());
        preparedStatement.setString(2, customerAddress.getAddressType());
        preparedStatement.setString(3, customerAddress.getCustomerId());
        preparedStatement.setString(4, customerAddress.getAddressLine1());
        preparedStatement.setString(5, customerAddress.getAddressLine2());
        preparedStatement.setString(6, customerAddress.getAddressLine3());
        preparedStatement.setString(7, customerAddress.getCity());
        preparedStatement.setString(8, customerAddress.getState());
        preparedStatement.setString(9, customerAddress.getCountry());
        preparedStatement.setString(10, customerAddress.getPostalCode());
        preparedStatement.setString(11, customerAddress.getLandmark());
        preparedStatement.setString(12, customerAddress.getPhone());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("CustomerAddressDao.create() result: " + result + " | " + customerAddress.getCustomerAddressId() + " inserted!");

        return result > 0 ? customerAddress : null;
    }

    @Override
    public boolean update(String customerAddressTypeId, CustomerAddress customerAddress) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERADDRESSES_SQL);
        preparedStatement.setString(1, customerAddress.getAddressLine1());
        preparedStatement.setString(2, customerAddress.getAddressLine2());
        preparedStatement.setString(3, customerAddress.getAddressLine3());
        preparedStatement.setString(4, customerAddress.getCity());
        preparedStatement.setString(5, customerAddress.getState());
        preparedStatement.setString(6, customerAddress.getCountry());
        preparedStatement.setString(7, customerAddress.getPostalCode());
        preparedStatement.setString(8, customerAddress.getLandmark());
        preparedStatement.setString(9, customerAddress.getPhone());
        preparedStatement.setString(10, customerId);
        preparedStatement.setString(11, addressType);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("CustomerAddressDao.update() result: " + updateResult + " | " + customerId + addressType + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerAddressTypeId) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERADDRESSES_SQL);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, addressType);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("CustomerAddressDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public CustomerAddress findOne(String customerAddressTypeId) throws Exception {
        String[] customerAddressTypeIdArray = customerAddressTypeId.split(" ");
        String customerId = customerAddressTypeIdArray[0], addressType = customerAddressTypeIdArray[1];

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERADDRESS_BY_ID);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, addressType);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setCustomerAddressId(resultSet.getString("customer_address_id"));
            customerAddress.setAddressType(resultSet.getString("address_type"));
            customerAddress.setCustomerId(resultSet.getString("customer_id"));
            customerAddress.setAddressLine1(resultSet.getString("address_line1"));
            customerAddress.setAddressLine2(resultSet.getString("address_line2"));
            customerAddress.setAddressLine3(resultSet.getString("address_line3"));
            customerAddress.setCity(resultSet.getString("city"));
            customerAddress.setState(resultSet.getString("state"));
            customerAddress.setCountry(resultSet.getString("country"));
            customerAddress.setPostalCode(resultSet.getString("postalcode"));
            customerAddress.setLandmark(resultSet.getString("landmark"));
            customerAddress.setPhone(resultSet.getString("phone"));
            return customerAddress;
        }

        return null;
    }

    @Override
    public List<CustomerAddress> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_CUSTOMERADDRESSES);
        
        while (resultSet.next()) {
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setCustomerAddressId(resultSet.getString("customer_address_id"));
            customerAddress.setAddressType(resultSet.getString("address_type"));
            customerAddress.setCustomerId(resultSet.getString("customer_id"));
            customerAddress.setAddressLine1(resultSet.getString("address_line1"));
            customerAddress.setAddressLine2(resultSet.getString("address_line2"));
            customerAddress.setAddressLine3(resultSet.getString("address_line3"));
            customerAddress.setCity(resultSet.getString("city"));
            customerAddress.setState(resultSet.getString("state"));
            customerAddress.setCountry(resultSet.getString("country"));
            customerAddress.setPostalCode(resultSet.getString("postalcode"));
            customerAddress.setLandmark(resultSet.getString("landmark"));
            customerAddress.setPhone(resultSet.getString("phone"));
            customerAddresses.add(customerAddress);
        }

        return customerAddresses.isEmpty() ? null : customerAddresses;
    }    
}
```

Test7. CustomerAddressDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.CustomerAddressDao;
import com.bookify.model.CustomerAddress;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the CustomerAddressDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateCustomerAddressDao, testUpdateCustomerAddressDao, testFindOneCustomerAddressDao, testDeleteCustomerAddressDao, testFindAllCustomerAddressDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerAddressDaoTest {

    private static CustomerAddressDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new CustomerAddressDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateCustomerAddressDao() {
        try {
            assertNotNull(dao.create(new CustomerAddress("ca00012","cu00007","Home","123, 1st Cross, 1st Main","2nd Floor, 1st Cross, 1st Main","3ed line","Bangalore","Karnataka","India","560001","Near Bus Stop","1234567890")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateCustomerAddressDao() {
        try {
            assertTrue(dao.update("cu00007 Home", new CustomerAddress("ca00012","cu00007","Home","654, 1st Cross, 1st Main","2nd Floor, 1st Cross, 1st Main","3ed line","Bangalore","Karnataka","India","560001","Near Bus Stop","1234567890")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteCustomerAddressDao() {
        try {
            assertTrue(dao.delete("cu00007 Home"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneCustomerAddressDao() {
        try {
            assertNotNull(dao.findOne("cu00007 Home"));
            System.out.println(dao.findOne("cu00007 Home"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllCustomerAddressDao() throws Exception {
        assertNotNull(dao.findAll());
        dao.findAll().stream().forEach(System.out::println);
    }
}
```

#### dao8. CustomerDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Customer;
import com.bookify.util.DBConnection;

/*
 * Represents a CustomerDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerDao implements IDao<Customer> {

    private DBConnection dbConnection;
    private List<Customer> customers = new ArrayList<>();

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO tbl_customer (customer_id, customer_name, customer_email, customer_phone1, password_hash) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMERS_SQL = "UPDATE tbl_customer SET customer_name = ?, customer_email = ?, customer_phone1 = ?, password_hash = ? WHERE customer_id = ?";
    private static final String DELETE_CUSTOMERS_SQL = "DELETE FROM tbl_customer WHERE customer_id = ?";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM tbl_customer WHERE customer_id = ?";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM tbl_customer";

    public CustomerDao() {
        super();
    }

    public CustomerDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Customer create(Customer customer) throws Exception {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);
        preparedStatement.setString(1, customer.getCustomerId());
        preparedStatement.setString(2, customer.getCustomerName());
        preparedStatement.setString(3, customer.getCustomerEmail());
        preparedStatement.setString(4, customer.getCustomerPhone1());
        preparedStatement.setString(5, customer.getCustomerPassword());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("CustomerDao.create() result: " + result + " | " + customer.getCustomerId() + " inserted!");

        return result > 0 ? customer : null;
    }

    @Override
    public boolean update(String customerId, Customer customer) throws Exception {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);
        preparedStatement.setString(1, customer.getCustomerName());
        preparedStatement.setString(2, customer.getCustomerEmail());
        preparedStatement.setString(3, customer.getCustomerPhone1());
        preparedStatement.setString(4, customer.getCustomerPassword());
        preparedStatement.setString(5, customerId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("CustomerDao.update() result: " + updateResult + " | " + customerId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerId) throws Exception {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);
        preparedStatement.setString(1, customerId);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("CustomerDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public Customer findOne(String customerId) throws Exception {
        Customer customer = null;

        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
        preparedStatement.setString(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            customer = new Customer();
            customer.setCustomerId(resultSet.getString("customer_id"));
            customer.setCustomerName(resultSet.getString("customer_name"));
            customer.setCustomerEmail(resultSet.getString("customer_email"));
            customer.setCustomerPhone1(resultSet.getString("customer_phone1"));
            customer.setCustomerPassword(resultSet.getString("password_hash"));
        }

        return customer;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(SELECT_ALL_CUSTOMERS);

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("customer_id"));
            customer.setCustomerName(resultSet.getString("customer_name"));
            customer.setCustomerEmail(resultSet.getString("customer_email"));
            customer.setCustomerPhone1(resultSet.getString("customer_phone1"));
            customer.setCustomerPassword(resultSet.getString("password_hash"));
            customers.add(customer);
        }

        return customers.isEmpty() ? null : customers;
    }
}
```

Test8. CustomerDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.CustomerDao;
import com.bookify.model.Customer;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the CustomerDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateCustomerDao, testUpdateCustomerDao, testFindOneCustomerDao, testDeleteCustomerDao, testFindAllCustomerDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class CustomerDaoTest {

    private static CustomerDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new CustomerDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateCustomerDao() {
        try {
            assertNotNull(dao.create(new Customer("cu91009","John Doe","ayon.ssp@gmail.com","1234567890","password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateCustomerDao() {
        try {
            assertTrue(dao.update("cu91009", new Customer("cu91009","John Doe","ayon.ssp@gmail.com","1234567890","password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteCustomerDao() {
        try {
            assertTrue(dao.delete("cu91009"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneCustomerDao() {
        try {
            assertNotNull(dao.findOne("cu91009"));
            System.out.println(dao.findOne("cu91009"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllCustomerDao() {
        try {
            assertNotNull(dao.findAll());
            dao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### model8. ShoppingCartItem
```java
package com.bookify.model;

/*
 * Represents a ShoppingCartItem model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_shopping_cart")
 * 
 * @methods getCustomerId, setCustomerId, getBook, setBook, getQuantity, setQuantity.
 * @throws Exception if any of the CRUD operations fail.
 */
public class ShoppingCartItem implements Comparable<ShoppingCartItem> {
    private String customerId;
    private Book book;
    private int quantity;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(String customerId, Book book, int quantity) {
        this.customerId = customerId;
        this.book = book;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((book == null) ? 0 : book.hashCode());
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
        ShoppingCartItem other = (ShoppingCartItem) obj;
        if (customerId != other.customerId)
            return false;
        if (book != other.book)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem [book=" + book + ", customerId=" + customerId + ", quantity=" + quantity + "]";
    }

    @Override
    public int compareTo(ShoppingCartItem o) {
        return Integer.parseInt(this.customerId.substring(2)) - Integer.parseInt(o.customerId.substring(2));
    }
}
```

#### dao9. ShoppingCartItemDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Book;
import com.bookify.model.ShoppingCartItem;
import com.bookify.util.DBConnection;

/*
 * Represents a ShoppingCartItemDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class ShoppingCartItemDao implements IDao<ShoppingCartItem> {

    private DBConnection dbConnection;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    // private static final String INSERT_SHOPPINGCARTITEMS_SQL = "INSERT INTO tbl_author VALUES (?,?,?,?,?,?)";
    // private static final String UPDATE_SHOPPINGCARTITEMS_SQL = "UPDATE tbl_author SET author_name = ?, author_bio = ?, author_score = ?, author_image = ?, author_birth_date = ? WHERE author_id = ?";
    // private static final String DELETE_SHOPPINGCARTITEMS_SQL = "DELETE FROM tbl_author WHERE author_id = ?";
    // private static final String SELECT_SHOPPINGCARTITEM_BY_ID = "SELECT * FROM tbl_author WHERE author_id = ?";
    // private static final String SELECT_ALL_SHOPPINGCARTITEMS = "SELECT * FROM tbl_author";

    public ShoppingCartItemDao() {
        super();
    }

    public ShoppingCartItemDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public ShoppingCartItem create(ShoppingCartItem shoppingCartItem) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_shopping_cart (customer_id, book_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, shoppingCartItem.getCustomerId());
        preparedStatement.setString(2, shoppingCartItem.getBook().getBookId());
        preparedStatement.setInt(3, shoppingCartItem.getQuantity());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("ShoppingCartItemDao.create() result: " + result + " | " + shoppingCartItem.getCustomerId() + " inserted!");

        return result > 0 ? shoppingCartItem : null;
    }

    @Override
    public boolean update(String customerBookId, ShoppingCartItem shoppingCartItem) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_shopping_cart SET quantity = ? WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, shoppingCartItem.getQuantity());
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, bookId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("ShoppingCartItemDao.update() result: " + updateResult + " | " + customerId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerBookId) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_shopping_cart WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, bookId);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("ShoppingCartItemDao.delete() result: " + deleteResult + " | " + customerId + " deleted!");

        return deleteResult > 0;
    }
    
    @Override
    public ShoppingCartItem findOne(String customerBookId) throws Exception {
        String[] customerBookIdArray = customerBookId.split("-");
        String customerId = customerBookIdArray[0], bookId = customerBookIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_shopping_cart WHERE customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, bookId);

        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setCustomerId(resultSet.getString("customer_id"));
            shoppingCartItem.setBook(new Book(resultSet.getString("book_id")));
            shoppingCartItem.setQuantity(resultSet.getInt("quantity"));
            return shoppingCartItem;
        }

        return null;
    }

    @Override
    public List<ShoppingCartItem> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_shopping_cart";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setCustomerId(resultSet.getString("customer_id"));
            shoppingCartItem.setBook(new Book(resultSet.getString("book_id")));
            shoppingCartItem.setQuantity(resultSet.getInt("quantity"));
            shoppingCartItems.add(shoppingCartItem);
        }

        return shoppingCartItems.isEmpty() ? null : shoppingCartItems;
    }
}
```

Test9. ShoppingCartItemDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.ShoppingCartItemDao;
import com.bookify.model.Book;
import com.bookify.model.ShoppingCartItem;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the ShoppingCartItemDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateShoppingCartItemDao, testUpdateShoppingCartItemDao, testFindOneShoppingCartItemDao, testDeleteShoppingCartItemDao, testFindAllShoppingCartItemDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class ShoppingCartItemDaoTest {

    private static ShoppingCartItemDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new ShoppingCartItemDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateShoppingCartItemDao() {
        try {
            assertNotNull(dao.create(new ShoppingCartItem("cu00007", new Book("bo00001"), 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateShoppingCartItemDao() {
        try {
            assertTrue(dao.update("cu00007-bo00001", new ShoppingCartItem("cu00007", new Book("bo00001"), 2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteShoppingCartItemDao() {
        try {
            assertTrue(dao.delete("cu00007-bo00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneShoppingCartItemDao() {
        try {
            assertNotNull(dao.findOne("cu00007-bo00001"));
            System.out.println(dao.findOne("cu00007-bo00001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllShoppingCartItemDao() {
        try {
            assertNotNull(dao.findAll());
            dao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### collection1. BookRatingReviewList
```java
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
```

Test7. BookRatingReviewListTest
```java
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
```
<!-- 
Example: https://www.goodreads.com/book/show/49628.Cloud_Atlas
a service class that is built for a book page eg. bookify.com/book/bo90117 where this page contains all the datails of book class
like all book details
    book author details
    book genres
    book rating
    book reviews -> reviewer's data(customerId, name , bookRating, bookReview, reviewDate)
    can get the values like 
    z
 -->

#### service1. BookService
```java
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
```

Test10. BookServiceTest
```java
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
            assertTrue(bookService.getBookRating() > -1);
            System.out.println(bookService.getBookRating());
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

    @Test
    public void testGetBookReview() {
        try {
            assertNotNull(bookService.addBookToCart(3));
            System.out.println(bookService.addBookToCart(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
<!-- create a list which contains list of all books that returned by a author -->

#### collection2. AuthorBookList
```java
package com.bookify.collection;

import java.util.List;

import com.bookify.dao.BookDao;
import com.bookify.model.Book;

/*
 * Represents a AuthorBookList collection.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getAuthorBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorBookList {

    private BookDao bookDao;

    public AuthorBookList(BookDao bookDao) {
        super();
        this.bookDao = bookDao;
    }

    public List<Book> getAuthorBooks(String authorId) throws Exception {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getAuthor().getAuthorId().equals(authorId))
                .toList();
    }
}
```

Test11. AuthorBookListTest
```java
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
```

#### service2. AuthorService
```java
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
```

Test12. AuthorServiceTest
```java
package com.bookify.service;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Represents a test class for the AuthorService.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetAuthor, testGetAuthorBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class AuthorServiceTest {

    private static AuthorService authorService;

    @BeforeClass
    public static void BeforeClass() {
        authorService = new AuthorService("au00001");
    }

    @Test
    public void testAuthor() {
        try {
            System.out.println(authorService.author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAuthorBooks() {
        try {
            assertNotNull(authorService.getAuthorBooks("au00001"));
            authorService.getAuthorBooks("au00001").stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### collection2. GenreBookList
```java
package com.bookify.collection;

import java.util.List;

import com.bookify.dao.BookDao;
import com.bookify.model.Book;

/*
 * Represents a GenreBookList collection.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreBookList {

    private BookDao bookDao;

    public GenreBookList(BookDao bookDao) {
        super();
        this.bookDao = bookDao;
    }

    public List<Book> getGenreBooks(String genreId) throws Exception {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .filter(book -> book.getGenres().stream().anyMatch(genre -> genre.getGenreId().equals(genreId)))
                .toList();
    }
}
```

Test13. GenreBookListTest
```java
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
```

#### service3. GenreService
```java
package com.bookify.service;

import java.util.List;

import com.bookify.collection.GenreBookList;
import com.bookify.dao.BookDao;
import com.bookify.dao.GenreDao;
import com.bookify.model.Book;
import com.bookify.model.Genre;
import com.bookify.util.DBConnection;

/*
 * Represents a GenreService class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods getGenre, getGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreService {

    public Genre genre;
    private GenreDao genreDao;
    private BookDao bookDao;
    private GenreBookList genreBookList;

    public GenreService() {
        super();
    }

    public GenreService(String genreId) {
        super();
        
        this.genreDao = new GenreDao(DBConnection.getDBConnection());
        this.bookDao = new BookDao(DBConnection.getDBConnection());
        this.genreBookList = new GenreBookList(bookDao);
        
        try {
            this.genre = genreDao.findOne(genreId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Book> getGenreBooks(String genreId) throws Exception {
        return genreBookList.getGenreBooks(genreId);
    }
}
```

Test14. GenreServiceTest
```java
package com.bookify.service;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Represents a test class for the GenreService.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testGetGenre, testGetGenreBooks.
 * @throws Exception if any of the CRUD operations fail.
 */
public class GenreServiceTest {

    private static GenreService genreService;

    @BeforeClass
    public static void BeforeClass() {
        genreService = new GenreService
        ("ge00001");
    }

    @Test
    public void testGenre() {
        try {
            System.out.println(genreService.genre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGenreBooks() {
        try {
            assertNotNull(genreService.getGenreBooks("ge00001"));
            genreService.getGenreBooks("ge00001").stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### model9. Wishlist
```java
package com.bookify.model;

import java.util.ArrayList;

public class Wishlist implements Comparable<Wishlist> {
    private String customerWishlistId;
    private String customerId;
    private String wishlistName;
    private String wishlistDescription;
    private String wishlistImage;

    // one wishlist contains many books // notGoodPractice?
    private ArrayList<Book> wishListItem = new ArrayList<>();

    public Wishlist() {
        super();
    }

    public Wishlist(String customerWishlistId, String customerId, String wishlistName, String wishlistDescription, String wishlistImage) {
        this.customerWishlistId = customerWishlistId;
        this.customerId = customerId;
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
        this.wishlistImage = wishlistImage;
    }

    public String getCustomerWishlistId() {
        return customerWishlistId;
    }

    public void setCustomerWishlistId(String customerWishlistId) {
        this.customerWishlistId = customerWishlistId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public String getWishlistDescription() {
        return wishlistDescription;
    }

    public void setWishlistDescription(String wishlistDescription) {
        this.wishlistDescription = wishlistDescription;
    }

    public String getWishlistImage() {
        return wishlistImage;
    }

    public void setWishlistImage(String wishlistImage) {
        this.wishlistImage = wishlistImage;
    }

    public ArrayList<Book> getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(ArrayList<Book> wishListItem) {
        this.wishListItem = wishListItem;
    }

    public void addBook(Book book) {
        wishListItem.add(book);
    }

    public void removeBook(Book book) {
        wishListItem.remove(book);
    }

    public void clearWishlist() {
        wishListItem.clear();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerWishlistId == null) ? 0 : customerWishlistId.hashCode());
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
        Wishlist other = (Wishlist) obj;
        if (customerWishlistId != other.customerWishlistId)
            return false;
        if (customerId != other.customerId)
            return false;
        return true;
    }

    // FIXME: correct the order of display toString
    @Override
    public String toString() {
        // follow the correct order how i created the fields
        return "Wishlist [customerId=" + customerId + ", customerWishlistId=" + customerWishlistId + ", wishlistDescription=" + wishlistDescription + ", wishlistImage=" + wishlistImage + ", wishlistName=" + wishlistName + "]";
    }

    @Override
    public int compareTo(Wishlist o) {
        return Integer.parseInt(this.customerWishlistId.substring(2)) - Integer.parseInt(o.customerWishlistId.substring(2));
    }
}
```

#### dao10. WishlistDao
```java
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Book;
import com.bookify.model.Wishlist;
import com.bookify.util.DBConnection;

/*
 * Represents a WishlistDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class WishlistDao implements IDao<Wishlist> {

    private DBConnection dbConnection;
    private List<Wishlist> wishlists = new ArrayList<>();

    public WishlistDao() {
        super();
    }

    public WishlistDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Wishlist create(Wishlist wishlist) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_wishlist (customer_wishlist_id, customer_id, wishlist_name, wishlist_description, wishlist_image) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlist.getCustomerWishlistId());
        preparedStatement.setString(2, wishlist.getCustomerId());
        preparedStatement.setString(3, wishlist.getWishlistName());
        preparedStatement.setString(4, wishlist.getWishlistDescription());
        preparedStatement.setString(5, wishlist.getWishlistImage());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.create() result: " + result + " | " + wishlist.getCustomerWishlistId() + " inserted!");

        return result > 0 ? wishlist : null;
    }

    @Override
    public boolean update(String customerWishlistId, Wishlist wishlist) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_wishlist SET customer_id = ?, wishlist_name = ?, wishlist_description = ?, wishlist_image = ? WHERE customer_wishlist_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlist.getCustomerId());
        preparedStatement.setString(2, wishlist.getWishlistName());
        preparedStatement.setString(3, wishlist.getWishlistDescription());
        preparedStatement.setString(4, wishlist.getWishlistImage());
        preparedStatement.setString(5, customerWishlistId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("WishlistDao.update() result: " + updateResult + " | " + customerWishlistId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);

        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("WishlistDao.delete() result: " + deleteResult + " | " + customerWishlistId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public Wishlist findOne(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];

        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setCustomerWishlistId(resultSet.getString("customer_wishlist_id"));
            wishlist.setCustomerId(resultSet.getString("customer_id"));
            wishlist.setWishlistName(resultSet.getString("wishlist_name"));
            wishlist.setWishlistDescription(resultSet.getString("wishlist_description"));
            wishlist.setWishlistImage(resultSet.getString("wishlist_image"));
            return wishlist;
        }

        return null;
    }

    @Override
    public List<Wishlist> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setCustomerWishlistId(resultSet.getString("customer_wishlist_id"));
            wishlist.setCustomerId(resultSet.getString("customer_id"));
            wishlist.setWishlistName(resultSet.getString("wishlist_name"));
            wishlist.setWishlistDescription(resultSet.getString("wishlist_description"));
            wishlist.setWishlistImage(resultSet.getString("wishlist_image"));
            wishlists.add(wishlist);
        }

        return wishlists.isEmpty() ? null : wishlists;
    }

    public boolean addBookToWishlist(String customerWishlistId, Book book) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_wishlist_item (customer_wishlist_id, customer_id, book_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, book.getBookId());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.addBookToWishlist() result: " + result + " | " + customerWishlistId + " inserted!");
        
        return result > 0;
    }
    
    public boolean removeBookFromWishlist(String customerWishlistId, Book book) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        preparedStatement.setString(3, book.getBookId());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.removeBookFromWishlist() result: " + result + " | " + customerWishlistId + " deleted!");

        return result > 0;
    }
    
    public List<Book> getWishlistItems(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setBookId(resultSet.getString("book_id"));
            books.add(book);
        }
        
        return books.isEmpty() ? null : books;
    }

    public boolean clearWishlist(String customerWishlistId) throws Exception {
        String[] customerWishlistIdArray = customerWishlistId.split("-");
        String customerId = customerWishlistIdArray[0], wishlistId = customerWishlistIdArray[1];
        
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_wishlist_item WHERE customer_wishlist_id = ? AND customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, wishlistId);
        preparedStatement.setString(2, customerId);
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("WishlistDao.clearWishlist() result: " + result + " | " + customerWishlistId + " cleared!");
        
        return result > 0;
    }
}
```

Test15. WishlistDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.WishlistDao;
import com.bookify.model.Book;
import com.bookify.model.Wishlist;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the WishlistDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateWishlistDao, testUpdateWishlistDao, testFindOneWishlistDao, testDeleteWishlistDao, testFindAllWishlistDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class WishlistDaoTest {

    private static WishlistDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new WishlistDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateWishlistDao() {
        try {
            assertNotNull(dao.create(new Wishlist("wi00008", "cu00001", "Wishlist 1", "Wishlist 1 Description", "Wishlist 1 Image")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateWishlistDao() {
        try {
            assertTrue(dao.update("wi00008", new Wishlist("wi00001", "cu00001", "Anime", "Wishlist 9876 Description", "Wishlist 1 Image")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteWishlistDao() {
        try {
            assertTrue(dao.delete("cu00001-wi00008"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneWishlistDao() {
        try {
            assertNotNull(dao.findOne("cu00001-wi00008"));
            System.out.println(dao.findOne("cu00001-wi00008"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllWishlistDao() {
        try {
            assertNotNull(dao.findAll());
            dao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddBookToWishlist() {
        try {
            assertTrue(dao.addBookToWishlist("cu00001-wi00008", new Book("bo00001")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveBookFromWishlist() {
        try {
            assertTrue(dao.removeBookFromWishlist("cu00001-wi00008", new Book("bo00001")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetWishlistItems() {
        try {
            assertNotNull(dao.getWishlistItems("cu00001-wi00008"));
            dao.getWishlistItems("cu00001-wi00008").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClearWishlist() {
        try {
            assertTrue(dao.clearWishlist("cu00001-wi00008"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
- Tables 
```sql
-- Create table for storing order information
CREATE TABLE tbl_orders 
( 
    order_id VARCHAR2(10) NOT NULL, 
    customer_id VARCHAR2(10) NOT NULL,
    address_type VARCHAR2(16) NOT NULL, 
    order_date DATE, 
    shipped_date DATE,
    order_discount NUMBER NOT NULL, -- get from customer subscription status
    order_total_cost NUMBER,  -- this will be calculated 
    order_status VARCHAR2(16),
CONSTRAINT pk_order 
    PRIMARY KEY (order_id), 
CONSTRAINT ck_order_id
    CHECK (REGEXP_LIKE(order_id, 'or[0-9]{5}')),
CONSTRAINT fk_order_customer_address_customer
    FOREIGN KEY (customer_id, address_type)
    REFERENCES tbl_customer_address(customer_id, address_type)
    ON DELETE CASCADE,
CONSTRAINT ck_customer_address_type
    CHECK (address_type IN ('Home', 'Office', 'Work', 'Other')),
CONSTRAINT ck_order_discount 
    CHECK ((order_discount >= 0 
        AND order_discount <= 1)),
CONSTRAINT ck_order_total_cost 
    CHECK ((order_total_cost >= 0))
) 
/

-- Create table for storing order details
CREATE TABLE tbl_order_detail 
( 
    order_id VARCHAR2(10) NOT NULL, 
    book_id VARCHAR2(10) NOT NULL, 
    book_price NUMBER, 
    quantity NUMBER DEFAULT 1 NOT NULL, 
CONSTRAINT pk_order_detail 
    PRIMARY KEY (order_id, book_id), 
CONSTRAINT ck_book_price   
    CHECK ((book_price >= 0)), 
CONSTRAINT ck_order_detail_quantity   
    CHECK ((quantity >= 1)), 
CONSTRAINT fk_OrderDetails_Orders 
    FOREIGN KEY (order_id) 
    REFERENCES tbl_orders(order_id)
    ON DELETE CASCADE, 
CONSTRAINT fk_OrderDetails_Products 
    FOREIGN KEY (book_id) 
    REFERENCES tbl_book(book_id)
    ON DELETE CASCADE
)
/
```

#### model10. OrderDetail
```java
package com.bookify.model;

/*
 * Represents a OrderDetail class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods compareTo.
 * @throws Exception if any of the CRUD operations fail.
 */

public class OrderDetail implements Comparable<OrderDetail> {
    private String orderId;
    private String bookId;
    private float bookPrice;
    private int quantity;

    public OrderDetail() {
        super();
    }

    public OrderDetail(String orderId, String bookId, float bookPrice, int quantity) {
        super();
        this.orderId = orderId;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
        OrderDetail other = (OrderDetail) obj;
        if (bookId == null) {
            if (other.bookId != null)
                return false;
        } else if (!bookId.equals(other.bookId))
            return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetail [orderId=" + orderId + ", bookId=" + bookId + ", bookPrice=" + bookPrice + ", quantity="
                + quantity + "]";
    }

    @Override
    public int compareTo(OrderDetail o) {
        return this.orderId.compareTo(o.orderId);
    }
}
```

#### model11. Order
```java
package com.bookify.model;

import java.util.ArrayList;

/*
 * Represents a Orders class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods addOrderDetail, removeOrderDetail, getOrderAddress.
 * @throws Exception if any of the CRUD operations fail.
 */
public class Orders implements Comparable<Orders> {
    private String orderId;
    private Customer customer;
    private String addressType;
    private String orderDate;
    private String shippedDate;
    private double orderDiscount;
    private double orderTotalCost;
    private String orderStatus;

    // one order contains many orderDetails // notGoodPractice?
    private ArrayList<OrderDetail> orderDetails;

    public Orders() {
        super();
    }

    public Orders(String orderId, Customer customer, String addressType, String orderDate, String shippedDate, double orderDiscount, double orderTotalCost, String orderStatus, ArrayList<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.addressType = addressType;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.orderDiscount = orderDiscount;
        this.orderTotalCost = orderTotalCost;
        this.orderStatus = orderStatus;
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public double getOrderTotalCost() {
        return orderTotalCost;
    }

    public void setOrderTotalCost(double orderTotalCost) {
        this.orderTotalCost = orderTotalCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // order1.orderDetails.add(new OrderDetail(order1, book1, 100, 2));
    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.remove(orderDetail);
    }

    // ADDED: will get the object of CustomerAddress eg. Home, Office, etc. of a customer
    public CustomerAddress getOrderAddress() {
        return customer.getCustomerAddress(this.addressType);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
        Orders other = (Orders) obj;
        if (orderId != other.orderId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Orders [addressType=" + addressType + ", customer=" + customer + ", orderDate=" + orderDate + ", orderId=" + orderId
                + ", orderDiscount=" + orderDiscount + ", orderStatus=" + orderStatus + ", orderTotalCost=" + orderTotalCost
                + ", shippedDate=" + shippedDate + "]";
    }

    @Override
    public int compareTo(Orders o) {
        return Integer.parseInt(this.orderId.substring(2)) - Integer.parseInt(o.orderId.substring(2));
    }
}
```

#### dao11. OrderDao
```java
// crud operations of orders and orders details all functions
package com.bookify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookify.model.Customer;
import com.bookify.model.OrderDetail;
import com.bookify.model.Orders;
import com.bookify.util.DBConnection;

/*
 * Represents a OrderDao class.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods create, update, findOne, delete, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public class OrderDao implements IDao<Orders> {

    private DBConnection dbConnection;
    private List<Orders> orders = new ArrayList<>();

    public OrderDao() {
        super();
    }

    public OrderDao(DBConnection dbConnection) {
        super();
        this.dbConnection = dbConnection;
    }

    @Override
    public Orders create(Orders order) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_orders (order_id, customer_id, address_type, order_date, shipped_date, order_discount, order_total_cost, order_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, order.getOrderId());
        preparedStatement.setString(2, order.getCustomer().getCustomerId());
        preparedStatement.setString(3, order.getAddressType());
        preparedStatement.setString(4, order.getOrderDate());
        preparedStatement.setString(5, order.getShippedDate());
        preparedStatement.setDouble(6, order.getOrderDiscount());
        preparedStatement.setDouble(7, order.getOrderTotalCost());
        preparedStatement.setString(8, order.getOrderStatus());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("OrderDao.create() result: " + result + " | " + order.getOrderId() + " inserted!");

        return result > 0 ? order : null;
    }

    @Override
    public boolean update(String orderId, Orders order) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_orders SET customer_id = ?, address_type = ?, order_date = ?, shipped_date = ?, order_discount = ?, order_total_cost = ?, order_status = ? WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, order.getCustomer().getCustomerId());
        preparedStatement.setString(2, order.getAddressType());
        preparedStatement.setString(3, order.getOrderDate());
        preparedStatement.setString(4, order.getShippedDate());
        preparedStatement.setDouble(5, order.getOrderDiscount());
        preparedStatement.setDouble(6, order.getOrderTotalCost());
        preparedStatement.setString(7, order.getOrderStatus());
        preparedStatement.setString(8, orderId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("OrderDao.update() result: " + updateResult + " | " + orderId + " updated!");

        return updateResult > 0;
    }

    @Override
    public boolean delete(String orderId) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_orders WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderId);
        
        int deleteResult = preparedStatement.executeUpdate();
        if (deleteResult > 0) System.out.println("OrderDao.delete() result: " + deleteResult + " | " + orderId + " deleted!");

        return deleteResult > 0;
    }

    @Override
    public Orders findOne(String orderId) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_orders WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Orders order = new Orders();
            order.setOrderId(resultSet.getString("order_id"));
            order.setCustomer(new Customer(resultSet.getString("customer_id")));
            order.setAddressType(resultSet.getString("address_type"));
            order.setOrderDate(resultSet.getString("order_date"));
            order.setShippedDate(resultSet.getString("shipped_date"));
            order.setOrderDiscount(resultSet.getDouble("order_discount"));
            order.setOrderTotalCost(resultSet.getDouble("order_total_cost"));
            order.setOrderStatus(resultSet.getString("order_status"));
            return order;
        }

        return null;
    }

    @Override
    public List<Orders> findAll() throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_orders";
        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(sqlQuery);
        
        while (resultSet.next()) {
            Orders order = new Orders();
            order.setOrderId(resultSet.getString("order_id"));
            order.setCustomer(new Customer(resultSet.getString("customer_id")));
            order.setAddressType(resultSet.getString("address_type"));
            order.setOrderDate(resultSet.getString("order_date"));
            order.setShippedDate(resultSet.getString("shipped_date"));
            order.setOrderDiscount(resultSet.getDouble("order_discount"));
            order.setOrderTotalCost(resultSet.getDouble("order_total_cost"));
            order.setOrderStatus(resultSet.getString("order_status"));
            orders.add(order);
        }

        return orders.isEmpty() ? null : orders;
    }

    public boolean addOrderDetail(String orderId, OrderDetail orderDetail) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_order_detail (order_id, book_id, book_price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderDetail.getOrderId());
        preparedStatement.setString(2, orderDetail.getBookId());
        preparedStatement.setFloat(3, orderDetail.getBookPrice());
        preparedStatement.setInt(4, orderDetail.getQuantity());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("OrderDao.addOrderDetail() result: " + result + " | " + orderId + " inserted!");
        
        return result > 0;
    }

    public boolean removeOrderDetail(String orderId, OrderDetail orderDetail) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_order_detail WHERE order_id = ? AND book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderDetail.getOrderId());
        preparedStatement.setString(2, orderDetail.getBookId());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("OrderDao.removeOrderDetail() result: " + result + " | " + orderId + " deleted!");

        return result > 0;
    }

    public List<OrderDetail> getOrderDetails(String orderId) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "SELECT * FROM tbl_order_detail WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        List<OrderDetail> orderDetails = new ArrayList<>();
        while (resultSet.next()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(resultSet.getString("order_id"));
            orderDetail.setBookId(resultSet.getString("book_id"));
            orderDetail.setBookPrice(resultSet.getFloat("book_price"));
            orderDetail.setQuantity(resultSet.getInt("quantity"));
            orderDetails.add(orderDetail);
        }
        
        return orderDetails.isEmpty() ? null : orderDetails;
    }

    public boolean clearOrderDetails(String orderId) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "DELETE FROM tbl_order_detail WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderId);
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("OrderDao.clearOrderDetails() result: " + result + " | " + orderId + " cleared!");
        
        return result > 0;
    }

    public boolean updateOrderTotalCost(String orderId, double orderTotalCost) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_orders SET order_total_cost = ? WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setDouble(1, orderTotalCost);
        preparedStatement.setString(2, orderId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("OrderDao.updateOrderTotalCost() result: " + updateResult + " | " + orderId + " updated!");

        return updateResult > 0;
    }

    public boolean updateOrderStatus(String orderId, String orderStatus) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "UPDATE tbl_orders SET order_status = ? WHERE order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, orderStatus);
        preparedStatement.setString(2, orderId);
        
        int updateResult = preparedStatement.executeUpdate();
        if (updateResult > 0) System.out.println("OrderDao.updateOrderStatus() result: " + updateResult + " | " + orderId + " updated!");

        return updateResult > 0;
    }

    // add a method add from cart to order wher the customer class contain the shopingCart
    /*
    public class Customer implements Comparable<Customer> {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone1;
    private String customerPassword;

    Map<String, CustomerAddress> customerAddresses = new HashMap<>();

    ArrayList<ShoppingCartItem> shopingCart = new ArrayList<>(); // customer.shopingCart.add(new ShoppingCartItem(book, quantity))

    ArrayList<Wishlist> wishlists = new ArrayList<>();

    ... and other getters and setters.
    }

    public class ShoppingCartItem implements Comparable<ShoppingCartItem> {
    private String customerId;
    private Book book;
    private int quantity;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(String customerId, Book book, int quantity) {
        this.customerId = customerId;
        this.book = book;
        this.quantity = quantity;
    }
    ... other getters and setters

}


    public class CustomerAddress implements Comparable<CustomerAddress> {
    private String customerAddressId;
    private String customerId;
    private String addressType;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String landmark;
    private String phone;

    public CustomerAddress() {
        super();
    }

    public CustomerAddress(String customerAddressId, String customerId, String addressType, String addressLine1, String addressLine2, String addressLine3, String city, String state, String country, String postalCode, String landmark, String phone) {
        this.customerAddressId = customerAddressId;
        this.customerId = customerId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.landmark = landmark;
        this.phone = phone;
    }
    ...
    }


    */
    public boolean addFromCartToOrder(String orderId, Orders order) throws Exception {
        Connection connection = dbConnection.getConnection();
        final String sqlQuery = "INSERT INTO tbl_orders (order_id, customer_id, address_type, order_date, shipped_date, order_discount, order_total_cost, order_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, order.getOrderId());
        preparedStatement.setString(2, order.getCustomer().getCustomerId());
        preparedStatement.setString(3, order.getAddressType());
        preparedStatement.setString(4, order.getOrderDate());
        preparedStatement.setString(5, order.getShippedDate());
        preparedStatement.setDouble(6, order.getOrderDiscount());
        preparedStatement.setDouble(7, order.getOrderTotalCost());
        preparedStatement.setString(8, order.getOrderStatus());
        
        int result = preparedStatement.executeUpdate();
        if (result > 0) System.out.println("OrderDao.addFromCartToOrder() result: " + result + " | " + orderId + " inserted!");
        
        return result > 0;
    }
}
```

Test16. OrderDaoTest
```java
package com.bookify;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bookify.dao.OrderDao;
import com.bookify.model.OrderDetail;
import com.bookify.model.Orders;
import com.bookify.util.DBConnection;

/*
 * Represents a test class for the OrderDao.
 * 
 * @Author @Ayon-SSP
 * 
 * @methods testCreateOrderDao, testUpdateOrderDao, testFindOneOrderDao, testDeleteOrderDao, testFindAllOrderDao.
 * @throws Exception if any of the CRUD operations fail.
 */
public class OrderDaoTest {

    private static OrderDao dao;

    @BeforeClass
    public static void BeforeClass() {
        dao = new OrderDao(DBConnection.getDBConnection());
    }

    @Test
    public void testCreateOrderDao() {
        try {
            assertNotNull(dao.create(new Orders("or00008", "cu00001", "Home", "2021-09-01", "2021-09-02", 0.1, 1000, "Pending", new ArrayList<OrderDetail>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateOrderDao() {
        try {
            assertTrue(dao.update("or00008", new Orders("or00001", "cu00001", "Home", "2021-09-01", "2021-09-02", 0.1, 1000, "Pending", new ArrayList<OrderDetail>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void testDeleteOrderDao() {
        try {
            assertTrue(dao.delete("or00008"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindOneOrderDao() {
        try {
            assertNotNull(dao.findOne("or00008"));
            System.out.println(dao.findOne("or00008"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllOrderDao() {
        try {
            assertNotNull(dao.findAll());
            dao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddOrderDetail() {
        try {
            assertTrue(dao.addOrderDetail("or00008", new OrderDetail("or00008", "bo00001", 100, 2)));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testRemoveOrderDetail() {
        try {
            assertTrue(dao.removeOrderDetail("or00008", new OrderDetail("or00008", "bo00001", 100, 2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetOrderDetails() {
        try {
            assertNotNull(dao.getOrderDetails("or00008"));
            dao.getOrderDetails("or00008").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClearOrderDetails() {
        try {
            assertTrue(dao.clearOrderDetails("or00008"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testUpdateOrderTotalCost() {
        try {
            assertTrue(dao.updateOrderTotalCost("or00008", 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateOrderStatus() {
        try {
            assertTrue(dao.updateOrderStatus("or00008", "Shipped"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddFromCartToOrder() {
        try {
            assertTrue(dao.addFromCartToOrder("or00008", new Orders("or00008", "cu00001", "Home", "2021-09-01", "2021-09-02", 0.1, 1000, "Pending", new ArrayList<OrderDetail>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```