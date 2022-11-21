package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.Equipe;
import tn.spring.kaddem.Entity.Niveau;
import tn.spring.kaddem.Repository.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements EquipeService{
   EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public Equipe updatEquipe(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public void removeEquipe(Long id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe retrieveEquipe(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long id) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(id);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long id1, Long id2) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(id1, id2);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public List<Equipe> findEquipeByNiveauAndDetailEquipe_Thematique(Niveau niveau, String thematique) {
        return equipeRepository.findEquipeByNiveauAndDetailEquipe_Thematique(niveau, thematique);
    }
}
