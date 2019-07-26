package de.anna.springboot.controller;

import de.anna.springboot.model.KundeAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// jede Methode muss immer alle Daten, die ich zeigen möchte, enthalten !!!! Daten leiter ich in Model weiter!!!

@Controller
@RequestMapping("/web")
public class KundeWebController {


    @Autowired
    KundeService kundeService;

    KundeAssembler kundeAssembler = new KundeAssembler();


    @GetMapping({"/", "/homepage"})
    public String homePage(){

        return "homePage";
    }


    @GetMapping("/kundeformular")
    public String kundeFormularZeigen(Model model){

        model.addAttribute("kundeForm", new KundeForm());
        return "kundeFormular";
    }



    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @Valid @ModelAttribute("kundeForm") KundeForm kundeForm, BindingResult resultOfValidation){

        if(resultOfValidation.hasErrors()) {
            model.addAttribute("kundeForm", kundeForm);
            return "kundeFormular";

        }else {
            model.addAttribute("kundeForm", kundeForm);
            return "kundeWeiterleiten";
        }
    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute("kundeForm") KundeForm kundeForm, Model model){

        KundeDTO kundeDTO = kundeAssembler.mapKundeFormToKundeDTO(kundeForm);
        kundeService.save(kundeDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute("kundeList", kundeDTOList);

        return "listeVonKunden";
    }


    @GetMapping("/listevonkunden")
    public String zeigeListeVonKunden(Model model){

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute("kundeList", kundeDTOList);

        return "listeVonKunden";
    }


    @GetMapping("/editkunde/{id}")
    public String editKunde(@PathVariable Long id, Model model){

        KundeDTO kundeDTOById = kundeService.findKundeById(id);

        KundeForm kundeForm = kundeAssembler.mapKundeDTOToKundeForm(kundeDTOById);

        model.addAttribute("kundeForm", kundeForm);

        return "editKunde";
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm){

        model.addAttribute("kundeForm", kundeForm);

        return "kundeWeiterleitenEdit";
    }


    @GetMapping("/deletekunde/{id}")
    public String deleteKunde(@PathVariable Long id, Model model){

        kundeService.deleteKundeById(id);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute("kundeList", kundeDTOList);

        return "listeVonKunden";
    }
}
