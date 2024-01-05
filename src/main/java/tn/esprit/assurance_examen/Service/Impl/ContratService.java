package tn.esprit.assurance_examen.Service.Impl;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.assurance_examen.Entity.Contrat;
import tn.esprit.assurance_examen.Repository.BenificiaireRepository;
import tn.esprit.assurance_examen.Repository.ContratRepository;
import tn.esprit.assurance_examen.Service.Interface.ContratInterface;

import java.awt.print.Pageable;
import java.util.List;

@AllArgsConstructor
@Service
public class ContratService implements ContratInterface {

    ContratRepository contratRepository;
    BenificiaireRepository benificiaireRepository;
    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getContratBf(int idBf) {
        // Create a PageRequest with limit 1 to retrieve only the first result
        PageRequest pageRequest = PageRequest.of(0, 1);

        // Use the modified method with PageRequest
        List<Contrat> contrats = contratRepository.getOldestContratForBeneficiary(idBf,pageRequest);

        // Check if the list is not empty before accessing the first element
        if (!contrats.isEmpty()) {
            return contrats.get(0);
        } else {
            // Handle the case where no contracts are found
            return null;
        }
    }

}
