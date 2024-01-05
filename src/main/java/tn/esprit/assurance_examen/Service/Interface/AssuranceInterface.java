package tn.esprit.assurance_examen.Service.Interface;

import tn.esprit.assurance_examen.Entity.Assurance;

public interface AssuranceInterface {
    public Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);
    public float getMontantBf (int cinBf);

    public void statistiques ();
}
