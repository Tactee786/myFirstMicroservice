package com.tsi.omar.butt.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin(origins = "*")
public class MyFirstMicroserviceApplication {
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmActorRepository filmActorRepository;
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private LanguageRepository languageRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, CategoryRepository categoryRepository, FilmActorRepository filmActorRepository, FilmCategoryRepository filmCategoryRepository, FilmRepository filmRepository, LanguageRepository languageRepository){
		this.actorRepository =actorRepository;
		this.categoryRepository =categoryRepository;
		this.filmActorRepository =filmActorRepository;
		this.filmCategoryRepository =filmCategoryRepository;
		this.filmRepository =filmRepository;
		this.languageRepository =languageRepository;
	}

	// Actor CRUD operations
	@GetMapping("/Get_All_Actors")//get all actors within the actor table
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return  actorRepository.findAll();
	}

	@GetMapping("/Get_A_Actor")//get an actor from actor table with id given
	public ResponseEntity<Actor>getAActor(@RequestParam Integer id){
		Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " +id));
		return ResponseEntity.ok(actor);
	}

	@PostMapping("/Post_A_Actor")
	public @ResponseBody ResponseEntity<Actor> addActor(@RequestBody Actor addActor){
		actorRepository.save(addActor);
		return ResponseEntity.ok(addActor);
	}

	@PutMapping("Put_A_Actor")
	public @ResponseBody ResponseEntity<Actor> updateActor(@RequestBody Actor putActor){
		Actor updateActor = actorRepository.findById(putActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with the given ID. "));
		updateActor.firstName = putActor.firstName;
		updateActor.lastName = putActor.lastName;
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_A_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestBody Actor delActor){
		Actor deleteActor = actorRepository.findById(delActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		actorRepository.deleteById(deleteActor.getActorId());
		return ResponseEntity.ok(deleteActor);
	}

	// Film CRUD operations
	@GetMapping("/Get_All_Films")
	public @ResponseBody Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("Get_All_FilmActor")
	public @ResponseBody Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepository.findAll();
	}

	@GetMapping("Get_All_FilmCategory")
	public @ResponseBody Iterable<FilmCategory> getAllFilmCategories(){
		return filmCategoryRepository.findAll();
	}

	@GetMapping("Get_All_Category")
	public @ResponseBody Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("Get_Films_By_Keyword")
	public Iterable<Film> getFilmsByKeyword(@RequestParam String keyword){
		keyword = "%" + keyword + "%";
		return filmRepository.findByTitleLike(keyword);
	}

	@GetMapping("Get_Film_By_Id")
	public ResponseEntity<Film>getAFilm(@RequestParam Integer id){
		Film film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " +id));
		return ResponseEntity.ok(film);
	}

	@GetMapping("Get_Language")
	public ResponseEntity<Language> getLanguageName(@RequestParam int id){
		Language language = languageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with ID: " +id));
		return ResponseEntity.ok(language);
	}

	@GetMapping("Get_Films_By_Category")
	public Iterable<Film> getFilmsByCategory(@RequestParam String name){

//		Category catIdObj = categoryRepository.findByName(name);
//		int catIdInt = catIdObj.getCategoryId();
//		FilmCategory filmsFrom = FilmCategoryRepository.findByCategoryId(catIdInt);
//		Iterable<FilmCategory> filmCatIdObj = filmCategoryRepository.findByCategoryId(catIdInt);
//		int test123 = filmCatIdObj.
		return null;
	}

}