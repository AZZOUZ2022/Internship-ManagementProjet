package ma.enset.gestionStage.web;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.dtos.EnseignantDTO;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.services.EncadrantPedagogiqueService;
import ma.enset.gestionStage.services.EncadrantPedagogiqueServiceImpl;
import ma.enset.gestionStage.services.EnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encadrant-pedagogique")
@CrossOrigin(origins = "*")
public class EncadrantPedagogiqueController {

    private EncadrantPedagogiqueServiceImpl encadrantService;

    public EncadrantPedagogiqueController(EncadrantPedagogiqueServiceImpl encadrantService) {
        this.encadrantService = encadrantService;
    }

    @GetMapping("/{encadrantId}/stages")
    public ResponseEntity<List<StageDTO>> getStagesByEncadrant(@PathVariable Long encadrantId) {
        List<StageDTO> stages = encadrantService.getStagesByEncadrant(encadrantId);
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }
    @GetMapping("/{encadrantId}/etudiants")
    public ResponseEntity<List<EtudiantDTO>> getEtudiantsByEncadrant(@PathVariable Long encadrantId) {
        List<EtudiantDTO> etudiants = encadrantService.getEtudiantsByEncadrant(encadrantId);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<EncadrantPedagogiqueDTO> getEncadrantByUsername(@PathVariable String username) {
        EncadrantPedagogiqueDTO encadrantPedagogiqueDTO = encadrantService.getEncadrantByUsername(username);
        if (encadrantPedagogiqueDTO != null) {
            return new ResponseEntity<>(encadrantPedagogiqueDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
