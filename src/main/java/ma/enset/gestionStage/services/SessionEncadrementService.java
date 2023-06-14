
package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.SessionEncadrementDTO;

import java.util.List;

public interface SessionEncadrementService {
    List<SessionEncadrementDTO> getAllSessionsEncadrement();
    SessionEncadrementDTO getSessionEncadrementById(Long sessionId);
    SessionEncadrementDTO saveSessionEncadrement(SessionEncadrementDTO sessionEncadrementDTO);
    void deleteSessionEncadrement(Long sessionId);

    public List<SessionEncadrementDTO> getSessionsEncadrementByEtudiantId(Long etudiantId);
    public SessionEncadrementDTO updateSessionEncadrement(Long sessionId, SessionEncadrementDTO sessionEncadrementDTO);
}

