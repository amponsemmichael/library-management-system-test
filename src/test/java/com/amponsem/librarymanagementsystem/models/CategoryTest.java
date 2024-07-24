package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    public void testGetAndSetId() {
        Category category = new Category();
        category.setId(1);

        assertEquals(1, category.getId());
    }

    @Test
    public void testGetAndSetCategoryName() {
        Category category = new Category();
        category.setCategoryName("Fiction");

        assertEquals("Fiction", category.getCategoryName());
    }
}
