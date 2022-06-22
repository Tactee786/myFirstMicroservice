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
        //ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepository.deleteById(testActorDelete.getActorId());
        Actor Expected = testActorDelete;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

    //----------------------------
    // Film CRUD operation Tests
    //----------------------------
    @Test//get method for a film
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
        Assertions.assertEquals(Expected,Actual,"Could not find film with ID: ");
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
    @Test//put  method for an actor
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
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
    }
    @Test//delete method for an actor
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
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }
}