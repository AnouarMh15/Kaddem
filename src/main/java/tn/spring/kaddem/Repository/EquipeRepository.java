package tn.spring.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.spring.kaddem.Entity.Equipe;
import tn.spring.kaddem.Entity.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idEtudinat,Long idDepartement);
    List<Equipe> findEquipeByNiveauAndDetailEquipe_Thematique(Niveau niveau,String thematique);
    @Transactional
    @Modifying
    @Query("delete from Equipe e")
    void deleteEquipeByNiveau(Niveau niveau);


    @Query("SELECT  equipe from Equipe equipe , DetailEquipe deq where equipe.idEquipe = deq.equipe.idEquipe and deq.thematique= :thematique and equipe.niveau= :niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau ,@Param("thematique") String thematique);


}
