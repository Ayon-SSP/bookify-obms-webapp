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
