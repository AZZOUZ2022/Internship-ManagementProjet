package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import ma.enset.gestionStage.entities.Stage;


import java.util.List;

public interface StageService {
    public List<StageDTO> getStagesByEtudiantId(Long etudiantId);
    StageDTO saveStage(StageDTO stage);
    List<Object[]> countStagesByEntrepriseIgnoreCase();

    public void assignEncadrantToStage(Long stageId, EncadrantPedagogique encadrant);


    List<StageDTO> getStagesByEncadrant(EncadrantPedagogique encadrant);

    void deleteStage(Long stageId);
    StageDTO updateStage(Long stageId, StageDTO stageDTO);
    public StageDTO getStageById(Long stageId);
    public EtudiantDTO getEtudiantByStage(Long stageId) ;
    //public List<StageDTO> getStagesByAnneeUniversitaire(Annee_universitaire anneeUniversitaire);

}
