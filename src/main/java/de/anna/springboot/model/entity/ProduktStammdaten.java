package de.anna.springboot.model.entity;

import de.anna.springboot.model.enums.ProduktArt;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUKT_STAMMDATEN")
public class ProduktStammdaten {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Precision is the total number of digits. Scale is the number of digits after the decimal point.
    @Column(precision=10, scale=2)
    private BigDecimal preis;

    @Column(name = "IS_AKTIV")
    private boolean aktiv;

    @Column(name = "PRODUKT_ART")
    private ProduktArt produktArt;


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
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public ProduktArt getProduktArt() {
        return produktArt;
    }

    public void setProduktArt(ProduktArt produktArt) {
        this.produktArt = produktArt;
    }
}
