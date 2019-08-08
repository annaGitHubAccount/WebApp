package de.anna.springboot.controller;

import de.anna.springboot.model.assembler.ProduktStammdatenDTOProductStammdatenFormAssembler;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.form.ProduktStammdatenForm;
import de.anna.springboot.service.ProduktStammdatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/web")
public class ProduktStammdatenWebController {

    @Autowired
    ProduktStammdatenService produktStammdatenService;

    private static final String PRODUKT_STAMMDATEN_FORM = "produktStammdatenForm";
    private static final String PRODUKT_STAMMDATEN_LIST = "produktStammdatenList";

    @GetMapping("/addproduktstammdaten")
    public String addProduktStammdaten(Model model) {

        model.addAttribute(PRODUKT_STAMMDATEN_FORM, new ProduktStammdatenForm());
        return "addProduktStammdaten";
    }

    @PostMapping("/produktstammdatenweiterleiten")
    public String kundeWeiterleiten(Model model, @Valid @ModelAttribute(PRODUKT_STAMMDATEN_FORM) ProduktStammdatenForm produktStammdatenForm, BindingResult resultOfValidation) {

        if (resultOfValidation.hasErrors()) {

            model.addAttribute(PRODUKT_STAMMDATEN_FORM, produktStammdatenForm);
            return "addProduktStammdaten";

        } else {

            model.addAttribute(PRODUKT_STAMMDATEN_FORM, produktStammdatenForm);
            return "produktStammdatenWeiterleiten";
        }
    }

    @PostMapping("/saveproduktstammdaten")
    public String saveProduktStammdaten(@ModelAttribute(PRODUKT_STAMMDATEN_FORM) ProduktStammdatenForm produktStammdatenForm, Model model){

        ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenDTOProductStammdatenFormAssembler.mapProduktStammdatenFormToProduktStammdatenDTO(produktStammdatenForm);
        produktStammdatenService.save(produktStammdatenDTO);

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        model.addAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOList);

        return "produktStammdatenList";
    }

    @GetMapping("/produktstammdatenlist")
    public String produktStammdatenListZeigen(Model model){

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        model.addAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOList);

        return "produktStammdatenList";
    }

    @GetMapping("/editproduktstammdaten/{id}")
        public String editProduktStammdaten(@PathVariable Long id, Model model){

        ProduktStammdatenDTO produktStammdatenById = produktStammdatenService.findProduktStammdatenById(id);
        ProduktStammdatenForm produktStammdatenForm = ProduktStammdatenDTOProductStammdatenFormAssembler.mapProduktStammdatenDTOToProduktStammdatenForm(produktStammdatenById);
        model.addAttribute(PRODUKT_STAMMDATEN_FORM, produktStammdatenForm);

        return "editProduktStammdaten";
    }

    @PostMapping("/produktstammdatenweiterleitenedit")
    public String produktStammdatenWeiterleitenEdit(@ModelAttribute(PRODUKT_STAMMDATEN_FORM) ProduktStammdatenForm produktStammdatenForm, Model model){

        model.addAttribute(PRODUKT_STAMMDATEN_FORM, produktStammdatenForm);
        return "produktStammdatenWeiterleitenEdit";
    }

    @GetMapping("/deleteproduktstammdaten/{id}")
    public String deleteProduktStammdaten(@PathVariable Long id, Model model){

        ProduktStammdatenDTO produktStammdatenById = produktStammdatenService.findProduktStammdatenById(id);
        produktStammdatenService.deleteProduktStammdatenById(produktStammdatenById.getId());

        List<ProduktStammdatenDTO> stammdatenServiceAll = produktStammdatenService.findAll();
        model.addAttribute(PRODUKT_STAMMDATEN_LIST, stammdatenServiceAll);

        return PRODUKT_STAMMDATEN_LIST;
    }


}
