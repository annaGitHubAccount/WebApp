package de.anna.springboot.service;

import de.anna.springboot.model.PersonAssembler;
import de.anna.springboot.model.dto.PersonDTO;
import de.anna.springboot.model.entity.Person;
import de.anna.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    private PersonAssembler personAssembler = new PersonAssembler();

    @Override
    @Transactional
    public void save(PersonDTO personDTO) {

        Person person = personAssembler.mapPersonDTOToPerson(personDTO);
        personRepository.save(person);
    }

    @Override
    @Transactional
    public List<PersonDTO> findAll() {

        List<PersonDTO> personDTOList = new ArrayList<>();

        ArrayList<Person> personList = (ArrayList<Person>) personRepository.findAll();

        for (Person person : personList) {
            PersonDTO personDTO = personAssembler.mapPersonToPersonDTO(person);
            personDTOList.add(personDTO);
        }

        return personDTOList;
    }

    @Override
    @Transactional
    public PersonDTO findPersonById(Long id) {

        Optional<Person> personByID = personRepository.findById(id);

        PersonDTO personDTO = new PersonDTO();
        if(personByID.isPresent()) {
            personDTO = personAssembler.mapPersonToPersonDTO(personByID.get());
        }

        return personDTO;
    }

    @Override
    @Transactional
    public void deletePersonById(Long id) {

        Optional<Person> personById = personRepository.findById(id);

        if(personById.isPresent()){
            personRepository.delete(personById.get());
        }
    }


}
