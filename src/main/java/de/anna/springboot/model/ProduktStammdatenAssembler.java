package de.anna.springboot.model;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.entity.ProduktStammdaten;
import de.anna.springboot.model.form.ProduktStammdatenForm;

import java.math.BigDecimal;

public final class ProduktStammdatenAssembler {

    private ProduktStammdatenAssembler() {
    }


    public static ProduktStammdatenDTO mapProduktStammdatenToProduktStammdatenDTO(ProduktStammdaten produktStammdaten) {

        ProduktStammdatenDTO produktStammdatenDTO = new ProduktStammdatenDTO();

        produktStammdatenDTO.setId(produktStammdaten.getId());
        produktStammdatenDTO.setName(produktStammdaten.getName());
        produktStammdatenDTO.setPreis(produktStammdaten.getPreis());
        produktStammdatenDTO.setAktiv(produktStammdaten.isAktiv());

        return produktStammdatenDTO;
    }


    public static ProduktStammdaten mapProduktStammdatenDTOToProduktStammdaten(ProduktStammdatenDTO produktStammdatenDTO) {

        ProduktStammdaten produktStammdaten = new ProduktStammdaten();

        produktStammdaten.setId(produktStammdatenDTO.getId());
        produktStammdaten.setName(produktStammdatenDTO.getName());
        produktStammdaten.setPreis(produktStammdatenDTO.getPreis());
        produktStammdaten.setAktiv(produktStammdatenDTO.isAktiv());

        return produktStammdaten;
    }


    public static ProduktStammdatenDTO mapProduktStammdatenFormToProduktStammdatenDTO(ProduktStammdatenForm produktStammdatenForm) {

        ProduktStammdatenDTO produktStammdatenDTO = new ProduktStammdatenDTO();

        produktStammdatenDTO.setId(produktStammdatenForm.getId());
        produktStammdatenDTO.setName(produktStammdatenForm.getName());
        produktStammdatenDTO.setPreis(produktStammdatenForm.getPreis());

        produktStammdatenDTO.setAktiv(produktStammdatenForm.isAktiv());

        return produktStammdatenDTO;
    }


    public static ProduktStammdatenForm mapProduktStammdatenDTOToProduktStammdatenForm(ProduktStammdatenDTO produktStammdatenDTO) {

        ProduktStammdatenForm produktStammdatenForm = new ProduktStammdatenForm();

        produktStammdatenForm.setId(produktStammdatenDTO.getId());
        produktStammdatenForm.setName(produktStammdatenDTO.getName());
        produktStammdatenForm.setPreis(produktStammdatenDTO.getPreis());
        produktStammdatenForm.setAktiv(produktStammdatenDTO.isAktiv());

        return produktStammdatenForm;
    }


}
