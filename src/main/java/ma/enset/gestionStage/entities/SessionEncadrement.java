package ma.enset.gestionStage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "session_encadrement")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class SessionEncadrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    @OneToMany(mappedBy = "sessionEncadrement")
    private List<Livrable> livrable;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private EncadrantPedagogique encadrantPedagogique;


}
