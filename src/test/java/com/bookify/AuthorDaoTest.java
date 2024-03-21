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
