package de.anna.springboot.controller.helper;

import de.anna.springboot.model.assembler.ProduktStammdatenDTOProduktDTOAssembler;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonNachRechtsHelper {

    public List<ProduktStammdatenDTO> loescheAusgewaehlteProdukteAusProduktStammdatenDTOList(List<ProduktStammdatenDTO> produktStammdatenListFromSession,
                                                                                                    List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktStammdatenDTO> newProduktStammdatenDTOList = new ArrayList<>();

        for (ProduktStammdatenDTO produktStammdatenDTOFromSession : produktStammdatenListFromSession) {

            if (!produktStammdatenGewaehlteListFromFormular.contains(produktStammdatenDTOFromSession.getSymbol())) {
                newProduktStammdatenDTOList.add(produktStammdatenDTOFromSession);
            }
        }

        return newProduktStammdatenDTOList;
    }


    public List<ProduktDTO> fuegeAusgewaehlteProdukteZuProduktDTOListHinzu(List<ProduktStammdatenDTO> produktStammdatenListFromSession,
                                                                                  List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktDTO> produktDTOList = new ArrayList<>();

        for (ProduktStammdatenDTO produktStammdatenDTOFromSession : produktStammdatenListFromSession) {

            if (produktStammdatenGewaehlteListFromFormular.contains(produktStammdatenDTOFromSession.getSymbol())) {
                ProduktDTO produktDTO = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTOFromSession);
                produktDTOList.add(produktDTO);
            }
        }

        return produktDTOList;
    }
}
