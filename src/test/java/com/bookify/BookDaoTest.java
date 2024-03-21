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
