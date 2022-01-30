package one.digitalInovation.personAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import one.digitalInovation.personAPI.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{

}
