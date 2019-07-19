package de.anna.springboot.model;

import de.anna.springboot.model.dto.PersonDTO;
import de.anna.springboot.model.entity.Person;
import de.anna.springboot.model.form.PersonForm;

public class PersonAssembler {

    public PersonDTO mapPersonToPersonDTO(Person person){

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setNachname(person.getNachname());

        return personDTO;
    }


    public Person mapPersonDTOToPerson(PersonDTO personDTO){

        Person person = new Person();

        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setNachname(personDTO.getNachname());

        return person;
    }



    public PersonDTO mapPersonFormToPersonDTO(PersonForm personForm){

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(personForm.getId());
        personDTO.setName(personForm.getName());
        personDTO.setNachname(personForm.getNachname());

        return personDTO;
    }

    public PersonForm mapPersonDTOToPersonForm(PersonDTO personDTO){

        PersonForm personForm = new PersonForm();

        personForm.setId(personDTO.getId());
        personForm.setName(personDTO.getName());
        personForm.setNachname(personDTO.getNachname());

        return personForm;
    }
}
