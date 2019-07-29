package de.anna.springboot.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum KundeArt {

    BRONZE("BR", "Bronze"),
    SILBER("SB", "Silber"),
    GOLD("GD", "Gold");

    private String kode;
    private String text;


    KundeArt(String kode, String text) {
        this.kode = kode;
        this.text = text;
    }


    public static Map<String, String> convertKundeArtEnumToMap() {

        Map<String, String> kundeArtMap = new HashMap<>();
        KundeArt[] kundeArtEnumArray = values();

        for (KundeArt kundeArt : kundeArtEnumArray) {
            kundeArtMap.put(kundeArt.getKode(), kundeArt.getText());
        }

        return kundeArtMap;
    }


    public static KundeArt kundeFormStringToKundeArtEnum(String kundeArtAlsString){

        KundeArt[] kundeArtsArray = values();

        for(KundeArt kundeArt : kundeArtsArray){
            if(kundeArt.getText().equals(kundeArtAlsString)){
                return kundeArt;
            }
        }

        // return null; // nieladnie zwracac null, wiec lepiej rzucic wyjatek
        throw new RuntimeException("Es gibt solche KundeArt nicht !!!");

    }

    public static String convertKundeArtKodeToText(String kundeArtKode) {

        KundeArt[] kundeArtsArray = values();

        for(KundeArt kundeArt : kundeArtsArray){
            if(kundeArt.getKode().equals(kundeArtKode)){
                return kundeArt.getText();
            }
        }

        throw new RuntimeException("Es gibt solche KundeArtKode nicht !!!");
    }


    public String getKode() {
        return kode;
    }

    public String getText() {
        return text;
    }

}
