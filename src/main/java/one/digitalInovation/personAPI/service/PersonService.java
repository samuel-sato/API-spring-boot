package one.digitalInovation.personAPI.service;

import one.digitalInovation.personAPI.dto.request.PersonDTO;
import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Person;
import one.digitalInovation.personAPI.mapper.PersonMapper;
import one.digitalInovation.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+ savedPerson.getId())
                .build();



    }
}
