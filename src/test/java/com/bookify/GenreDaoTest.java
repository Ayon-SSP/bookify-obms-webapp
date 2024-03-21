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
