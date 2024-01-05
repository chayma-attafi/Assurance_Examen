package tn.esprit.assurance_examen.Service.Interface;

import tn.esprit.assurance_examen.Entity.Benificiaire;
import tn.esprit.assurance_examen.Entity.TypeContrat;

import java.lang.reflect.Type;
import java.util.Set;

public interface BeneficiaireInterface {
    public Benificiaire ajouterBeneficiaire (Benificiaire bf) ;
    public Set<Benificiaire> getBeneficairesByType (TypeContrat typeContrat);
}
