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

	@PostMapping("/Post_A_Actor")
	public @ResponseBody ResponseEntity<Actor> addActor(@RequestBody Actor addActor){
		actorRepository.save(addActor);
		return ResponseEntity.ok(addActor);
	}

	@PutMapping("Put_A_Actor")
	public @ResponseBody ResponseEntity<Actor> updateActor(@RequestBody Actor putActor){
		Actor updateActor = actorRepository.findById(putActor.getActor_id()).orElseThrow(() -> new ResourceNotFoundException("Actor does not exit with the given ID. "));
		updateActor = putActor;
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