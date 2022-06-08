package com.tsi.omar.butt.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.Optional;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class lookUpActorStepDef {
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @BeforeEach
    void setup(){
        actorRepository =mock(ActorRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository);
    }
    int id;
    Actor testActor;
    Actor Expected;
    Actor Actual;
    @Given("I have the actors id number")
    public void i_have_the_actors_id_number() {
        id = 1;
        testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(id);
    }
    @When("I input the id into the search")
    public void i_input_the_id_into_the_search() {
        setup();
        when(actorRepository.findById(id)).thenReturn(Optional.of(testActor));
        Actual = myFirstMicroserviceApplication.getAActor(testActor.getActor_id()).getBody();
    }
    @Then("I get the string with the actors information")
    public void i_get_the_string_with_the_actors_information() {
        Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Could not find actor with ID: ");
    }
}