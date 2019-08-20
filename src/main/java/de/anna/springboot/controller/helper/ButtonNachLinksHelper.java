package de.anna.springboot.controller.helper;

import de.anna.springboot.model.assembler.ProduktStammdatenDTOProduktDTOAssembler;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonNachLinksHelper {

    public List<ProduktDTO> loescheAusgewaehlteProdukteAusProduktDTOList(List<ProduktDTO> produktListFromSession, List<String> produktGewaehlteListFromFormular) {

        List<ProduktDTO> newProduktDTOList = new ArrayList<>();

        for (ProduktDTO produktDTOFromSession : produktListFromSession) {

            if (!produktGewaehlteListFromFormular.contains(produktDTOFromSession.getSymbol())) {
                newProduktDTOList.add(produktDTOFromSession);
            }
        }
        return newProduktDTOList;
    }


    public List<ProduktStammdatenDTO> fuegeAusgewaehlteProdukteZuProduktStammdatenDTOListHinzu(List<ProduktDTO> produktListFromSession, List<String> produktGewaehlteListFromFormular) {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = new ArrayList<>();

        for (ProduktDTO produktDTOFromSession : produktListFromSession) {

            if (produktGewaehlteListFromFormular.contains(produktDTOFromSession.getSymbol())) {
                ProduktStammdatenDTO produktStammdatenDTO = ProduktStammdatenDTOProduktDTOAssembler.convertProduktDTOToProduktStammdatenDTO(produktDTOFromSession);
                produktStammdatenDTOList.add(produktStammdatenDTO);
            }
        }

        return produktStammdatenDTOList;
    }
}
