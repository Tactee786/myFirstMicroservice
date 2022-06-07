package com.tsi.omar.butt.program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
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
}
