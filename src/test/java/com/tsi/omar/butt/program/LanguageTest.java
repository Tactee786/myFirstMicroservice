package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageTest {
    @Test
    void testGetLanguageId(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Assertions.assertEquals(1, testLanguage.getLanguageId(), "id not there.");
    }
    @Test
    void testSetLanguageId(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Assertions.assertEquals(1, testLanguage.getLanguageId(), "id not set.");
    }
    @Test
    void testGetLanguageName(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Assertions.assertEquals("testLanguage", testLanguage.getName(), "name not there.");
    }
    @Test
    void testSetLanguageName(){
        Language testLanguage = new Language();
        testLanguage.setName("testLanguageName");
        testLanguage.setLanguageId(1);
        Assertions.assertEquals("testLanguageName", testLanguage.getName(), "name not set.");
    }

}

