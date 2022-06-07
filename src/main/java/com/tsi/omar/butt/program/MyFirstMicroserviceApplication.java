package com.tsi.omar.butt.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	@GetMapping("/Get_All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return  actorRepository.findAll();
	}

	@GetMapping("/Get_A_Actor")
	public @ResponseBody
	Optional<Actor>getAActors(@RequestParam(name="id") int id){
		return  actorRepository.findById(id);
	}

	@DeleteMapping("/Delete_By_Id")
	public @ResponseBody
	void deleteById(@RequestParam(name="id") int id){
		actorRepository.deleteById(id);
	}

}
