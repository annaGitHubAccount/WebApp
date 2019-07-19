package de.anna.springboot.controller;

import de.anna.springboot.webantwort.PersonListServiceAntwort;
import de.anna.springboot.webantwort.PersonServiceAntwort;
import de.anna.springboot.model.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class PersonWSController {

    @Autowired
  //  private PersonService personService;


    @PostMapping("/addperson")
    public PersonServiceAntwort addPersonen(@RequestBody PersonDTO personDTO) {

        try {
     //       personService.save(personDTO);

        } catch (Exception exception) {
            return new PersonServiceAntwort(false, exception.getMessage());
        }

        return new PersonServiceAntwort(true, "");
    }


    @GetMapping("/findpersonen")
    public PersonListServiceAntwort findPersonen() {

        List<PersonDTO> personDTOList = new ArrayList<>();
        try {
     //       personDTOList = personService.findAll();

        } catch (Exception exception) {
            return new PersonListServiceAntwort(personDTOList, false, exception.getMessage());
        }

        return new PersonListServiceAntwort(personDTOList, true, "");
    }
}
