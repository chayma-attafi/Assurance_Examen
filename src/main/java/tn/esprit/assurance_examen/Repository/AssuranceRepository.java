package tn.esprit.assurance_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.assurance_examen.Entity.Assurance;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance,Integer> {
}
