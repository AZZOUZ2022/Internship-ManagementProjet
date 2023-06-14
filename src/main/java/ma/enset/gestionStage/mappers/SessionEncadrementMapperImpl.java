package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.SessionEncadrementDTO;
import ma.enset.gestionStage.entities.SessionEncadrement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

//@Service
//@AllArgsConstructor
//public class SessionEncadrementMapperImpl implements SessionEncadrementMapper {
//    @Override
//    public SessionEncadrementDTO toSessionEncadrementDTO(SessionEncadrement sessionEncadrement) {
//        SessionEncadrementDTO sessionEncadrementDTO = new SessionEncadrementDTO();
//        BeanUtils.copyProperties(sessionEncadrement, sessionEncadrementDTO);
//        return sessionEncadrementDTO;
//    }
//
//    @Override
//    public SessionEncadrement fromSessionEncadrementDTO(SessionEncadrementDTO sessionEncadrementDTO) {
//        SessionEncadrement sessionEncadrement = new SessionEncadrement();
//        BeanUtils.copyProperties(sessionEncadrementDTO, sessionEncadrement);
//        return sessionEncadrement;
//    }
//}


@Service
@AllArgsConstructor
public class SessionEncadrementMapperImpl implements SessionEncadrementMapper {
    private EtudiantMapper etudiantMapper;

    @Override
    public SessionEncadrementDTO toSessionEncadrementDTO(SessionEncadrement sessionEncadrement) {
        SessionEncadrementDTO sessionEncadrementDTO = new SessionEncadrementDTO();
        BeanUtils.copyProperties(sessionEncadrement, sessionEncadrementDTO);

        // Map the Etudiant entity to EtudiantDTO explicitly
        sessionEncadrementDTO.setEtudiant(etudiantMapper.fromEtudiant(sessionEncadrement.getEtudiant()));

        return sessionEncadrementDTO;
    }

    @Override
    public SessionEncadrement fromSessionEncadrementDTO(SessionEncadrementDTO sessionEncadrementDTO) {
        SessionEncadrement sessionEncadrement = new SessionEncadrement();
        BeanUtils.copyProperties(sessionEncadrementDTO, sessionEncadrement);

        // Map the EtudiantDTO to Etudiant entity explicitly
        sessionEncadrement.setEtudiant(etudiantMapper.fromEtudiantDTO(sessionEncadrementDTO.getEtudiant()));

        return sessionEncadrement;
    }

}
