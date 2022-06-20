package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Test//get method for all actors
    void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test//get method for an actor
    void getAActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = myFirstMicroserviceApplication.getAActor(testActor.getActor_id()).getBody();
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Could not find actor with ID: ");
    }

    @Test//post method for an actor
    void addActor(){
        Actor testActor = new Actor("testFName","testLName");
        testActor.setActor_id(1);
        Actor Actual = myFirstMicroserviceApplication.addActor(testActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not added.");
    }

    @Test//put  method for an actor
    void updateActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Actor testUpdateActor = new Actor("testFNameUpdated" , "testLNameUpdated");
        testUpdateActor.setActor_id(1);
        when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testUpdateActor));
        Actor Actual = myFirstMicroserviceApplication.updateActor(testUpdateActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
    }

    @Test//delete method for an actor
    void deleteActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Actor testActorDelete = new Actor("testFName", "testLName");
        testActorDelete.setActor_id(1);
        when(actorRepository.findById(testActorDelete.getActor_id())).thenReturn(Optional.of(testActorDelete));
        doNothing().when(actorRepository).deleteById(1);
        Actor Actual = myFirstMicroserviceApplication.deleteActor(testActorDelete).getBody();
        //ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepository.deleteById(testActorDelete.getActor_id());
        Actor Expected = testActorDelete;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

}