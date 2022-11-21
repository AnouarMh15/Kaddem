package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.Contrat;
import tn.spring.kaddem.Entity.Specialite;

import java.util.Date;
import java.util.List;

public interface ContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat C);
    Contrat updateContrat(Contrat C);
    Contrat retrieveContrat(Long idContrat);
    void removeContrat(Long id);
    Contrat affectContratToEtudiant(Contrat ce,String prenomE,String nomE);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    long nbrContratValides(Date dateDebut,Date dateFin);
}
