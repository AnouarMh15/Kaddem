package tn.spring.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.spring.kaddem.Entity.Etudiant;
import tn.spring.kaddem.Entity.Option;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByPrenomE(String prenom);
    Etudiant findEtudiantByPrenomEAndAndNomE(String prenomE,String nomE);
    Etudiant findEtudiantByDepartementIdDepartement(Long idDepartement);

    @Modifying
    @Transactional
    @Query(" update Etudiant set option = :op where idEtudiant = :idEtudiant")
    void updateEtudiantByOption(@Param("op") Option op , @Param("idEtudiant") Long idEtudiant);


    @Query("SELECT etudiant FROM Etudiant etudiant"
            + " INNER JOIN etudiant.equipes equipe"
            + " INNER JOIN DetailEquipe detail"
            + " ON detail.idDetailEquipe = equipe.idEquipe"
            + " where detail.thematique= :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (@Param("thematique") String thematique);

}
