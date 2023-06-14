package ma.enset.gestionStage.services;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.ProjetDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import ma.enset.gestionStage.entities.Projet;
import ma.enset.gestionStage.entities.Stage;
import ma.enset.gestionStage.mappers.EtudiantMapper;
import ma.enset.gestionStage.mappers.StageMapper;
import ma.enset.gestionStage.repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StageServiceImp implements StageService {

    private StageRepository stageRepository;
    private StageMapper mapper;
    private final EtudiantMapper etudiantMapper;
    public List<StageDTO> getStagesByEtudiantId(Long etudiantId) {
        List<Stage> stages = new List<Stage>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Stage> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Stage stage) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Stage> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Stage> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Stage get(int index) {
                return null;
            }

            @Override
            public Stage set(int index, Stage element) {
                return null;
            }

            @Override
            public void add(int index, Stage element) {

            }

            @Override
            public Stage remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Stage> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Stage> listIterator(int index) {
                return null;
            }

            @Override
            public List<Stage> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        List<StageDTO> stageDTOS = stages
                .stream()
                .map(stage -> mapper.fromStage(stage))
                .collect(Collectors.toList()); //String to list
        return stageDTOS;
    }

    @Override
    public StageDTO saveStage(StageDTO stageDTO) {
        Stage stage=mapper.fromStageDTO(stageDTO);
        return mapper.fromStage(stageRepository.save(stage));
    }
    @Override
    public List<Object[]> countStagesByEntrepriseIgnoreCase() {
        return stageRepository.countStagesByEntrepriseIgnoreCase();
    }
    @Override
    public void assignEncadrantToStage(Long stageId, EncadrantPedagogique encadrant) {
        Stage stage = stageRepository.findById(stageId).orElse(null);
        if (stage != null) {
            stage.setEncadrantPedagogique(encadrant);
            stageRepository.save(stage);
        }
    }


    @Override
    public List<StageDTO> getStagesByEncadrant(EncadrantPedagogique encadrant) {
        List<Stage> stages = stageRepository.findByEncadrantPedagogique(encadrant);
        return stages.stream()
                .map(mapper::fromStage)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteStage(Long stageId) {
        stageRepository.deleteById(stageId);
    }

    @Override
    public StageDTO updateStage(Long stageId, StageDTO stageDTO) {
        Stage existingStage = stageRepository.findById(stageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid stage ID"));

        // Update the properties of existingStage with the values from stageDTO
        existingStage.setTitre(stageDTO.getTitre());
        existingStage.setDescription(stageDTO.getDescription());
        // Update other properties accordingly

        Stage updatedStage = stageRepository.save(existingStage);
        return mapper.fromStage(updatedStage);
    }

    @Override
    public StageDTO getStageById(Long stageId) {
        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid stage ID"));
        return mapper.fromStage(stage);
    }

    @Override
    public EtudiantDTO getEtudiantByStage(Long stageId) {
        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid stage ID"));

        if (stage.getEtudiant() != null) {
            return etudiantMapper.fromEtudiant(stage.getEtudiant());
        } else {
            throw new RuntimeException("Aucun étudiant associé à ce stage.");
        }
    }


}
