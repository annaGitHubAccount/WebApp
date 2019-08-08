package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.model.form.ProduktStammdatenForm;

public final class ProduktStammdatenDTOProductStammdatenFormAssembler {

    private ProduktStammdatenDTOProductStammdatenFormAssembler() {
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
