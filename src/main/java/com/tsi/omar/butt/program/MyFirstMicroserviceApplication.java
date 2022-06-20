package com.tsi.omar.butt.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		Actor updateActor = actorRepository.findById(putActor.getActor_id()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with the given ID. "));
		updateActor.first_name = putActor.first_name;
		updateActor.last_name = putActor.last_name;
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_A_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestBody Actor delActor){
		Actor deleteActor = actorRepository.findById(delActor.getActor_id()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with given ID"));
		actorRepository.deleteById(deleteActor.getActor_id());
		return ResponseEntity.ok(deleteActor);
	}


}