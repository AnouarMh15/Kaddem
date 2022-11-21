package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.*;
import tn.spring.kaddem.Repository.ContartRepository;
import tn.spring.kaddem.Repository.DepartementRepository;
import tn.spring.kaddem.Repository.EquipeRepository;
import tn.spring.kaddem.Repository.EtudiantRepository;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ContartRepository contartRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public void removeEtudiant(Long id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        return Collections.singletonList(etudiantRepository.findEtudiantByDepartementIdDepartement(idDepartement));
    }


    @Override
    public Etudiant retrieveEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByprenom(String prenom) {
        return etudiantRepository.findEtudiantByPrenomE(prenom);
    }

    @Override
    public void updateEtudiantbyOption(Option op, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op,idEtudiant);

    }


    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void AssignEtudtoDepartement(Long idEtudiant, Long idDepart) {
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement=departementRepository.findById(idDepart).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContract, Long idEquipe) {
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        Contrat contrat=contartRepository.findById(idContract).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        etudiantRepository.save(e);
                return e;
    }
}
