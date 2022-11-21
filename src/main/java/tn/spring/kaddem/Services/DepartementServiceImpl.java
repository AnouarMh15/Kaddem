package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Option;
import tn.spring.kaddem.Entity.Universite;
import tn.spring.kaddem.Repository.DepartementRepository;
import tn.spring.kaddem.Repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService{
    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;
    @Override
    public List<Departement> retrieveAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public Departement updateDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);

    }

    @Override
    public Departement retrieveDepartement(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Long idUniv) {
        return  departementRepository.retrieveDepartementsByUniversite(idUniv);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

    @Override
    public Departement addAndAssignDepartToUniv(Departement d, Long idUniv) {
        Universite universite=universiteRepository.findById(idUniv).orElse(null);
        universite.getDepartements().add(d);
        departementRepository.save(d);
        return d;
    }
}
