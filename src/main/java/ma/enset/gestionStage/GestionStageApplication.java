package ma.enset.gestionStage;

import ma.enset.gestionStage.dtos.*;
import ma.enset.gestionStage.entities.*;
import ma.enset.gestionStage.mappers.*;
import ma.enset.gestionStage.security.entities.AppRole;
import ma.enset.gestionStage.security.entities.AppUser;
import ma.enset.gestionStage.security.services.AccountService;
import ma.enset.gestionStage.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Stream;


@SpringBootApplication
public class GestionStageApplication {
    public GestionStageApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionStageApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantService etudiantService,
                                        OffreDeStageService offreDeStageService,
                                        AdminService adminService,
                                        OffreDeStageMapper offreDeStageMapper,
                                        AccountService accountService,
                                        EnseignantService enseignantService,
                                        EncadrantPedagogiqueService encadrantPedagogiqueService,
                                        StageService stageService,
                                        StageMapper stageMapper, OffreStageService offreStageService,
                                        ProjetService projetService,PostesService postesService) {
        return (args) -> {
            final int[] i = {1};
            Stream.of("jimin", "jungkook", "namjoon").forEach(login -> {
                AdminDTO adminDTO = new AdminDTO();
                adminDTO.setId(i[0]);
                adminDTO.setLogin(login);
                adminDTO.setPassword(login + UUID.randomUUID());
                adminService.saveAdmin(adminDTO);
                i[0]++;
            });
            List<OffreStageDTO> offreStageDTOS = new ArrayList<>();
                Stream.of("Data Science", "Data Analyst", "Data Engineer", "Mobile Developer",
                        "Backend Developer", "Frontend Developer").forEach(post -> {
                    OffreDeStageDTO offreDeStageDTO = new OffreDeStageDTO();
                    offreDeStageDTO.setEntreprise("Informatique");
                    offreDeStageDTO.setDateDebut(new Date());
                    offreDeStageDTO.setDateFin(new Date());
                    offreDeStageDTO.setTechnologie("Java");
                    offreDeStageDTO.setDescription("");
                    offreDeStageDTO.setPoste(post);
                    OffreDeStage offreDeStage = offreDeStageService.saveOffreDeStage(offreDeStageMapper.DTOToOffreDeStage(offreDeStageDTO));
                    offreDeStageDTO.setId(offreDeStage.getId());
                });
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CHEF_FIL"));
            accountService.addNewRole(new AppRole(null, "ENCADRANT"));
            accountService.addNewRole(new AppRole(null, "ETUDIANT"));
            accountService.addNewRole(new AppRole(null, "ENSEIGNANT"));
            accountService.addNewUser(new AppUser(null, "admin", "admin", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Khiat", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Youssfi", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Safaa", "7777", new ArrayList<>()));
            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("Khiat", "CHEF_FIL");
            accountService.addRoleToUser("Khiat", "ENSEIGNANT");
            accountService.addRoleToUser("Youssfi", "ENCADRANT");
            accountService.addRoleToUser("Youssfi", "ENSEIGNANT");
            accountService.addRoleToUser("Safaa", "ETUDIANT");
            Stream.of("Khiat", "Youssfi").forEach(name -> {
                EnseignantDTO enseignantDTO = new EnseignantDTO();
                enseignantDTO.setNom(name);
                enseignantDTO.setUsername(name);
                enseignantDTO.setEmail(name + "@gmail.com");
                enseignantDTO.setResponsableFiliere(true);
                enseignantService.saveEnseignant(enseignantDTO);
            });
            Stream.of("Youssfi").forEach(name -> {
                EncadrantPedagogiqueDTO encadrantPedagogiqueDTO = new EncadrantPedagogiqueDTO();
                encadrantPedagogiqueDTO.setNom(name);
                encadrantPedagogiqueDTO.setUsername(name);
                encadrantPedagogiqueDTO.setEmail(name + "@gmail.com");
                encadrantPedagogiqueService.saveEncadrantPedagogique(encadrantPedagogiqueDTO);
            });
            Stream.of("Safaa").forEach(name -> {
                EtudiantDTO etudiantDTO = new EtudiantDTO();
                etudiantDTO.setNom(name);
                etudiantDTO.setUsername(name);
                etudiantDTO.setEmail(name + "@gmail.com");
                etudiantService.createEtudiant(etudiantDTO);
            });
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setLogin("admin");
            adminDTO.setPassword("admin");
            EtudiantDTO etudiantDTO = new EtudiantDTO();
            etudiantDTO.setNom("Kaoutar");
            etudiantDTO.setEmail("k");
            etudiantDTO.setUsername("kaoutar");
            etudiantDTO.setPrenom("BEN ESSARRAKH");
            etudiantDTO.setId(1L);
            etudiantDTO.setCIN("b12");
            etudiantDTO.setFiliere(new Filiere());
            etudiantDTO.setAdresse("adre");
            etudiantDTO.setCNE("sh");
            etudiantDTO.setPassword("1234");
            etudiantDTO.setTelephone("234324");

            adminService.saveAdmin(adminDTO);
            Stream.of("OCP", "OCP", "ONEP", "ADRIA", "ADRIA", "OCP", "SQLI", "SQLI", "ONEP").forEach(name -> {
                StageDTO stageDTO1 = new StageDTO();
               stageDTO1.setEntreprise(name);
                stageDTO1.setDescription(":)");
                stageDTO1.setEtudiantDTO(etudiantDTO);
                stageDTO1.setDescription("des");
                stageDTO1.setTitre("stage");
                stageDTO1.setDate_debut(new Date());
                stageDTO1.setAnnee_univ(null);
                stageDTO1.setDate_fin(new Date());
                stageService.saveStage(stageDTO1);
                StageDTO stageDTO2 = new StageDTO();
               stageDTO2.setEntreprise(name);
                stageDTO2.setDescription(":)");
                stageDTO2.setEtudiantDTO(etudiantDTO);
                stageDTO2.setDescription("des");
                stageDTO2.setTitre("stage");
                stageDTO2.setDate_debut(new Date());
                stageDTO2.setAnnee_univ(null);
                stageDTO2.setDate_fin(new Date());
                stageService.saveStage(stageDTO2);


                });
        };
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
