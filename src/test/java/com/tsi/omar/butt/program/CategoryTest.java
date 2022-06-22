package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    void testGetCategoryId(){
        Category testLanguage = new Category(1,"testCategory");
        testLanguage.setCategoryId(1);
        Assertions.assertEquals(1, testLanguage.getCategoryId(), "id not there.");
    }
    @Test
    void testSetCategoryId(){
        Category testLanguage = new Category(1,"testCategory");
        testLanguage.setCategoryId(1);
        Assertions.assertEquals(1, testLanguage.getCategoryId(), "id not set.");
    }
    @Test
    void testGetName(){
        Category testLanguage = new Category(1,"testCategory");
        testLanguage.setCategoryId(1);
        Assertions.assertEquals("testCategory", testLanguage.getName(), "name not there.");
    }
    @Test
    void testSetName(){
        Category testLanguage = new Category();
        testLanguage.setName("testCategoryName");
        testLanguage.setCategoryId(1);
        Assertions.assertEquals("testCategoryName", testLanguage.getName(), "name not set.");
    }
}
