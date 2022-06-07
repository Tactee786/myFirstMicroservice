package com.tsi.omar.butt.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest{
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    void setup(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository);
    }
    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test
    public void getAActor(){
        Actor testActor = new Actor(1,"testFName", "testLName");
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Integer id = 1;
        myFirstMicroserviceApplication.getAActor(id);
        verify(actorRepository).findById(id);
    }

    @Test
    public void addActor(){
        Actor testActor = new Actor(1,"testFName","testLName");
        Actor Actual = myFirstMicroserviceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
        //System.out.println(Actual+ " :actual");
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        //System.out.println(actorArgumentCaptor.getValue()+ " :expected");
        Assertions.assertEquals(Expected,Actual,"help");
    }


}
//    @Test
//    public void getAActor(){
//        Actor testActor = new Actor("testFName", "testLName");
//        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
//        System.out.println(testActor.first_name + testActor.last_name);
//        //Optional<Actor> answ = actorRepository.findById(1);
//        Integer id = 1;
//        myFirstMicroserviceApplication.getAActor(id);
//        //System.out.println(myFirstMicroserviceApplication.getAActor(id));
//        verify(actorRepository).findById(id);
//        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        System.out.println(actorRepository);
//        System.out.println("before");
//        verify(actorRepository).save(actorArgumentCaptor.capture());
//        System.out.println("after");
//        actorArgumentCaptor.getValue();
//        System.out.println(actorArgumentCaptor.getValue());
//        Assertions.assertEquals(testActor,testActor,"help");
//        Integer id = 1;
//        myFirstMicroserviceApplication.getAActor(id);
//        verify(actorRepository).findById(id);