package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.services.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
@CrossOrigin("*")
public class EtudiantController {
    private EtudiantService etudiantService;

    @GetMapping("/all")
    public List<EtudiantDTO> getEtudiants(){
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public EtudiantDTO getEtudiant(@PathVariable Long id){
        return etudiantService.getEtudiantById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiantById(id);
    }

    @PutMapping("/edit/{id}")
    public EtudiantDTO editEtudiant(@PathVariable Long id, @RequestBody EtudiantDTO etudiant){
        etudiant.setId(id);
        return etudiantService.updateEtudiant(id,etudiant);
    }

    @PostMapping("/new-etudiant")
    public EtudiantDTO newEtudiant(@RequestBody EtudiantDTO etudiant){
        return etudiantService.createEtudiant(etudiant);
    }

    @GetMapping("/cne/{cne}")
    public EtudiantDTO searchEtudiantByCNE(@PathVariable String cne){
        return etudiantService.ChercherEtudiantByCNE(cne);
    }

    @GetMapping("/username/{username}")
    public EtudiantDTO getEtudiantByUsername(@PathVariable String username){
        return etudiantService.getEtudiantByUsername(username);
    }
    @GetMapping("/{etudiantId}/stage")
    public ResponseEntity<StageDTO> getStageByEtudiantId(@PathVariable Long etudiantId) {
        StageDTO stageDTO = etudiantService.getStageByEtudiantId(etudiantId);
        return new ResponseEntity<>(stageDTO, HttpStatus.OK);
    }
}
