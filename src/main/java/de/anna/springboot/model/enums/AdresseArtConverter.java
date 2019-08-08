package de.anna.springboot.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AdresseArtConverter implements AttributeConverter<AdresseArt, String> {

    @Override
    public String convertToDatabaseColumn(AdresseArt adresseArt) {

        if(adresseArt == null){
            return null;
        }
        return adresseArt.getKode();
    }

    @Override
    public AdresseArt convertToEntityAttribute(String adresseArtByKode) {

        if(adresseArtByKode == null){
            return null;
        }

        return AdresseArt.convertToAdresseArtByKode(adresseArtByKode);
    }

}
