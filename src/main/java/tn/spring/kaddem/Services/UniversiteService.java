package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Etudiant;
import tn.spring.kaddem.Entity.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> getAllUniversite();
    Universite addUniversite(Universite U);
    Universite updateUniversite(Universite U);
    void deleteUniversite(Long id);
    Universite getUniversiteById(Long id);
    public void assignDepartToUni(Long idU,Long dep);


}
