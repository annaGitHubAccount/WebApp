package de.anna.springboot.model;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.form.KundeForm;

public class KundeAssembler {

    public KundeDTO mapKundeToKundeDTO(Kunde kunde){

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kunde.getId());
        kundeDTO.setName(kunde.getName());
        kundeDTO.setNachname(kunde.getNachname());

        return kundeDTO;
    }


    public Kunde mapKundeDTOToKunde(KundeDTO kundeDTO){

        Kunde kunde = new Kunde();

        kunde.setId(kundeDTO.getId());
        kunde.setName(kundeDTO.getName());
        kunde.setNachname(kundeDTO.getNachname());

        return kunde;
    }



    public KundeDTO mapKundeFormToKundeDTO(KundeForm kundeForm){

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kundeForm.getId());
        kundeDTO.setName(kundeForm.getName());
        kundeDTO.setNachname(kundeForm.getNachname());

        return kundeDTO;
    }

    public KundeForm mapKundeDTOToKundeForm(KundeDTO kundeDTO){

        KundeForm kundeForm = new KundeForm();

        kundeForm.setId(kundeDTO.getId());
        kundeForm.setName(kundeDTO.getName());
        kundeForm.setNachname(kundeDTO.getNachname());

        return kundeForm;
    }
}
