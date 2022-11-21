package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.Contrat;
import tn.spring.kaddem.Entity.Etudiant;
import tn.spring.kaddem.Entity.Specialite;
import tn.spring.kaddem.Repository.ContartRepository;
import tn.spring.kaddem.Repository.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService{

    ContartRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat E) {
        return contratRepository.save(E);
    }

    @Override
    public Contrat updateContrat(Contrat E) {
        return contratRepository.save(E);
    }

    @Override
    public void removeContrat(Long id) {
        contratRepository.deleteById(id);

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String prenomE,String nomE) {
        Etudiant etudiant= etudiantRepository.findEtudiantByPrenomEAndAndNomE(prenomE,nomE);

        if (etudiant.getContrats().stream().count()<5) {
            ce.setEtudiant(etudiant);
            etudiant.getContrats().add(ce);
            contratRepository.save(ce);

            return ce;
        }
        return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float Chiffre=0;
        int month=1;
        List<Contrat> contrat=contratRepository.findAll();
        for(int i=0;i<contrat.size();i++){
            Contrat c=contrat.get(i);
            @Deprecated
            int yd= c.getDateDebutContrat().getYear();
            @Deprecated
            int md= c.getDateDebutContrat().getMonth();
            @Deprecated
            int dd= c.getDateDebutContrat().getDay();
            @Deprecated
            int yf= c.getDateFinContrat().getYear();
            @Deprecated
            int mf= c.getDateFinContrat().getMonth();
            @Deprecated
            int df= c.getDateFinContrat().getDay();
            if ((yf!=yd)&&(mf>md)) {
                month = ((yf-yd)*12)+(mf-md);
            } else if ((yf==yd)&&(mf>md)){
                month = mf - md;
            }
            else {
                month=1;
            }
        }
        for(int j=0;j<contrat.size();j++){
            Contrat ch=contrat.get(j);
            if (ch.getSpecialite()== Specialite.IA){
                Chiffre=300*month;
            }
            else if (ch.getSpecialite()==Specialite.RESEAUX){
                Chiffre=350*month;
            }
            else if (ch.getSpecialite()==Specialite.CLOUD){
                Chiffre=400*month;
            }
            else if (ch.getSpecialite()==Specialite.SECURITE){
                Chiffre=450*month;
            }
        }

        return Chiffre;
    }

    @Override
    public long nbrContratValides(Date dateDebut, Date dateFin) {
        int nbrContrat=0;
        List<Contrat> contrats=contratRepository.findAll();
        for(int i=0;i<contrats.size();i++){
            Contrat c=contrats.get(i);
            if (c.isArchive()==false){
                nbrContrat++;
            }

        }

        return nbrContrat;
    }


    @Override
    public Contrat retrieveContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }
}
