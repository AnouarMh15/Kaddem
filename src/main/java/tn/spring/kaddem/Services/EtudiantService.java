package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.Etudiant;
import tn.spring.kaddem.Entity.Option;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant E);
    Etudiant updateEtudiant(Etudiant E);
    Etudiant retrieveEtudiant(Long idEtudiant);
    void removeEtudiant(Long idEtudiant);
    List<Etudiant>getEtudiantsByDepartement(Long idDepartement);

    Etudiant findEtudiantByprenom(String prenom);

    void updateEtudiantbyOption(Option op , Long idEtudiant);

    List<Etudiant> retrieveEtudiantByEquipeThematique (  String thematique);
    public  void AssignEtudtoDepartement(Long idEtudiant, Long idDepart);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e,Long idContract,Long idEquipe);
}
