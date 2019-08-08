package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;

import java.util.ArrayList;
import java.util.List;

public final class KundeKundeDTOAssembler {

    private KundeKundeDTOAssembler() {
    }

    public static KundeDTO mapKundeToKundeDTO(Kunde kunde) {

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kunde.getId());
        kundeDTO.setSteuerId(kunde.getSteuerId());
        kundeDTO.setName(kunde.getName());
        kundeDTO.setNachname(kunde.getNachname());
        kundeDTO.setBirthDate(kunde.getBirthDate());
        kundeDTO.setKundeArt(kunde.getKundeArt());

        List<Adresse> adresseList = kunde.getAdresseList();
        List<AdresseDTO> adresseDTOList = new ArrayList<>();

        for (Adresse adresse : adresseList) {
            AdresseDTO adresseDTO = AdresseAdresseDTOAssembler.mapAdresseToAdresseDTO(adresse, kundeDTO);
            adresseDTOList.add(adresseDTO);
        }
        kundeDTO.setAdresseList(adresseDTOList);


        return kundeDTO;
    }


    public static Kunde mapKundeDTOToKunde(KundeDTO kundeDTO, Kunde kunde) {

        kunde.setId(kundeDTO.getId());
        kunde.setSteuerId(kundeDTO.getSteuerId());
        kunde.setName(kundeDTO.getName());
        kunde.setNachname(kundeDTO.getNachname());
        kunde.setBirthDate(kundeDTO.getBirthDate());
        kunde.setKundeArt(kundeDTO.getKundeArt());

        List<AdresseDTO> adresseListDTO = kundeDTO.getAdresseList();
        List<Adresse> adresseList = new ArrayList<>();

        for (AdresseDTO adresseDTO : adresseListDTO) {
            Adresse adresse = AdresseAdresseDTOAssembler.mapAdresseDTOToAdresse(adresseDTO, kunde);
            adresseList.add(adresse);
        }
        kunde.setAdresseList(adresseList);

        return kunde;
    }
}
