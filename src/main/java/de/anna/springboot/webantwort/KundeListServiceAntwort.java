package de.anna.springboot.webantwort;

import de.anna.springboot.model.dto.KundeDTO;

import java.util.List;


// controller zwraca zawsze 1 obiekt, nie liste obiektow, dlatego elegancko jest obudowac moja liste obiektow w inny obiekt + zawrzec informacje oo ewentualnym błędzie

public class KundeListServiceAntwort {

    private List<KundeDTO> kundeDTOList;

    private boolean isOk;

    private String error;

    public KundeListServiceAntwort(List<KundeDTO> kundeDTOList, boolean isOk, String error) {

        this.kundeDTOList = kundeDTOList;
        this.isOk = isOk;
        this.error = error;
    }

    public KundeListServiceAntwort() {
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<KundeDTO> getKundeDTOList() {
        return kundeDTOList;
    }

    public void setKundeDTOList(List<KundeDTO> kundeDTOList) {
        this.kundeDTOList = kundeDTOList;
    }
}
