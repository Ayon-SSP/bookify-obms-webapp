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
