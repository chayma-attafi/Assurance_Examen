package tn.esprit.assurance_examen.Service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.assurance_examen.Entity.Assurance;
import tn.esprit.assurance_examen.Entity.Benificiaire;
import tn.esprit.assurance_examen.Entity.Contrat;
import tn.esprit.assurance_examen.Entity.TypeContrat;
import tn.esprit.assurance_examen.Repository.AssuranceRepository;
import tn.esprit.assurance_examen.Repository.BenificiaireRepository;
import tn.esprit.assurance_examen.Repository.ContratRepository;
import tn.esprit.assurance_examen.Service.Interface.AssuranceInterface;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@AllArgsConstructor
@Service
public class AssuranceService implements AssuranceInterface {
    AssuranceRepository assuranceRepository;
    ContratRepository contratRepository;
    BenificiaireRepository benificiaireRepository;

    @Transactional
    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Benificiaire benificiaire = benificiaireRepository.findByCin(cinBf);
        Contrat contrat = contratRepository.findByMatriculeLike(matricule);

        a.setBenificiaire(benificiaire);
        a.setContrat(contrat);
        return assuranceRepository.save(a);
    }

    @Override
    public float getMontantBf(int cinBf) {
        float mont=0;
        Benificiaire benificiaire = benificiaireRepository.findByCin(cinBf);
        for (Assurance assurance: benificiaire.getAssuranceList())
        {
            if(assurance.getContrat().getTypeContrat()== TypeContrat.Mensuel)
            {
                mont+=assurance.getMontant()*12;
            }
            else if(assurance.getContrat().getTypeContrat()== TypeContrat.Semestriel)
            {
                mont+=assurance.getMontant()*2;
            }
            else
            mont+=assurance.getMontant();
        }
        return mont;
    }

    @Scheduled(cron = "*/60 * * * * *")
    @Override
    public void statistiques() {

        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());

        for (Benificiaire b : benificiaireRepository.findAll()) {
            myStat.put(b.getAssuranceList().size(), b.getCin());
        }
        for (Map.Entry<Integer, Integer> va : myStat.entrySet()) {
            log.info(va.getKey() + "|" + va.getValue());
        }

    }
}
