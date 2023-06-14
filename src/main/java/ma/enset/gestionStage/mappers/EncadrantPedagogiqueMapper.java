package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;

public interface EncadrantPedagogiqueMapper {
    EncadrantPedagogiqueDTO fromEncadrantPedagogique(EncadrantPedagogique encadrantPedagogique);
    EncadrantPedagogique fromEncadrantPedagogiqueDTO(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO);


}
