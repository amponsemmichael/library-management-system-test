package com.amponsem.librarymanagementsystem.models;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private int categoryId;
    private LocalDate publicationDate;  // Use LocalDate for date fields
    private int copiesOwned;
    private String categoryName;

    // Constructors
    public Book() {
    }

    public Book(int id, String title, int categoryId, LocalDate publicationDate, int copiesOwned, String categoryName) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.publicationDate = publicationDate;
        this.copiesOwned = copiesOwned;
        this.categoryName = categoryName;
    }

    public Book(String testTitle, int i, String date, int i1) {
    }

    public Book(String testTitle, int i, LocalDate of, int i1) {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;  // Correctly set LocalDate here
    }

    public int getCopiesOwned() {
        return copiesOwned;
    }

    public void setCopiesOwned(int copiesOwned) {
        this.copiesOwned = copiesOwned;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", publicationDate=" + publicationDate +
                ", copiesOwned=" + copiesOwned +
                '}';
    }

   public void setCategoryName(String category) {
        this.categoryName = categoryName;
    }

   public String getCategoryName() {
        return categoryName;
    }
}
