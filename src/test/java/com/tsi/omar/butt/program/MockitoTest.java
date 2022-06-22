package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoTest{
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private LanguageRepository languageRepository;

    @BeforeEach
    void setup(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, filmActorRepository, filmCategoryRepository, filmRepository, languageRepository);
    }

    //----------------------------
    // Actor CRUD operation Tests
    //----------------------------
    @Test//get method for all actors
    void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test//get method for an actor
    void getAActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActorId(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = myFirstMicroserviceApplication.getAActor(testActor.getActorId()).getBody();
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Could not find actor with ID: ");
    }
    @Test//post method for an actor
    void addActor(){
        Actor testActor = new Actor("testFName","testLName");
        testActor.setActorId(1);
        Actor Actual = myFirstMicroserviceApplication.addActor(testActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not added.");
    }
    @Test//put  method for an actor
    void updateActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActorId(1);
        Actor testUpdateActor = new Actor("testFNameUpdated" , "testLNameUpdated");
        testUpdateActor.setActorId(1);
        when(actorRepository.findById(testActor.getActorId())).thenReturn(Optional.of(testUpdateActor));
        Actor Actual = myFirstMicroserviceApplication.updateActor(testUpdateActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
    }
    @Test//delete method for an actor
    void deleteActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActorId(1);
        Actor testActorDelete = new Actor("testFName", "testLName");
        testActorDelete.setActorId(1);
        when(actorRepository.findById(testActorDelete.getActorId())).thenReturn(Optional.of(testActorDelete));
        doNothing().when(actorRepository).deleteById(1);
        Actor Actual = myFirstMicroserviceApplication.deleteActor(testActorDelete).getBody();
        actorRepository.deleteById(testActorDelete.getActorId());
        Actor Expected = testActorDelete;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

    //----------------------------
    // Film CRUD operation Tests
    //----------------------------
    @Test//get method for all films
    void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }
    @Test//get method for a film
    void getAFilm(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
        Film Actual = myFirstMicroserviceApplication.getAFilm(testFilm.getFilmId()).getBody();
        Film Expected = testFilm;
        Assertions.assertEquals(Expected,Actual,"Could not find Film with ID: ");
    }
    @Test//post method for a film
    void addFilm(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Film Actual = myFirstMicroserviceApplication.addFilm(testFilm).getBody();
        ArgumentCaptor<Film> actorArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(actorArgumentCaptor.capture());
        Film Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Film was not added.");
    }
    @Test//put  method for a film
    void updateFilm(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Film testUpdateFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testUpdateFilm.setFilmId(1);
        when(filmRepository.findById(testFilm.getFilmId())).thenReturn(Optional.of(testUpdateFilm));
        Film Actual = myFirstMicroserviceApplication.updateFilm(testUpdateFilm).getBody();
        ArgumentCaptor<Film> actorArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(actorArgumentCaptor.capture());
        Film Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Film was not updated.");
    }
    @Test//delete method for a film
    void deleteFilm(){
        Date testDate = new Date();
        Film testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(1);
        Film testFilmDelete = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilmDelete.setFilmId(1);
        when(filmRepository.findById(testFilmDelete.getFilmId())).thenReturn(Optional.of(testFilmDelete));
        doNothing().when(filmRepository).deleteById(1);
        Film Actual = myFirstMicroserviceApplication.deleteFilm(testFilmDelete).getBody();
        //ArgumentCaptor<Film> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        filmRepository.deleteById(testFilmDelete.getFilmId());
        Film Expected = testFilmDelete;
        Assertions.assertEquals(Expected,Actual,"Film was not deleted.");
    }

    //----------------------------
    // Category CRUD operation Tests
    //----------------------------
    @Test//get method for all categories
    void getAllCategory(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }
    @Test//get method for a category
    void getACategory(){
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategoryId(1);
        when(categoryRepository.findById(1)).thenReturn(Optional.of(testCategory));
        Category Actual = myFirstMicroserviceApplication.getACategory(testCategory.getCategoryId()).getBody();
        Category Expected = testCategory;
        Assertions.assertEquals(Expected,Actual,"Could not find Category with ID: ");
    }
    @Test//post method for a category
    void addCategory(){
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategoryId(1);
        Category Actual = myFirstMicroserviceApplication.addCategory(testCategory).getBody();
        ArgumentCaptor<Category> actorArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(actorArgumentCaptor.capture());
        Category Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not added.");
    }
    @Test//put  method for a category
    void updateCategory(){
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategoryId(1);
        Category testCategoryUpdated = new Category(1, "testCategoryUpdated");
        testCategoryUpdated.setCategoryId(1);
        when(categoryRepository.findById(testCategory.getCategoryId())).thenReturn(Optional.of(testCategoryUpdated));
        Category Actual = myFirstMicroserviceApplication.updateCategory(testCategoryUpdated).getBody();
        ArgumentCaptor<Category> actorArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(actorArgumentCaptor.capture());
        Category Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not updated.");
    }
    @Test//delete method for a category
    void deleteCategory(){
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategoryId(1);
        Category testCategoryDelete = new Category(1, "testCategory");
        testCategory.setCategoryId(1);
        when(categoryRepository.findById(testCategoryDelete.getCategoryId())).thenReturn(Optional.of(testCategoryDelete));
        doNothing().when(categoryRepository).deleteById(1);
        Category Actual = myFirstMicroserviceApplication.deleteCategory(testCategoryDelete).getBody();
        categoryRepository.deleteById(testCategoryDelete.getCategoryId());
        Category Expected = testCategoryDelete;
        Assertions.assertEquals(Expected,Actual,"Category was not deleted.");
    }

    //----------------------------
    // Language CRUD operation Tests
    //----------------------------
    @Test//get method for all languages
    void getAllLanguage(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }
    @Test//get method for a Language
    void getALanguage(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        when(languageRepository.findById(1)).thenReturn(Optional.of(testLanguage));
        Language Actual = myFirstMicroserviceApplication.getLanguageName(testLanguage.getLanguageId()).getBody();
        Language Expected = testLanguage;
        Assertions.assertEquals(Expected,Actual,"Could not find Language with ID: ");
    }
    @Test//post method for a Language
    void addLanguage(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Language Actual = myFirstMicroserviceApplication.addLanguage(testLanguage).getBody();
        ArgumentCaptor<Language> actorArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(actorArgumentCaptor.capture());
        Language Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Language was not added.");
    }
    @Test//put  method for a Language
    void updateLanguage(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Language testLanguageUpdated = new Language("testLanguageUpdated");
        testLanguageUpdated.setLanguageId(1);
        when(languageRepository.findById(testLanguage.getLanguageId())).thenReturn(Optional.of(testLanguageUpdated));
        Language Actual = myFirstMicroserviceApplication.updateLanguage(testLanguageUpdated).getBody();
        ArgumentCaptor<Language> actorArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(actorArgumentCaptor.capture());
        Language Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Language was not updated.");
    }
    @Test//delete method for a Language
    void deleteLanguage(){
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguageId(1);
        Language testCategoryDelete = new Language("testLanguage");
        testCategoryDelete.setLanguageId(1);
        when(languageRepository.findById(testCategoryDelete.getLanguageId())).thenReturn(Optional.of(testCategoryDelete));
        doNothing().when(languageRepository).deleteById(1);
        Language Actual = myFirstMicroserviceApplication.deleteLanguage(testCategoryDelete).getBody();
        languageRepository.deleteById(testCategoryDelete.getLanguageId());
        Language Expected = testCategoryDelete;
        Assertions.assertEquals(Expected,Actual,"Language was not deleted.");
    }
}