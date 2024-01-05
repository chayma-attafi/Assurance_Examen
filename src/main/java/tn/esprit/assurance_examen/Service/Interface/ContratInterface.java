package tn.esprit.assurance_examen.Service.Interface;

import tn.esprit.assurance_examen.Entity.Contrat;

public interface ContratInterface {
    public Contrat ajouterContrat (Contrat c);
    public Contrat getContratBf (int idBf);
}
