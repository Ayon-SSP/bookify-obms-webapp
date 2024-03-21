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
