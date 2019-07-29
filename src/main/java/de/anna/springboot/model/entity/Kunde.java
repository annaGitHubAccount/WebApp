package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.KundeArt;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Kunde {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String steuerId;

    private String name;

    private String nachname;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "KUNDE_ART")
    private KundeArt kundeArt;


    public Kunde() {
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
