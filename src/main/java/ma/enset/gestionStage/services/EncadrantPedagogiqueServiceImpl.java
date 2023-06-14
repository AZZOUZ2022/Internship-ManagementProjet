package ma.enset.gestionStage.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.entities.Stage;
import ma.enset.gestionStage.mappers.EncadrantPedagogiqueMapper;
import ma.enset.gestionStage.mappers.EtudiantMapper;
import ma.enset.gestionStage.mappers.StageMapper;
import ma.enset.gestionStage.repositories.EncadrantPedagogiqueRepository;
import ma.enset.gestionStage.repositories.StageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EncadrantPedagogiqueServiceImpl implements EncadrantPedagogiqueService {

    private final EncadrantPedagogiqueRepository encadrantPedagogiqueRepository;
    private final EncadrantPedagogiqueMapper encadrantPedagogiqueMapper;
    private final StageRepository stageRepository;
    private final StageMapper stageMapper;
    private final EtudiantMapper etudiantMapper;



    @Override
    public EncadrantPedagogiqueDTO saveEncadrantPedagogique(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO) {
        EncadrantPedagogique encadrantPedagogique = encadrantPedagogiqueMapper.fromEncadrantPedagogiqueDTO(encadrantPedagogiqueDTO);
        encadrantPedagogique = encadrantPedagogiqueRepository.save(encadrantPedagogique);
        return encadrantPedagogiqueMapper.fromEncadrantPedagogique(encadrantPedagogique);
    }


    @Override
    public EncadrantPedagogiqueDTO getEncadrantByUsername(String username) {
        EncadrantPedagogique encadrant = encadrantPedagogiqueRepository.findByUsername(username);
        return encadrantPedagogiqueMapper.fromEncadrantPedagogique(encadrant);
    }
    @Override
    public List<StageDTO> getStagesByEncadrant(Long encadrantId) {
        EncadrantPedagogique encadrant = encadrantPedagogiqueRepository.findById(encadrantId)
                .orElseThrow(() -> new RuntimeException("Encadrant not found"));

        List<Stage> stages = encadrant.getStageList();
        List<StageDTO> stageDTOs = new ArrayList<>();
        for (Stage stage : stages) {
            stageDTOs.add(stageMapper.fromStage(stage));
        }
        return stageDTOs;
    }
    @Override
    public List<EtudiantDTO> getEtudiantsByEncadrant(Long encadrantId) {
        EncadrantPedagogique encadrant = encadrantPedagogiqueRepository.findById(encadrantId)
                .orElseThrow(() -> new RuntimeException("Encadrant not found"));

        List<Etudiant> etudiants = encadrant.getStageList().stream()
                .map(stage -> stage.getEtudiant())
                .collect(Collectors.toList());

        List<EtudiantDTO> etudiantDTOs = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            etudiantDTOs.add(etudiantMapper.fromEtudiant(etudiant));
        }
        return etudiantDTOs;
    }
}
