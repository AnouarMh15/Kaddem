package tn.spring.kaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.Etudiant;
import tn.spring.kaddem.Entity.Option;
import tn.spring.kaddem.Services.EtudiantServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {

    EtudiantServiceImpl etudiantService;

    //get all Etudiant
    @GetMapping("/getallEtudiant")
    public List<Etudiant> getallEtudiant(){

        return  etudiantService.retrieveAllEtudiants();
    }
    //add new Etudiant
    @PostMapping("/addEtudiant")
    public void addEtud(@RequestBody Etudiant E){

        etudiantService.addEtudiant(E);
    }
    //update Etudiant
    @PutMapping("/updateEtudiant/{idEtudiant}")
    public void updateEtud(@PathVariable("idEtudiant") Long id, @RequestBody Etudiant E){

        E.setIdEtudiant(id);
        etudiantService.updateEtudiant(E);
    }
    //delete Etudiant
    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    public  void deleteEtud(@PathVariable("idEtudiant") Long id){

        etudiantService.removeEtudiant(id);
    }
    //get Etudiant ById
    @GetMapping("/getEtudiant/{idEtudiant}")
    public Etudiant getEtudiantbyid(@PathVariable("idEtudiant") Long id){

        return  etudiantService.retrieveEtudiant(id);
    }
    //find Etudiant Byprenom
    @GetMapping("/findEtudiantByPrenom/{prenom}")
    public Etudiant findEtd(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByprenom(prenom);
    }
    //updateEtudiant By Option
    @PutMapping("/updateEtudiantByOption/{option}/{idEtudiant}")
    public void updateEtudq(@PathVariable("option") Option option, @PathVariable("idEtudiant") Long id){

        etudiantService.updateEtudiantbyOption(option,id);
    }
    //find Etudiant By Thematique
    @GetMapping("/findEtudiantByThematique/{thematique}")
    public List<Etudiant> findEtudiantBythematiqueQuery(@PathVariable("thematique") String th){
        return etudiantService.retrieveEtudiantByEquipeThematique(th);
    }
    //Add Etudiant To Depart
    @PutMapping("/AddEtudiantToDepart/{idEtudiant}/{idDepart}")
    public  void assignEtudtoDep(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart") Long idDepart){
        etudiantService.AssignEtudtoDepartement(idEtudiant,idDepart);
    }
    //Add new Etudiant To Contrat And Equipe
    @PostMapping("/addEtudiantToEquipeAndContrat/{idContrat}/{idEquipe}")
    public void  addEtudtoEqpandContrat(@RequestBody Etudiant E,@PathVariable("idContrat") Long idC,@PathVariable("idEquipe") Long idEquipe){
        etudiantService.addAndAssignEtudiantToEquipeAndContract(E,idC,idEquipe);
    }
    //find Etudiant By idDePART
    @GetMapping("/findEtudiantByIdDepart/{idDepart}")
    public List<Etudiant> findEtudiantByIdDepart(@PathVariable("idDepart")Long idDepart){
        return etudiantService.getEtudiantsByDepartement(idDepart);
    }
}
