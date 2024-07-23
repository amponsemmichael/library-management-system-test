package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {

    @Test
    public void testAuthorConstructorAndGetters() {
        Author author = new Author(1, "John", "Doe");

        assertEquals(1, author.getId());
        assertEquals("John", author.getFirstName());
        assertEquals("Doe", author.getLastName());
    }

    @Test
    public void testSetId() {
        Author author = new Author(1, "John", "Doe");
        author.setId(2);

        assertEquals(2, author.getId());
    }

    @Test
    public void testSetFirstName() {
        Author author = new Author(1, "John", "Doe");
        author.setFirstName("Jane");

        assertEquals("Jane", author.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Author author = new Author(1, "John", "Doe");
        author.setLastName("Smith");

        assertEquals("Smith", author.getLastName());
    }
}
