package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.Equipe;
import tn.spring.kaddem.Entity.Niveau;

import java.util.List;

public interface EquipeService {
    List<Equipe> retrieveAllEquipe();
    Equipe addEquipe(Equipe E);
    Equipe updatEquipe(Equipe E);
    void removeEquipe(Long id);
    Equipe retrieveEquipe(Long id);

    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe>findEquipeByDetailEquipeThematiqueLike(String th);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long id);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long id1,Long id2);
    void deleteEquipeByNiveau( Niveau niveau);
    List<Equipe> findEquipeByNiveauAndDetailEquipe_Thematique(Niveau niveau ,String thematique);

}
