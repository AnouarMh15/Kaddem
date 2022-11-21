package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.DetailEquipe;
import tn.spring.kaddem.Repository.DetaiEquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServiceImpl implements DetailEquipeService{
    DetaiEquipeRepository detaiEquipeRepository;
    @Override
    public List<DetailEquipe> getAllDetail() {
        return detaiEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetail(DetailEquipe E) {
        return detaiEquipeRepository.save(E);
    }

    @Override
    public DetailEquipe updateDetail(DetailEquipe E) {
        return detaiEquipeRepository.save(E);
    }

    @Override
    public void deleteDetail(Long id) {
        detaiEquipeRepository.deleteById(id);

    }

    @Override
    public DetailEquipe getdeqpbyid(Long id) {
        return detaiEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detaiEquipeRepository.findByThematiqueLike(thematique);
    }
}
