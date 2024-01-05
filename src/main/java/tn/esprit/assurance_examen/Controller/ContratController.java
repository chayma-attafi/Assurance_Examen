package tn.esprit.assurance_examen.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.assurance_examen.Entity.Contrat;
import tn.esprit.assurance_examen.Service.Interface.ContratInterface;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class ContratController {
    ContratInterface contratInterface;

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat c) {
        return contratInterface.ajouterContrat(c);
    }

    @GetMapping("/getContratBf/{idBf}")
    public Contrat getContratBf(@PathVariable("idBf") int idBf) {
        return contratInterface.getContratBf(idBf);
    }
}
