package de.anna.springboot.service;

import de.anna.springboot.model.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    void save(PersonDTO personDTO);

    List<PersonDTO> findAll();

    PersonDTO findPersonById(Long id);

    void deletePersonById(Long id);

}
