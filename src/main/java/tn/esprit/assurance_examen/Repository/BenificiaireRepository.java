package tn.esprit.assurance_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.assurance_examen.Entity.Benificiaire;
import tn.esprit.assurance_examen.Entity.TypeContrat;

import java.util.Set;

@Repository
public interface BenificiaireRepository extends JpaRepository<Benificiaire,Integer> {

    public Benificiaire findByCin( int cinBf);

    Set<Benificiaire> findByassuranceListContratTypeContrat(TypeContrat typeContrat);
}
