package de.anna.springboot.service;

import de.anna.springboot.model.KundeAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KundeServiceImpl implements KundeService {

    @Autowired
    KundeRepository kundeRepository;


    @Override
    @Transactional
    public void save(KundeDTO kundeDTO) {

        Kunde kunde = KundeAssembler.mapKundeDTOToKunde(kundeDTO);
        kundeRepository.save(kunde);
    }

    @Override
    public List<KundeDTO> findAll() {

        List<KundeDTO> kundeDTOList = new ArrayList<>();

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findAll();

        for (Kunde kunde : kundeList) {
            KundeDTO kundeDTO = KundeAssembler.mapKundeToKundeDTO(kunde);
            kundeDTOList.add(kundeDTO);
        }

        return kundeDTOList;
    }


    @Override
    @Transactional
    public KundeDTO findKundeById(Long id) {

        Optional<Kunde> kundeByID = kundeRepository.findById(id);

        KundeDTO kundeDTO = new KundeDTO();
        if (kundeByID.isPresent()) {
            kundeDTO = KundeAssembler.mapKundeToKundeDTO(kundeByID.get());
        }

        return kundeDTO;
    }

    @Override
    @Transactional
    public void deleteKundeById(Long id) {

        Optional<Kunde> kundeById = kundeRepository.findById(id);

        if (kundeById.isPresent()) {
            kundeRepository.delete(kundeById.get());
        }
    }

    @Override
    public List<KundeDTO> findKundenByNachname(String nachname) {

        List<KundeDTO> kundeDTOList = new ArrayList<>();
        List<Kunde> kundenByNachname = kundeRepository.findKundenByNachname(nachname);

        for (Kunde kunde : kundenByNachname) {
            KundeDTO kundeDTO = KundeAssembler.mapKundeToKundeDTO(kunde);
            kundeDTOList.add(kundeDTO);
        }

        return kundeDTOList;
    }


}
