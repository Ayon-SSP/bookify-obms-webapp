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
