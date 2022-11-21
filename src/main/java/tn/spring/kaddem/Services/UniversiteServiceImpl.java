package tn.spring.kaddem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Universite;
import tn.spring.kaddem.Repository.DepartementRepository;
import tn.spring.kaddem.Repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements UniversiteService {
UniversiteRepository universiteRepository;
DepartementRepository departementRepository;

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite U) {

        return universiteRepository.save(U) ;
    }

    @Override
    public Universite updateUniversite(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignDepartToUni(Long idU, Long dep) {
        Departement departement=departementRepository.findById(dep).orElse(null);
        Universite universite=universiteRepository.findById(idU).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);

    }


}
