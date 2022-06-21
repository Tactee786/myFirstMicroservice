package com.tsi.omar.butt.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addActorStepDef {
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
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, categoryRepository, filmActorRepository, filmCategoryRepository, filmRepository, languageRepository);
    }
    int id;
    Actor testActor;
    Actor Expected;
    Actor Actual;
    @Given("I have the actor information")
    public void i_have_the_actor_information() {
        id = 1;
        testActor = new Actor("testFName", "testLName");
        testActor.setActorId(id);
    }
    @When("I input the data into the database for adding an actor")
    public void i_input_the_data_into_the_database_for_adding_an_actor() {
        setup();
        Actual = myFirstMicroserviceApplication.addActor(testActor).getBody();
    }
    @Then("I get the success return string for adding an actor")
    public void i_get_the_success_return_string_for_adding_an_actor() {
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor not added into the database");
    }
}