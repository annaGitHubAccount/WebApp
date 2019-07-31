package de.anna.springboot.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUKT_STAMMDATEN")
public class ProduktStammdaten {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal preis;

    @Column(name = "IS_AKTIV")
    private boolean isAktiv;


    public ProduktStammdaten() {
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
        return isAktiv;
    }

    public void setAktiv(boolean aktiv) {
        isAktiv = aktiv;
    }
}
