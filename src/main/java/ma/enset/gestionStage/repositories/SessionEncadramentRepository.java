package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.SessionEncadrement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionEncadramentRepository extends JpaRepository<SessionEncadrement, Long> {
    List<SessionEncadrement> findByEtudiantId(Long etudiantId);
}
