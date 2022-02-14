package one.digitalInovation.personAPI.controller;

import one.digitalInovation.personAPI.dto.request.PersonDTO;
import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Person;
import one.digitalInovation.personAPI.exception.DepartmentNotFoundException;
import one.digitalInovation.personAPI.exception.PersonNotFoundException;
import one.digitalInovation.personAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.regex.PatternSyntaxException;

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
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) throws DepartmentNotFoundException {
		return personService.createPerson(personDTO);
	}

	/*
	@GetMapping("/get")
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	 */

	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

	@GetMapping("/teste")
	public String getBook() {
		return "API RODANDO";
	}

	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		return personService.updateById(id, personDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
