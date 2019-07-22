package de.anna.springboot.webantwort;

import de.anna.springboot.model.dto.KundeDTO;

import java.util.ArrayList;
import java.util.List;


// controller zwraca zawsze 1 obiekt, nie liste obiektow, dlatego elegancko jest obudowac moja liste obiektow w inny obiekt + zawrzec informacje oo ewentualnym błędzie

public class KundeListServiceAntwort extends KundeServiceAntwort{

    private List<KundeDTO> kundeDTOList = new ArrayList<>();


    public KundeListServiceAntwort(List<KundeDTO> kundeDTOList, boolean isOk, String error) {

        super(isOk, error);
        this.kundeDTOList = kundeDTOList;
    }



    public List<KundeDTO> getKundeDTOList() {
        return kundeDTOList;
    }

    public void setKundeDTOList(List<KundeDTO> kundeDTOList) {
        this.kundeDTOList = kundeDTOList;
    }
}


