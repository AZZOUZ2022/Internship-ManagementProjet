

package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.SessionEncadrementDTO;
import ma.enset.gestionStage.entities.SessionEncadrement;
import ma.enset.gestionStage.mappers.SessionEncadrementMapper;
import ma.enset.gestionStage.repositories.SessionEncadramentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionEncadrementServiceImpl implements SessionEncadrementService {

    private SessionEncadramentRepository sessionEncadrementRepository;
    private  SessionEncadrementMapper sessionEncadrementMapper;

    public SessionEncadrementServiceImpl(SessionEncadramentRepository sessionEncadrementRepository, SessionEncadrementMapper sessionEncadrementMapper) {
        this.sessionEncadrementRepository = sessionEncadrementRepository;
        this.sessionEncadrementMapper = sessionEncadrementMapper;
    }

    @Override
    public List<SessionEncadrementDTO> getAllSessionsEncadrement() {
        List<SessionEncadrement> sessionsEncadrement = sessionEncadrementRepository.findAll();
        return sessionsEncadrement.stream()
                .map(sessionEncadrementMapper::toSessionEncadrementDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SessionEncadrementDTO getSessionEncadrementById(Long sessionId) {
        SessionEncadrement sessionEncadrement = sessionEncadrementRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("SessionEncadrement not found"));
        return sessionEncadrementMapper.toSessionEncadrementDTO(sessionEncadrement);
    }
    @Override
    public SessionEncadrementDTO updateSessionEncadrement(Long sessionId, SessionEncadrementDTO sessionEncadrementDTO) {
        SessionEncadrement existingSessionEncadrement = sessionEncadrementRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("SessionEncadrement not found"));

        existingSessionEncadrement.setDate(sessionEncadrementDTO.getDate());
        existingSessionEncadrement.setDescription(sessionEncadrementDTO.getDescription());

        SessionEncadrement updatedSessionEncadrement = sessionEncadrementRepository.save(existingSessionEncadrement);
        return sessionEncadrementMapper.toSessionEncadrementDTO(updatedSessionEncadrement);
    }


    @Override
    public SessionEncadrementDTO saveSessionEncadrement(SessionEncadrementDTO sessionEncadrementDTO) {
        SessionEncadrement sessionEncadrement = sessionEncadrementMapper.fromSessionEncadrementDTO(sessionEncadrementDTO);
        SessionEncadrement savedSessionEncadrement = sessionEncadrementRepository.save(sessionEncadrement);
        return sessionEncadrementMapper.toSessionEncadrementDTO(savedSessionEncadrement);
    }

    @Override
    public void deleteSessionEncadrement(Long sessionId) {
        sessionEncadrementRepository.deleteById(sessionId);
    }

    @Override
    public List<SessionEncadrementDTO> getSessionsEncadrementByEtudiantId(Long etudiantId) {
        List<SessionEncadrement> sessionsEncadrement = sessionEncadrementRepository.findByEtudiantId(etudiantId);
        return sessionsEncadrement.stream()
                .map(sessionEncadrementMapper::toSessionEncadrementDTO)
                .collect(Collectors.toList());
    }

}
