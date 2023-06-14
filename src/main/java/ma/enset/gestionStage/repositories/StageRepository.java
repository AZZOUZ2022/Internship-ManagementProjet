package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.dtos.EntrepriseCountDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ma.enset.gestionStage.entities.Stage;
import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    @Query("SELECT LOWER(s.entreprise), COUNT(*) FROM Stage s GROUP BY LOWER(s.entreprise)")
    List<Object[]> countStagesByEntrepriseIgnoreCase();
    List<Stage> findByEtudiantId(Long etudiantId);
    List<Stage> findByEncadrantPedagogique(EncadrantPedagogique encadrant);

}
