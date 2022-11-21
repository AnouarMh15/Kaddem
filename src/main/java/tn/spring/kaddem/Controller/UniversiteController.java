package tn.spring.kaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Universite;
import tn.spring.kaddem.Services.DepartementServiceImpl;
import tn.spring.kaddem.Services.UniversiteServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {
    UniversiteServiceImpl universiteService;
    DepartementServiceImpl departementService;
    //get all Universite
    @GetMapping("/getallUniversite")
    public List<Universite> GetUni(){

        return  universiteService.getAllUniversite();
    }
    //add new Univ
    @PostMapping("/addUniversite/")
    public void  addUniv(@RequestBody Universite U  ){
        universiteService.addUniversite(U);
    }
    //update Univ
    @PutMapping("/updateUniversite/{idUni}")
    public void updateUni(@PathVariable("idUni") Long id, @RequestBody Universite E){

        E.setIdUniversite(id);
        universiteService.updateUniversite(E);
    }
    //Delete Univ
    @DeleteMapping("/deleteUniversite/{idUni}")
    public  void deleteUni(@PathVariable("idUni") Long id){

        universiteService.deleteUniversite(id);
    }
    //Add Univ To Depart
    @PostMapping("/addUniversiteToDepartement/{idUni}/{idDepart}")
    public void  addUnivtoDep(@PathVariable("idUni") Long idU,@PathVariable("idDepart") Long id){
        universiteService.assignDepartToUni(idU, id);
    }
}
