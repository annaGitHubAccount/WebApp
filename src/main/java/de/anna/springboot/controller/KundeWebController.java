package de.anna.springboot.controller;

import de.anna.springboot.model.KundeAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// jede Methode muss immer alle Daten, die ich zeigen möchte, enthalten

@Controller
@RequestMapping("/kunde")
public class KundeWebController {


    @Autowired
    KundeService kundeService;

    KundeAssembler kundeAssembler = new KundeAssembler();


    @RequestMapping("/kundeformular")
    public String kundeFormularZeigen(Model model){

        model.addAttribute("kundeForm", new KundeForm());
        return "kundeFormular";
    }



    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @ModelAttribute("kundeForm") KundeForm kundeForm){

        model.addAttribute("kundeForm", kundeForm);
        return "kundeWeiterleiten";
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
        model.addAttribute("kundeForm", kundeDTOById);

        return "editKunde";
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm){

        model.addAttribute("kundeForm", kundeForm);

        return "kundeWeiterleitenEdit";
    }


    @GetMapping("deletekunde/{id}")
    public String deleteKunde(@PathVariable Long id, Model model){

        kundeService.deleteKundeById(id);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute("kundeList", kundeDTOList);

        return "listeVonKunden";
    }
}
