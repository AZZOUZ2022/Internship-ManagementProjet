

package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.SessionEncadrementDTO;
import ma.enset.gestionStage.services.SessionEncadrementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session-encadrement")
@CrossOrigin("*")
@AllArgsConstructor
public class SessionEncadrementController {

    private final SessionEncadrementService sessionEncadrementService;



    @GetMapping
    public ResponseEntity<List<SessionEncadrementDTO>> getAllSessionsEncadrement() {
        List<SessionEncadrementDTO> sessionsEncadrement = sessionEncadrementService.getAllSessionsEncadrement();
        return new ResponseEntity<>(sessionsEncadrement, HttpStatus.OK);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionEncadrementDTO> getSessionEncadrementById(@PathVariable Long sessionId) {
        SessionEncadrementDTO sessionEncadrement = sessionEncadrementService.getSessionEncadrementById(sessionId);
        return new ResponseEntity<>(sessionEncadrement, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SessionEncadrementDTO> saveSessionEncadrement(@RequestBody SessionEncadrementDTO sessionEncadrementDTO) {
        SessionEncadrementDTO savedSessionEncadrement = sessionEncadrementService.saveSessionEncadrement(sessionEncadrementDTO);
        return new ResponseEntity<>(savedSessionEncadrement, HttpStatus.CREATED);
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<SessionEncadrementDTO> updateSessionEncadrement(@PathVariable Long sessionId, @RequestBody SessionEncadrementDTO sessionEncadrementDTO) {
        SessionEncadrementDTO updatedSessionEncadrement = sessionEncadrementService.updateSessionEncadrement(sessionId, sessionEncadrementDTO);
        return new ResponseEntity<>(updatedSessionEncadrement, HttpStatus.OK);
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteSessionEncadrement(@PathVariable Long sessionId) {
        sessionEncadrementService.deleteSessionEncadrement(sessionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<SessionEncadrementDTO>> getSessionsEncadrementByEtudiantId(@PathVariable Long etudiantId) {
        List<SessionEncadrementDTO> sessionsEncadrement = sessionEncadrementService.getSessionsEncadrementByEtudiantId(etudiantId);
        return new ResponseEntity<>(sessionsEncadrement, HttpStatus.OK);
    }
}
