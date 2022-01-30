package one.digitalInovation.personAPI.controller;

import one.digitalInovation.personAPI.dto.rsponse.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Person;
import one.digitalInovation.personAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}

	/*
	@GetMapping("/get")
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	 */

	@GetMapping("/teste")
	public String getBook() {
		return "API RODANDO";
	}
}
