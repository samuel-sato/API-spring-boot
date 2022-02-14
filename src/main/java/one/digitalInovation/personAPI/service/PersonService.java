package one.digitalInovation.personAPI.service;

import one.digitalInovation.personAPI.dto.request.PersonDTO;
import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Department;
import one.digitalInovation.personAPI.entity.Person;
import one.digitalInovation.personAPI.exception.DepartmentNotFoundException;
import one.digitalInovation.personAPI.exception.PersonNotFoundException;
import one.digitalInovation.personAPI.mapper.PersonMapper;
import one.digitalInovation.personAPI.repository.DepartmentRepository;
import one.digitalInovation.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private DepartmentService departmentService;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository, DepartmentService departmentService) {
        this.personRepository = personRepository;
        this.departmentService = departmentService;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) throws DepartmentNotFoundException {

        //valid if Department exist;
        if(personDTO.getDepartmentID() != 0){
            departmentService.verifyIfExistsDepartment(personDTO.getDepartmentID());
        }


        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO findById(Long id ) throws PersonNotFoundException {
        //Optional<Person> optionPerson =  personRepository.findById(id);
        Person person = verifyIfExistsPerson(id);

         return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExistsPerson(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExistsPerson(id);
        Person personToUpdate = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);

        return MessageResponseDTO
                .builder()
                .message("Updated person with ID "+ savedPerson.getId())
                .build();
    }

    private Person verifyIfExistsPerson(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }


}
