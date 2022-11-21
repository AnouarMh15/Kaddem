package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.DetailEquipe;

import java.util.List;

public interface DetailEquipeService {
    List<DetailEquipe> getAllDetail();
    DetailEquipe addDetail(DetailEquipe E);
    DetailEquipe updateDetail(DetailEquipe E);
    void deleteDetail(Long id);
    DetailEquipe getdeqpbyid(Long id);
    List<DetailEquipe> findByThematiqueLike (String thematique);

}
