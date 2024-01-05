package tn.esprit.assurance_examen.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.assurance_examen.Entity.Assurance;
import tn.esprit.assurance_examen.Service.Interface.AssuranceInterface;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class AssuranceController {
    AssuranceInterface assuranceInterface;

    @PutMapping("/ajouterAssurance/{cinBf}/{matricule}")
    public Assurance ajouterAssurance(@RequestBody Assurance a,
                                      @PathVariable("cinBf") int cinBf,
                                      @PathVariable("matricule") String matricule) {
        return assuranceInterface.ajouterAssurance(a, cinBf, matricule);
    }

    @GetMapping("/getMontantBf/{cinBf}")
    public float getMontantBf(@PathVariable("cinBf") int cinBf) {
        return assuranceInterface.getMontantBf(cinBf);
    }

    @GetMapping("/statistiques")
    public void statistiques() {
        assuranceInterface.statistiques();
    }
}
