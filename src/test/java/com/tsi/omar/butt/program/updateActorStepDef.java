package com.tsi.omar.butt.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class updateActorStepDef {
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
        actorRepository =mock(ActorRepository.class);
        categoryRepository =mock(CategoryRepository.class);
        filmActorRepository =mock(FilmActorRepository.class);
        filmCategoryRepository =mock(FilmCategoryRepository.class);
        filmRepository =mock(FilmRepository.class);
        languageRepository =mock(LanguageRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, filmActorRepository, filmCategoryRepository, filmRepository, languageRepository);
    }
    int id;
    Actor testActor;
    Actor updatedActor;
    Actor Expected;
    Actor Actual;

    @Given("I have the actor information and id number")
    public void i_have_the_actor_information_and_id_number() {
        id = 1;
        testActor = new Actor("testFName", "testLName");
        testActor.setActorId(id);
        updatedActor = new Actor("testFNameUpdated", "testLNameUpdated");
        updatedActor.setActorId(id);
    }
    @When("I input the data into the database for update")
    public void i_input_the_data_into_the_database_for_update() {
        setup();
        when(actorRepository.findById(1)).thenReturn(Optional.of(updatedActor));
        String rFName = "replacedFName";
        String rLName = "replacedLName";
        Actual = myFirstMicroserviceApplication.updateActor(updatedActor).getBody();
    }
    @Then("I get the success return string for update")
    public void i_get_the_success_return_string_for_update() {
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor not added into the database");
    }
}