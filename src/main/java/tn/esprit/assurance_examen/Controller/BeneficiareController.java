package tn.esprit.assurance_examen.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.assurance_examen.Entity.Benificiaire;
import tn.esprit.assurance_examen.Entity.TypeContrat;
import tn.esprit.assurance_examen.Service.Interface.BeneficiaireInterface;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class BeneficiareController {
    BeneficiaireInterface beneficiaireInterface;

    @PostMapping("/ajouterBeneficiaire")
    public Benificiaire ajouterBeneficiaire(@RequestBody Benificiaire bf) {
        return beneficiaireInterface.ajouterBeneficiaire(bf);
    }

    @GetMapping("/getBeneficairesByType/{typeContrat}")
    public Set<Benificiaire> getBeneficairesByType(@PathVariable("typeContrat") TypeContrat typeContrat) {
        return beneficiaireInterface.getBeneficairesByType(typeContrat);
    }
}
