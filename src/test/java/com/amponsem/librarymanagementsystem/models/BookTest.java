package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class BookTest {
@Test
    public void Book() {

     Book book = new Book(5, "Born To win", 45, LocalDate.of(2020,10,4), 2500,"Religious");
     assertEquals(5,book.getId());
     assertEquals("Born To win", book.getTitle());
     assertEquals(45,book.getCategoryId());
     assertEquals("2020-10-04", book.getPublicationDate().toString());
     assertEquals(2500 , book.getCopiesOwned());
     assertEquals("Religious", book.getCategoryName());
    }

    @Test
    void getId()
    {

    }

    @Test
    void testGetId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getCategoryId() {
    }

    @Test
    void setCategoryId() {
    }

    @Test
    void getPublicationDate() {
    }

    @Test
    void setPublicationDate() {
    }

    @Test
    void getCopiesOwned() {
    }

    @Test
    void setCopiesOwned() {
    }

    @Test
    void testToString() {
    }

    @Test
    void setCategoryName() {
    }

    @Test
    void getCategoryName() {
    }
}