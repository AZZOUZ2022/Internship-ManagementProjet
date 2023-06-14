

package ma.enset.gestionStage.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SessionEncadrementDTO {
    private Long id;
    private Date date;
    private String description;
    private List<LivrableDTO> livrables;
    private EtudiantDTO etudiant;
    private EncadrantPedagogiqueDTO encadrantPedagogique;
}
