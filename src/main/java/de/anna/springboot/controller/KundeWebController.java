package de.anna.springboot.controller;

import de.anna.springboot.model.KundeAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

// jede Methode muss immer alle Daten, die ich zeigen möchte, enthalten !!!! Daten leiter ich in Model weiter!!!

@Controller
@RequestMapping("/web")
public class KundeWebController {

    private static final String KUNDE_FORM = "kundeForm";
    private static final String KUNDE_LIST = "kundeList";

    @Autowired
    KundeService kundeService;


    @GetMapping({"/", "/homepage"})
    public String homePage() {

        return "homePage";
    }


    @GetMapping("/addkunde")
    public String kundeFormularZeigen(Model model) {

        Map<String, String> kundeArtMap = KundeArt.convertKundeArtEnumToMap();
        model.addAttribute("kundeArtMap", kundeArtMap);

        model.addAttribute(KUNDE_FORM, new KundeForm());

        return "addKunde";
    }


    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @Valid @ModelAttribute(KUNDE_FORM) KundeForm kundeForm, BindingResult resultOfValidation) {

        if (resultOfValidation.hasErrors()) {

            Map<String, String> kundeArtMap = KundeArt.convertKundeArtEnumToMap();
            model.addAttribute("kundeArtMap", kundeArtMap);

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else {

            String kundeArtText = KundeArt.convertKundeArtKodeToText(kundeForm.getKundeArt());
            kundeForm.setKundeArt(kundeArtText);

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "kundeWeiterleiten";
        }
    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model) {

        KundeDTO kundeDTO = KundeAssembler.mapKundeFormToKundeDTO(kundeForm);
        kundeService.save(kundeDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "listeVonKunden";
    }


    @GetMapping("/listevonkunden")
    public String zeigeListeVonKunden(Model model) {

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "listeVonKunden";
    }


    @GetMapping("/editkunde/{id}")
    public String editKunde(@PathVariable Long id, Model model) {

        KundeDTO kundeDTOById = kundeService.findKundeById(id);
        KundeForm kundeForm = KundeAssembler.mapKundeDTOToKundeForm(kundeDTOById);

        Map<String, String> kundeArtMap = KundeArt.convertKundeArtEnumToMap();
        model.addAttribute("kundeArtMap", kundeArtMap);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "editKunde";
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm) {

        String kundeArtText = KundeArt.convertKundeArtKodeToText(kundeForm.getKundeArt());
        kundeForm.setKundeArt(kundeArtText);
        model.addAttribute(KUNDE_FORM, kundeForm);

        return "kundeWeiterleitenEdit";
    }


    @GetMapping("/deletekunde/{id}")
    public String deleteKunde(@PathVariable Long id, Model model) {

        kundeService.deleteKundeById(id);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "listeVonKunden";
    }
}
