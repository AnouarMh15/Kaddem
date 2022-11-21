package tn.spring.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {

    @Query("SELECT departement From Departement departement ,Universite u where u.idUniversite=u.departements.size and u.idUniversite=:idUniv")
    List<Departement> retrieveDepartementsByUniversite(Long idUniv);

    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.idDepartement=e.departement.idDepartement and e.option = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);
}
