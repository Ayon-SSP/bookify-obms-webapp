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
