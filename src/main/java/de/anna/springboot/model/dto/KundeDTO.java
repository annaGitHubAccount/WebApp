package de.anna.springboot.model.dto;

public class KundeDTO {

    private Long id;

    private String name;

    private String nachname;



    public KundeDTO(String name, String nachname) {
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
}
