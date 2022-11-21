package tn.spring.kaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.kaddem.Entity.Contrat;

import java.util.Date;
import java.util.List;

public interface ContartRepository extends JpaRepository<Contrat,Long> {
    //Contrat findContratBySpecialite(Specialite speciaite);
    //List<Contrat>findContratByDateDebutContratAndDateFinContrat(Date d, Date f);
    //Contrat findContratByDateDebutContrat(Date c);
    //List<Contrat> findContratByDateDebutContratAndDateFinContrat(Date datedebut,Date datefin);
    //List<Contrat> findByDateFinContratBefore(Date df);
}
