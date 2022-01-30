package one.digitalInovation.personAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import one.digitalInovation.personAPI.dto.rsponse.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Person;


@SpringBootApplication
public class PersonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApiApplication.class, args);

		
	}
}
