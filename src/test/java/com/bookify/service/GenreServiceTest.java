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
        genreService = new GenreService("ge00001");
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
