package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;

public final class AdresseAdresseDTOAssembler {

    private AdresseAdresseDTOAssembler() {
    }


    public static AdresseDTO mapAdresseToAdresseDTO(Adresse adresse, KundeDTO kundeDTO){

        AdresseDTO adresseDTO = new AdresseDTO();

        adresseDTO.setAdresseArt(adresse.getAdresseArt());
        adresseDTO.setHausNr(adresse.getHausNr());
        adresseDTO.setId(adresse.getId());
        adresseDTO.setLand(adresse.getLand());
        adresseDTO.setOrt(adresse.getOrt());
        adresseDTO.setStrasse(adresse.getStrasse());
        adresseDTO.setKundeDTO(kundeDTO);

        return adresseDTO;
    }


    public static Adresse mapAdresseDTOToAdresse(AdresseDTO adresseDTO, Kunde kunde){

        Adresse adresse = new Adresse();

        adresse.setAdresseArt(adresseDTO.getAdresseArt());
        adresse.setHausNr(adresseDTO.getHausNr());
        adresse.setId(adresseDTO.getId());
        adresse.setLand(adresseDTO.getLand());
        adresse.setOrt(adresseDTO.getOrt());
        adresse.setStrasse(adresseDTO.getStrasse());
        adresse.setKunde(kunde);

        return adresse;
    }
}
