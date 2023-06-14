package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EncadrantPedagogiqueMapperImpl implements EncadrantPedagogiqueMapper {

    @Override
    public EncadrantPedagogiqueDTO fromEncadrantPedagogique(EncadrantPedagogique encadrantPedagogique) {
        EncadrantPedagogiqueDTO encadrantPedagogiqueDTO = new EncadrantPedagogiqueDTO();
        BeanUtils.copyProperties(encadrantPedagogique, encadrantPedagogiqueDTO);
        return encadrantPedagogiqueDTO;
    }

    @Override
    public EncadrantPedagogique fromEncadrantPedagogiqueDTO(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO) {
        EncadrantPedagogique encadrantPedagogique = new EncadrantPedagogique();
        BeanUtils.copyProperties(encadrantPedagogiqueDTO, encadrantPedagogique);
        return encadrantPedagogique;
    }
}
