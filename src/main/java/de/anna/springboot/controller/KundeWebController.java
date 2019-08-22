package de.anna.springboot.controller;

import de.anna.springboot.controller.helper.ButtonNachLinksHelper;
import de.anna.springboot.controller.helper.ButtonNachRechtsHelper;
import de.anna.springboot.model.assembler.KundeDTOKundeFormAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.model.validator.KundeFormValidator;
import de.anna.springboot.service.KundeService;
import de.anna.springboot.service.ProduktStammdatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// jede Methode muss immer alle Daten, die ich zeigen möchte, enthalten !!!! Daten leiter ich in Model weiter!!!

@Controller
@RequestMapping("/web")
public class KundeWebController {

    private static final String KUNDE_FORM = "kundeForm";
    private static final String KUNDE_LIST = "kundeList";
    private static final String PRODUKT_STAMMDATEN_LIST = "produktStammdatenList";
    private static final String PRODUKT_LIST = "produktList";

    @Autowired
    private KundeFormValidator kundeFormValidator;

    @Autowired
    private KundeService kundeService;

    @Autowired
    ProduktStammdatenService produktStammdatenService;

    @Autowired
    ButtonNachRechtsHelper buttonNachRechtsHelper;

    @Autowired
    ButtonNachLinksHelper buttonNachLinksHelper;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(kundeFormValidator);
    }


    @GetMapping({"/", "/homepage"})
    public String homePage() {

        return "homePage";
    }


    @GetMapping("/addkunde")
    public String kundeFormularZeigen(Model model, HttpServletRequest request) {

        KundeForm kundeForm = new KundeForm();

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOList);
        request.getSession().setAttribute(PRODUKT_LIST, new ArrayList<>());
        kundeForm.setProduktStammdatenList(produktStammdatenDTOList);


        model.addAttribute(KUNDE_FORM, kundeForm);

        return "addKunde";
    }


    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @Validated @Valid @ModelAttribute(KUNDE_FORM) KundeForm kundeForm, BindingResult resultOfValidation, HttpServletRequest request) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        if (resultOfValidation.hasErrors()) {

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else {

            @SuppressWarnings("unchecked")
            List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");
            kundeForm.setProduktList(produktListFromSession);

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "kundeWeiterleiten";
        }
    }


    @PostMapping("/buttonnachrechts")
    public String bedienenButtonNachRechts(KundeForm kundeForm, HttpServletRequest request, Model model) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        @SuppressWarnings("unchecked")
        List<ProduktStammdatenDTO> produktStammdatenListFromSession =
                (List<ProduktStammdatenDTO>) request.getSession().getAttribute(PRODUKT_STAMMDATEN_LIST);

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute(PRODUKT_LIST);

        List<String> produktStammdatenGewaehlteListFromFormular = kundeForm.getProduktStammdatenGewaehlteList();

        List<ProduktStammdatenDTO> produktStammdatenDTOListUpdated = buttonNachRechtsHelper.loescheAusgewaehlteProdukteAusProduktStammdatenDTOList(
                produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

        List<ProduktDTO> produktListDTOUpdated = buttonNachRechtsHelper.fuegeAusgewaehlteProdukteZuProduktDTOListHinzu(
                produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

        produktListFromSession.addAll(produktListDTOUpdated);


        kundeForm.setProduktStammdatenList(produktStammdatenDTOListUpdated);
        kundeForm.setProduktList(produktListFromSession);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOListUpdated);
        request.getSession().setAttribute(PRODUKT_LIST, produktListFromSession);

        model.addAttribute(KUNDE_FORM, kundeForm);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }

    }

    @PostMapping("/buttonnachlinks")
    public String bedienenButtonNachLinks(KundeForm kundeForm, HttpServletRequest request, Model model) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        @SuppressWarnings("unchecked")
        List<ProduktStammdatenDTO> produktStammdatenListFromSession =
                (List<ProduktStammdatenDTO>) request.getSession().getAttribute("produktStammdatenList");

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");

        List<String> produktGewaehlteListFromFormular = kundeForm.getProduktGewaehlteList();

        List<ProduktDTO> produktDTOListUpdated = buttonNachLinksHelper.loescheAusgewaehlteProdukteAusProduktDTOList(
                produktListFromSession, produktGewaehlteListFromFormular);

        List<ProduktStammdatenDTO> produktStammdatenListDTOUpdated = buttonNachLinksHelper.fuegeAusgewaehlteProdukteZuProduktStammdatenDTOListHinzu(
                produktListFromSession, produktGewaehlteListFromFormular);

        produktStammdatenListFromSession.addAll(produktStammdatenListDTOUpdated);


        kundeForm.setProduktList(produktDTOListUpdated);
        kundeForm.setProduktStammdatenList(produktStammdatenListFromSession);

        request.getSession().setAttribute(PRODUKT_LIST, produktDTOListUpdated);
        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenListFromSession);

        model.addAttribute(KUNDE_FORM, kundeForm);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }

    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model, HttpServletRequest
            request) {

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");

        kundeForm.setProduktList(produktListFromSession);

        KundeDTO kundeDTO = KundeDTOKundeFormAssembler.mapKundeFormToKundeDTO(kundeForm);

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
    public String editKunde(@PathVariable Long id, Model model, HttpServletRequest request) {

        KundeDTO kundeDTOById = kundeService.findKundeById(id);

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        List<ProduktDTO> produktDTOListVonKunden = kundeDTOById.getProduktDTOList();
        List<String> produktDTOVonKundenAlsStringList = produktDTOVonKundenToStringList(produktDTOListVonKunden);
        List<ProduktStammdatenDTO> produktStammdatenDTOListUpdated = buttonNachRechtsHelper.loescheAusgewaehlteProdukteAusProduktStammdatenDTOList(produktStammdatenDTOList, produktDTOVonKundenAlsStringList);

        KundeForm kundeForm = KundeDTOKundeFormAssembler.mapKundeDTOToKundeForm(kundeDTOById);
        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());
        kundeForm.setProduktStammdatenList(produktStammdatenDTOListUpdated);
        kundeForm.setProduktList(produktDTOListVonKunden);

        request.getSession().setAttribute(PRODUKT_STAMMDATEN_LIST, produktStammdatenDTOListUpdated);
        request.getSession().setAttribute(PRODUKT_LIST, produktDTOListVonKunden);

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "editKunde";
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm, HttpServletRequest request) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        @SuppressWarnings("unchecked")
        List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");
        kundeForm.setProduktList(produktListFromSession);

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


    private List<String> produktDTOVonKundenToStringList(List<ProduktDTO> produktDTOListVonKunden) {

        List<String> stringListVonKundeProdukten = new ArrayList<>();

        for (ProduktDTO produktDTO : produktDTOListVonKunden) {
            stringListVonKundeProdukten.add(produktDTO.getSymbol());
        }

        return stringListVonKundeProdukten;
    }
}
