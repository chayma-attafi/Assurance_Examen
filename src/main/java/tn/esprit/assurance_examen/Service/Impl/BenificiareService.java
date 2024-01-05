package tn.esprit.assurance_examen.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.assurance_examen.Entity.Benificiaire;
import tn.esprit.assurance_examen.Entity.TypeContrat;
import tn.esprit.assurance_examen.Repository.BenificiaireRepository;
import tn.esprit.assurance_examen.Service.Interface.BeneficiaireInterface;

import java.util.Set;

@AllArgsConstructor
@Service
public class BenificiareService implements BeneficiaireInterface {

    BenificiaireRepository benificiaireRepository;

    @Override
    public Benificiaire ajouterBeneficiaire(Benificiaire bf) {
        return benificiaireRepository.save(bf);
    }

    @Override
    public Set<Benificiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return benificiaireRepository.findByassuranceListContratTypeContrat(typeContrat);
    }
}
