package ma.enset.gestionStage.dtos;

import lombok.Data;
import ma.enset.gestionStage.entities.SessionEncadrement;

import java.util.Date;

@Data
public class LivrableDTO {
    private Long id;
    private String path;
    private Date dateRemise;
    private SessionEncadrement sessionEncadrement;
}
