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
