package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class FilmTest {

    @Test
    void testGetFilmId(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(1, testFilm.getFilmId(), "id not there.");
    }
    @Test
    void testSetFilmId(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(1, testFilm.getFilmId(), "id not set.");
    }
    @Test
    void testGetFilmTitle(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("testTitle", testFilm.getTitle(), "title not there.");
    }
    @Test
    void testSetFilmTitle(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        testFilm.setTitle("testTitleReplaced");
        Assertions.assertEquals("testTitleReplaced", testFilm.getTitle(), "title not set.");
    }
    @Test
    void testGetFilmDescription(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("testDescription", testFilm.getDescription(), "description not there.");
    }
    @Test
    void testSetFilmDescription(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        testFilm.setDescription("testDescriptionReplaced");
        Assertions.assertEquals("testDescriptionReplaced", testFilm.getDescription(), "description not set.");
    }
    @Test
    void testGetFilmReleaseYear(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(testDate, testFilm.getReleaseYear(), "release year not there.");
    }
    @Test
    void testSetFilmReleaseYear(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Date testDateUpdate = new Date();
        testFilm.setReleaseYear(testDateUpdate);
        Assertions.assertEquals(testDateUpdate, testFilm.getReleaseYear(), "release year not set.");
    }
    @Test
    void testGetFilmLanguageId(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("1", testFilm.getLanguageId(), "language year not there.");
    }
    @Test
    void testSetFilmLanguageId(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        testFilm.setLanguageId("2");
        Assertions.assertEquals("2", testFilm.getLanguageId(), "language year not set.");
    }
    @Test
    void testGetFilmLength(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(69, testFilm.getLength(), "length not there.");
    }
    @Test
    void testSetFilmLength(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        testFilm.setLength(420);
        Assertions.assertEquals(420, testFilm.getLength(), "length not set.");
    }
    @Test
    void testGetFilmRating(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("18", testFilm.getRating(), "rating not there.");
    }
    @Test
    void testSetFilmRating(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        testFilm.setRating("21");
        Assertions.assertEquals("21", testFilm.getRating(), "rating not set.");
    }
}
