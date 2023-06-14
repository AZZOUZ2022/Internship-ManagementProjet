package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;

import java.util.List;

public interface EncadrantPedagogiqueService {

    EncadrantPedagogiqueDTO getEncadrantByUsername(String username);
    List<StageDTO> getStagesByEncadrant(Long encadrantId);
    List<EtudiantDTO> getEtudiantsByEncadrant(Long encadrantId);
    public EncadrantPedagogiqueDTO saveEncadrantPedagogique(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO);
}
