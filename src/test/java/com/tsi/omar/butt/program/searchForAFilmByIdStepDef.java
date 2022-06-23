package com.tsi.omar.butt.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class searchForAFilmByIdStepDef {

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
    Film testFilm;
    Film Expected;
    Film Actual;
    Date testDate = new Date();


    @Given("I have the id of the film i want to watch")
    public void i_have_the_id_of_the_film_i_want_to_watch() {
        id = 1;
        testFilm = new Film("testTitle", "testDescription", testDate , "1",  69, "18");
        testFilm.setFilmId(id);
    }
    @When("I input the id into the search bar")
    public void i_input_the_id_into_the_search_bar() {
        setup();
        when(filmRepository.findById(id)).thenReturn(Optional.of(testFilm));
        Actual = myFirstMicroserviceApplication.getAFilm(testFilm.getFilmId()).getBody();
    }
    @Then("I get the relevant information for the film i want to watch")
    public void i_get_the_relevant_information_for_the_film_i_want_to_watch() {
        Expected = testFilm;
        Assertions.assertEquals(Expected,Actual,"Actor not added into the database");
    }
}
