
package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.SessionEncadrementDTO;
import ma.enset.gestionStage.entities.SessionEncadrement;

public interface SessionEncadrementMapper {
    SessionEncadrementDTO toSessionEncadrementDTO(SessionEncadrement sessionEncadrement);
    SessionEncadrement fromSessionEncadrementDTO(SessionEncadrementDTO sessionEncadrementDTO);
}
