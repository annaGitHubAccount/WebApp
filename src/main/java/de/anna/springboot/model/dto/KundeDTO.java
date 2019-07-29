package de.anna.springboot.model.dto;

import de.anna.springboot.model.enums.KundeArt;

import java.time.LocalDate;

public class KundeDTO {

    private Long id;

    private String steuerId;

    private String name;

    private String nachname;

    private LocalDate birthDate;

    private KundeArt kundeArt;


    public KundeDTO(String name, String nachname) {
        this.name = name;
        this.nachname = nachname;
    }

    public KundeDTO(String steuerId, String name, String nachname) {
        this.steuerId = steuerId;
        this.name = name;
        this.nachname = nachname;
    }



    public KundeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getSteuerId() {
        return steuerId;
    }

    public void setSteuerId(String steuerId) {
        this.steuerId = steuerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public KundeArt getKundeArt() {
        return kundeArt;
    }

    public void setKundeArt(KundeArt kundeArt) {
        this.kundeArt = kundeArt;
    }
}
