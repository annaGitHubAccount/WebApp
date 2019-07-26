package de.anna.springboot.model;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.util.DateUtils;

import java.time.LocalDate;

public class KundeAssembler {

    public KundeDTO mapKundeToKundeDTO(Kunde kunde){

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kunde.getId());
        kundeDTO.setSteuerId(kunde.getSteuerId());
        kundeDTO.setName(kunde.getName());
        kundeDTO.setNachname(kunde.getNachname());
        kundeDTO.setBirthDate(kunde.getBirthDate());

        return kundeDTO;
    }


    public Kunde mapKundeDTOToKunde(KundeDTO kundeDTO){

        Kunde kunde = new Kunde();

        kunde.setId(kundeDTO.getId());
        kunde.setSteuerId(kundeDTO.getSteuerId());
        kunde.setName(kundeDTO.getName());
        kunde.setNachname(kundeDTO.getNachname());
        kunde.setBirthDate(kundeDTO.getBirthDate());

        return kunde;
    }



    public KundeDTO mapKundeFormToKundeDTO(KundeForm kundeForm){

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kundeForm.getId());
        kundeDTO.setSteuerId(kundeForm.getSteuerId());
        kundeDTO.setName(kundeForm.getName());
        kundeDTO.setNachname(kundeForm.getNachname());
        LocalDate localDate = DateUtils.stringToLocalDate(kundeForm.getBirthDate());
        kundeDTO.setBirthDate(localDate);

        return kundeDTO;
    }

    public KundeForm mapKundeDTOToKundeForm(KundeDTO kundeDTO){

        KundeForm kundeForm = new KundeForm();

        kundeForm.setId(kundeDTO.getId());
        kundeForm.setSteuerId(kundeDTO.getSteuerId());
        kundeForm.setName(kundeDTO.getName());
        kundeForm.setNachname(kundeDTO.getNachname());
        String dateToString = DateUtils.localDateToString(kundeDTO.getBirthDate());
        kundeForm.setBirthDate(dateToString);

        return kundeForm;
    }
}
