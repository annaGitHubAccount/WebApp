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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// jede Methode muss immer alle Daten, die ich zeigen möchte, enthalten !!!! Daten leiter ich in Model weiter!!!

@Controller
@RequestMapping("/web")
public class KundeWebController {

    private static final String KUNDE_FORM = "kundeForm";
    private static final String KUNDE_LIST = "kundeList";

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
        request.getSession().setAttribute("produktStammdatenList", produktStammdatenDTOList);
        request.getSession().setAttribute("produktList", new ArrayList<>());
        kundeForm.setProduktStammdatenList(produktStammdatenDTOList);


        model.addAttribute(KUNDE_FORM, kundeForm);

        return "addKunde";
    }


    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, /*@Validated @Valid*/ @ModelAttribute(KUNDE_FORM) KundeForm kundeForm, BindingResult resultOfValidation, HttpServletRequest request) {

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

        if (kundeForm.getWelcherButton().equals("buttonRechts")) {

            @SuppressWarnings("unchecked")
            List<ProduktStammdatenDTO> produktStammdatenListFromSession = (List<ProduktStammdatenDTO>) request.getSession().getAttribute("produktStammdatenList");

            @SuppressWarnings("unchecked")
            List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");

            List<String> produktStammdatenGewaehlteListFromFormular = kundeForm.getProduktStammdatenGewaehlteList();

            List<ProduktStammdatenDTO> produktStammdatenDTOListUpdated = buttonNachRechtsHelper.loescheAusgewaehlteProdukteAusProduktStammdatenDTOList(produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

            List<ProduktDTO> produktListDTOUpdated = buttonNachRechtsHelper.fuegeAusgewaehlteProdukteZuProduktDTOListHinzu(produktStammdatenListFromSession, produktStammdatenGewaehlteListFromFormular);

            produktListFromSession.addAll(produktListDTOUpdated);


            kundeForm.setProduktStammdatenList(produktStammdatenDTOListUpdated);
            kundeForm.setProduktList(produktListFromSession);
            request.getSession().setAttribute("produktStammdatenList", produktStammdatenDTOListUpdated);
            request.getSession().setAttribute("produktList", produktListFromSession);

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else if (kundeForm.getWelcherButton().equals("buttonLinks")) {

            @SuppressWarnings("unchecked")
            List<ProduktStammdatenDTO> produktStammdatenListFromSession = (List<ProduktStammdatenDTO>) request.getSession().getAttribute("produktStammdatenList");

            @SuppressWarnings("unchecked")
            List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");

            List<String> produktGewaehlteListFromFormular = kundeForm.getProduktGewaehlteList();

            List<ProduktDTO> produktDTOListUpdated = buttonNachLinksHelper.loescheAusgewaehlteProdukteAusProduktDTOList(produktListFromSession, produktGewaehlteListFromFormular);

            List<ProduktStammdatenDTO> produktStammdatenListDTOUpdated = buttonNachLinksHelper.fuegeAusgewaehlteProdukteZuProduktStammdatenDTOListHinzu(produktListFromSession, produktGewaehlteListFromFormular);

            produktStammdatenListFromSession.addAll(produktStammdatenListDTOUpdated);


            kundeForm.setProduktList(produktDTOListUpdated);
            kundeForm.setProduktStammdatenList(produktStammdatenListFromSession);
            request.getSession().setAttribute("produktList", produktDTOListUpdated);
            request.getSession().setAttribute("produktStammdatenList", produktStammdatenListFromSession);

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else {

            if (resultOfValidation.hasErrors()) {

                model.addAttribute(KUNDE_FORM, kundeForm);
                return "addKunde";

            } else {

                String kundeArtText = KundeArt.convertKundeArtKodeToText(kundeForm.getKundeArt());
                kundeForm.setKundeArt(kundeArtText);

                @SuppressWarnings("unchecked")
                List<ProduktDTO> produktListFromSession = (List<ProduktDTO>) request.getSession().getAttribute("produktList");
                kundeForm.setProduktList(produktListFromSession);

                model.addAttribute(KUNDE_FORM, kundeForm);
                return "kundeWeiterleiten";
            }
        }
    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute(KUNDE_FORM) KundeForm kundeForm, Model model, HttpServletRequest request) {

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
    public String editKunde(@PathVariable Long id, Model model) {

        KundeDTO kundeDTOById = kundeService.findKundeById(id);
        KundeForm kundeForm = KundeDTOKundeFormAssembler.mapKundeDTOToKundeForm(kundeDTOById);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToMap());

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
