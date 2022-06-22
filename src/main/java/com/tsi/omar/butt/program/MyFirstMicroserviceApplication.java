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

	//------------------------
	// Actor CRUD operations
	//------------------------
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

	//------------------------
	// Film CRUD operations
	//------------------------
	@GetMapping("/Get_All_Films")
	public @ResponseBody Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("Get_Film_By_Id")
	public ResponseEntity<Film>getAFilm(@RequestParam Integer id){
		Film film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film does not exist with ID: " +id));
		return ResponseEntity.ok(film);
	}

	@PostMapping("Post_A_Film")
	public @ResponseBody ResponseEntity<Film> addFilm(@RequestBody Film addFilm){
		filmRepository.save(addFilm);
		return ResponseEntity.ok(addFilm);
	}

	@PutMapping("Put_A_Film")
	public @ResponseBody ResponseEntity<Film> updateFilm(@RequestBody Film putFilm){
		Film updateFilm = filmRepository.findById(putFilm.getFilmId()).orElseThrow(() -> new ResourceNotFoundException("Film does not exit with the given ID. "));
		updateFilm.title = putFilm.title;
		updateFilm.description = putFilm.description;
		updateFilm.releaseYear = putFilm.releaseYear;
		updateFilm.languageId = putFilm.languageId;
		updateFilm.length = putFilm.length;
		updateFilm.rating = putFilm.rating;
		filmRepository.save(updateFilm);
		return ResponseEntity.ok(updateFilm);
	}

	@DeleteMapping("/Delete_A_Film")
	public ResponseEntity<Film> deleteFilm(@RequestBody Film delFilm){
		Film deleteFilm = filmRepository.findById(delFilm.getFilmId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		filmRepository.deleteById(deleteFilm.getFilmId());
		return ResponseEntity.ok(deleteFilm);
	}

	//------------------------
	// Category CRUD operation
	//------------------------
	@GetMapping("Get_All_Category")
	public @ResponseBody Iterable<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("Get_Category_By_Id")
	public ResponseEntity<Category>getACategory(@RequestParam Integer id){
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category does not exist with ID: " +id));
		return ResponseEntity.ok(category);
	}

	@PostMapping("Post_A_Category")
	public @ResponseBody ResponseEntity<Category> addCategory(@RequestBody Category addCategory){
		categoryRepository.save(addCategory);
		return ResponseEntity.ok(addCategory);
	}

	@PutMapping("Put_A_Category")
	public @ResponseBody ResponseEntity<Category> updateCategory(@RequestBody Category putCategory){
		Category updateCategory = categoryRepository.findById(putCategory.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category does not exit with the given ID. "));
		updateCategory.name = putCategory.name;
		categoryRepository.save(updateCategory);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/Delete_A_Category")
	public ResponseEntity<Category> deleteCategory(@RequestBody Category delCategory){
		Category deleteCategory = categoryRepository.findById(delCategory.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		categoryRepository.deleteById(deleteCategory.getCategoryId());
		return ResponseEntity.ok(deleteCategory);
	}

	//------------------------
	// Language CRUD operation
	//------------------------
	@GetMapping("Get_All_Language")
	public @ResponseBody Iterable<Language> getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("Get_Language")
	public ResponseEntity<Language> getLanguageName(@RequestParam int id){
		Language language = languageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language does not exist with ID: " +id));
		return ResponseEntity.ok(language);
	}

	@PostMapping("Post_A_Language")
	public @ResponseBody ResponseEntity<Language> addLanguage(@RequestBody Language addLanguage){
		languageRepository.save(addLanguage);
		return ResponseEntity.ok(addLanguage);
	}

	@PutMapping("Put_A_Language")
	public @ResponseBody ResponseEntity<Language> updateLanguage(@RequestBody Language putLanguage){
		Language updateLanguage = languageRepository.findById(putLanguage.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Category does not exit with the given ID. "));
		updateLanguage.name = putLanguage.name;
		languageRepository.save(updateLanguage);
		return ResponseEntity.ok(updateLanguage);
	}

	@DeleteMapping("/Delete_A_Language")
	public ResponseEntity<Language> deleteLanguage(@RequestBody Language delLanguage){
		Language deleteLanguage = languageRepository.findById(delLanguage.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		languageRepository.deleteById(deleteLanguage.getLanguageId());
		return ResponseEntity.ok(deleteLanguage);
	}

	//------------------------
	// FilmActor CRUD operation
	//------------------------
	@GetMapping("Get_All_FilmActor")
	public @ResponseBody Iterable<FilmActor> getAllFilmActors() {
		return filmActorRepository.findAll();
	}

	@GetMapping("Get_A_FilmActor")
	public ResponseEntity<FilmActor> getFilmActor(@RequestParam int id){
		FilmActor filmActor = filmActorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FilmActor does not exist with ID: " +id));
		return ResponseEntity.ok(filmActor);
	}

	@PostMapping("Post_A_FilmActor")
	public @ResponseBody ResponseEntity<FilmActor> addFilmActor(@RequestBody FilmActor addFilmActor){
		filmActorRepository.save(addFilmActor);
		return ResponseEntity.ok(addFilmActor);
	}

	@PutMapping("Put_A_FilmActor")
	public @ResponseBody ResponseEntity<FilmActor> updateFilmActor(@RequestBody FilmActor putFilmActor){
		FilmActor updateFilmActor = filmActorRepository.findById(putFilmActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Category does not exit with the given ID. "));
		updateFilmActor.setActorId(putFilmActor.getActorId());
		updateFilmActor.setFilmId(putFilmActor.getFilmId());
		filmActorRepository.save(updateFilmActor);
		return ResponseEntity.ok(updateFilmActor);
	}

	@DeleteMapping("/Delete_A_FilmActor")
	public ResponseEntity<FilmActor> deleteFilmActor(@RequestBody FilmActor delFilmActor){
		FilmActor deleteFilmActor = filmActorRepository.findById(delFilmActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		filmActorRepository.deleteById(deleteFilmActor.getActorId());
		return ResponseEntity.ok(deleteFilmActor);
	}

	//------------------------
	// FilmCategory CRUD operation
	//------------------------
	@GetMapping("Get_All_FilmCategory")
	public @ResponseBody Iterable<FilmCategory> getAllFilmCategories(){
		return filmCategoryRepository.findAll();
	}

	@GetMapping("Get_A_FilmCategory")
	public ResponseEntity<FilmCategory> getFilmCategory(@RequestParam int id){
		FilmCategory FilmCategory = filmCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FilmCategory does not exist with ID: " +id));
		return ResponseEntity.ok(FilmCategory);
	}

	@PostMapping("Post_A_FilmCategory")
	public @ResponseBody ResponseEntity<FilmCategory> addFilmCategory(@RequestBody FilmCategory addFilmCategory){
		filmCategoryRepository.save(addFilmCategory);
		return ResponseEntity.ok(addFilmCategory);
	}

	@PutMapping("Put_A_FilmCategory")
	public @ResponseBody ResponseEntity<FilmCategory> updateFilmCategory(@RequestBody FilmCategory putFilmCategory){
		FilmCategory updateFilmCategory = filmCategoryRepository.findById(putFilmCategory.getFilmId()).orElseThrow(() -> new ResourceNotFoundException("Category does not exit with the given ID. "));
		updateFilmCategory.setCategoryId(putFilmCategory.getCategoryId());
		updateFilmCategory.setFilmId(putFilmCategory.getFilmId());
		filmCategoryRepository.save(updateFilmCategory);
		return ResponseEntity.ok(updateFilmCategory);
	}

	@DeleteMapping("/Delete_A_FilmCategory")
	public ResponseEntity<FilmCategory> deleteFilmCategory(@RequestBody FilmCategory delFilmCategory){
		FilmCategory deleteFilmCategory = filmCategoryRepository.findById(delFilmCategory.getFilmId()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		filmCategoryRepository.deleteById(deleteFilmCategory.getFilmId());
		return ResponseEntity.ok(deleteFilmCategory);
	}

	// Additional Mappings

	@GetMapping("Get_Films_By_Keyword")
	public Iterable<Film> getFilmsByKeyword(@RequestParam String keyword){
		keyword = "%" + keyword + "%";
		return filmRepository.findByTitleLike(keyword);
	}


	@GetMapping("Get_Film_By_Category")
	public Iterable<Film> getFilmByCategory(@RequestParam String name){

//		Category catIdObj = categoryRepository.findByName(name);
//		int catIdInt = catIdObj.getCategoryId();
//		FilmCategory filmsFrom = FilmCategoryRepository.findByCategoryId(catIdInt);
//		Iterable<FilmCategory> filmCatIdObj = filmCategoryRepository.findByCategoryId(catIdInt);
//		int test123 = filmCatIdObj.
		return null;
	}

}