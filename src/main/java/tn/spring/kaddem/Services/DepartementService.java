package tn.spring.kaddem.Services;

import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Option;
import tn.spring.kaddem.Entity.Universite;

import java.util.List;

public interface DepartementService {

    List<Departement> retrieveAllDepartement();
    Departement addDepartement(Departement D);
    Departement updateDepartement(Departement D);
    void deleteDepartement(Long id);
    Departement retrieveDepartement(Long id);
    List<Departement> retrieveDepartementsByUniversite(Long idUniv);

    List<Departement> retrieveDepartementByOptionEtudiant( Option op);

    Departement addAndAssignDepartToUniv(Departement d, Long idUniv);

}


