package de.anna.springboot.model.dto;

import java.math.BigDecimal;

public class ProduktStammdatenDTO {

    private Long id;

    private String name;

    private BigDecimal preis;

    private boolean aktiv;

    private String aktivStr;


    public ProduktStammdatenDTO() {
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

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

}