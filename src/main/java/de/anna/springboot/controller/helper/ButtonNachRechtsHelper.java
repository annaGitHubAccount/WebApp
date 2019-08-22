package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.ProduktDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonNachRechtsHelper {

    public List<ProduktDTO> loescheAusgewaehlteProdukteAusProduktStammdatenDTOList(List<ProduktDTO> produktStammdatenListFromSession,
                                                                                                    List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktDTO> newProduktStammdatenDTOList = new ArrayList<>();

        for (ProduktDTO produktStammdatenDTOFromSession : produktStammdatenListFromSession) {

            if (!produktStammdatenGewaehlteListFromFormular.contains(produktStammdatenDTOFromSession.getSymbol())) {
                newProduktStammdatenDTOList.add(produktStammdatenDTOFromSession);
            }
        }

        return newProduktStammdatenDTOList;
    }


    public List<ProduktDTO> fuegeAusgewaehlteProdukteZuProduktDTOListHinzu(List<ProduktDTO> produktStammdatenListFromSession,
                                                                                  List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktDTO> produktDTOList = new ArrayList<>();

        for (ProduktDTO produktStammdatenDTOFromSession : produktStammdatenListFromSession) {

            if (produktStammdatenGewaehlteListFromFormular.contains(produktStammdatenDTOFromSession.getSymbol())) {
                produktDTOList.add(produktStammdatenDTOFromSession);
            }
        }

        return produktDTOList;
    }
}
