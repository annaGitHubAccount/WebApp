package de.anna.springboot.controller;

import de.anna.springboot.model.PersonAssembler;
import de.anna.springboot.model.dto.PersonDTO;
import de.anna.springboot.model.form.PersonForm;
import de.anna.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// jede methode muss immer alle daten, die ich zeigen möchte, enthalten

@Controller
@RequestMapping("/person")
public class PersonWebController {


    @Autowired
    PersonService personService;

    PersonAssembler personAssembler = new PersonAssembler();


    @RequestMapping("/personformular")
    public String personFormularZeigen(Model model){

        model.addAttribute("personForm", new PersonForm());
        return "personFormular";
    }



    @PostMapping("/personweiterleiten")
    public String personWeiterleiten(Model model, @ModelAttribute("personForm") PersonForm personForm){

        model.addAttribute("personForm", personForm);
        return "personWeiterleiten";
    }


    @PostMapping("/saveperson")
    public String savePerson(@ModelAttribute("personForm") PersonForm personForm, Model model){

        PersonDTO personDTO = personAssembler.mapPersonFormToPersonDTO(personForm);
        personService.save(personDTO);

        List<PersonDTO> personDTOList = personService.findAll();
        model.addAttribute("personList", personDTOList);

        return "listeVonPersonen";
    }


    @GetMapping("/listevonpersonen")
    public String zeigeListeVonPersonen(Model model){

        List<PersonDTO> personDTOList = personService.findAll();
        model.addAttribute("personList", personDTOList);

        return "listeVonPersonen";
    }


    @GetMapping("/editperson/{id}")
    public String editPerson(@PathVariable Long id, Model model){

        PersonDTO personDTOById = personService.findPersonById(id);
        model.addAttribute("personForm", personDTOById);

        return "editPerson";
    }


    @PostMapping("/personweiterleitenedit")
    public String personWeiterleitenEdit(Model model, PersonForm personForm){

        model.addAttribute("personForm", personForm);

        return "personWeiterleitenEdit";
    }


    @GetMapping("deleteperson/{id}")
    public String deletePerson(@PathVariable Long id, Model model){

        personService.deletePersonById(id);

        List<PersonDTO> personDTOList = personService.findAll();
        model.addAttribute("personList", personDTOList);

        return "listeVonPersonen";
    }
}
