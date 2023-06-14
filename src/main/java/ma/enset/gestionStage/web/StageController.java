package ma.enset.gestionStage.web;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import ma.enset.gestionStage.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;

    @Autowired
    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping("/countByEntreprise")
    public ResponseEntity<List<Object[]>> countStagesByEntreprise() {
        List<Object[]> countedStages = stageService.countStagesByEntrepriseIgnoreCase();
        return ResponseEntity.ok(countedStages);
    }


    @PutMapping("/{stageId}/assign-encadrant")
    public void assignEncadrantToStage(@PathVariable Long stageId, @RequestBody EncadrantPedagogique encadrant) {
        stageService.assignEncadrantToStage(stageId, encadrant);
    }
    @GetMapping("/etudiant/{etudiantId}")
    public List<StageDTO> getStagesByEtudiantId(@PathVariable Long etudiantId) {
        return stageService.getStagesByEtudiantId(etudiantId);
    }

    @PostMapping
    public ResponseEntity<StageDTO> saveStage(@RequestBody StageDTO stageDTO) {
        StageDTO createdStage = stageService.saveStage(stageDTO);
        return new ResponseEntity<>(createdStage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{stageId}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long stageId) {
        stageService.deleteStage(stageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{stageId}")
    public ResponseEntity<StageDTO> updateStage(@PathVariable Long stageId, @RequestBody StageDTO stageDTO) {
        StageDTO updatedStage = stageService.updateStage(stageId, stageDTO);
        return new ResponseEntity<>(updatedStage, HttpStatus.OK);
    }

    @GetMapping("/{stageId}")
    public ResponseEntity<StageDTO> getStageById(@PathVariable Long stageId) {
        StageDTO stageDTO = stageService.getStageById(stageId);
        return new ResponseEntity<>(stageDTO, HttpStatus.OK);
    }

    @GetMapping("/{stageId}/etudiant")
    public EtudiantDTO getEtudiantByStage(@PathVariable Long stageId) {
        return stageService.getEtudiantByStage(stageId);
    }



}
