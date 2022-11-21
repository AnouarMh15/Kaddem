package tn.spring.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.kaddem.Entity.DetailEquipe;

import java.util.List;

public interface DetaiEquipeRepository extends JpaRepository<DetailEquipe,Long> {

    List<DetailEquipe> findByThematiqueLike (String thematique);


}
