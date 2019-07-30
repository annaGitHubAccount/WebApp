package de.anna.springboot.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

// https://www.baeldung.com/jpa-persisting-enums-in-jpa
// diese Methoden dienen nur für JPA für Kommunikation zwischen Entity und Datembank

@Converter(autoApply = true)
public class KundeArtConverter implements AttributeConverter<KundeArt, String> {

    @Override
    public String convertToDatabaseColumn(KundeArt kundeArt) {

        if(kundeArt == null) {
            return null;
        }
        return kundeArt.getKode();
    }

    @Override
    public KundeArt convertToEntityAttribute(String kundeArtAlsString) {

        if(kundeArtAlsString == null){
            return null;
        }

        return KundeArt.convertToKundeArtByCode(kundeArtAlsString);
    }
}
