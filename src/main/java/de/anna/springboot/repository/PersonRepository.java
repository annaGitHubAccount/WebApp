package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Person;
import org.springframework.data.repository.CrudRepository;

// nie moge tu pisac metody: void save(PersonDTO person); bo CrudRepository posiada juz taka metode. Jak to zrobie, to nie zaladuje sie spring context i dostane Exception
// tutaj zawieram tylko te metody, ktorych nie ma w CrudRepository.

public interface PersonRepository extends CrudRepository<Person, Long> {

}
