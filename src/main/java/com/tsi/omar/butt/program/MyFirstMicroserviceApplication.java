package com.tsi.omar.butt.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class MyFirstMicroserviceApplication {
	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository){
		this.actorRepository =actorRepository;
	}

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

	@PostMapping("/Post_A_Actor")//add an actor to the actor table in the database
	public ResponseEntity<Actor> addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return ResponseEntity.ok(addActor);
	}

	@PutMapping("/Put_A_Actor")//update an actor within the actor table with the given id
	public ResponseEntity<Actor> updateActor(@RequestParam Integer id, String first_name, String last_name){
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with id: " + id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_A_Actor")//delete an actor from the actor table with the given id
	public ResponseEntity<Actor> deleteActor(@RequestParam Integer id){
		Actor deleteActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with id: " + id));
		actorRepository.deleteById(id);
		return ResponseEntity.ok(deleteActor);
	}


}

//	@DeleteMapping("/Delete_By_Id_1")
//	public @ResponseBody
//	void deleteById1(@RequestParam(name="id") int id){
//		actorRepository.deleteById(id);
//	}
//	@GetMapping("/Get_A_Actor_1")
//	public @ResponseBody
//	Optional<Actor>getAActor(@RequestParam(name="id", name="first_name", name="last_name") int id, String first_name, String last_name){
//		return  actorRepository.findById(id);
//	}
//	@PostMapping("/Post_A_Actor_1")
//	public @ResponseBody void addActor1(@RequestParam String first_name, String last_name){
//		Actor addActor = new Actor(first_name,last_name);
//		actorRepository.save(addActor);
//	}