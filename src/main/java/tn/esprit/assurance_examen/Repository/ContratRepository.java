package tn.esprit.assurance_examen.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.assurance_examen.Entity.Contrat;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    @Query("SELECT c FROM Contrat c WHERE c.marticule LIKE %:matricule%")
    public Contrat findByMatriculeLike(@Param("matricule") String matricule);

    //public Contrat findByMarticuleLike(String matricule);



    @Query("SELECT a.contrat FROM Assurance a JOIN a.benificiaire b WHERE b.idBenificiaire = :idBf ORDER BY a.contrat.dateEffet ASC")
    List<Contrat> getOldestContratForBeneficiary(@Param("idBf") int idBf, PageRequest pageable);



}






