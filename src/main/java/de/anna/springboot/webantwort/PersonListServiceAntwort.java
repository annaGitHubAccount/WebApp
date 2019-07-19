package de.anna.springboot.webantwort;

import de.anna.springboot.model.dto.PersonDTO;

import java.util.List;


// controller zwraca zawsze 1 obiekt, nie liste obiektow, dlatego elegancko jest obudowac moja liste obiektow w inny obiekt + zawrzec informacje oo ewentualnym błędzie

public class PersonListServiceAntwort {

    private List<PersonDTO> personDTOList;

    private boolean isOk;

    private String error;

    public PersonListServiceAntwort(List<PersonDTO> personDTOList, boolean isOk, String error) {

        this.personDTOList = personDTOList;
        this.isOk = isOk;
        this.error = error;
    }

    public PersonListServiceAntwort() {
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

    public List<PersonDTO> getPersonDTOList() {
        return personDTOList;
    }

    public void setPersonDTOList(List<PersonDTO> personDTOList) {
        this.personDTOList = personDTOList;
    }
}
