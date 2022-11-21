package tn.spring.kaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.Departement;
import tn.spring.kaddem.Entity.Option;
import tn.spring.kaddem.Services.DepartementServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartementController {

    DepartementServiceImpl departementService;

    //GetallDepartement
    @GetMapping("/getallDepartement")
    public List<Departement> getallDepartement(){
        return departementService.retrieveAllDepartement();
    }
    //add new Departement
    @PostMapping("/addDepartement")
    public void addDepartement(@RequestBody Departement d){
        departementService.addDepartement(d);
    }
    //update Depart
    @PutMapping("/updateDepartement/{idDepart}")
    public void updateDepart(@PathVariable("idDepart")Long idDepart,Departement d){
        d.setIdDepartement(idDepart);
        departementService.updateDepartement(d);
    }
    //delete Depart
    @DeleteMapping("/deleteDepartement/{idDepart}")
    public void deleteDepart(@PathVariable("idDepart")Long idDepart){
        departementService.deleteDepartement(idDepart);
    }
    //get Depart By Id
    @GetMapping("/getDepart/{idDepart}")
    public Departement getDepartById(@PathVariable("idDepart")Long idDepart){
        return departementService.retrieveDepartement(idDepart);
    }

    //getDepart by option
    @GetMapping("/getDepartementByOption/{option}")
    public List<Departement> getDepartbyOption(@PathVariable("option")Option option){
        return departementService.retrieveDepartementByOptionEtudiant(option);
    }
    //addDepartToUniv
    @PostMapping("/addnewDepartToUniv/{idUniv}")
    public void addnewDepartToUniv(@PathVariable("idUniv")Long idUniv,@RequestBody Departement departement){
        departementService.addAndAssignDepartToUniv(departement,idUniv);
    }
    //find Departement By idUniv
    @GetMapping("/findDepartByIdUniv/{idUniv}")
    public List<Departement> findDepartByIdUniv(@PathVariable("idUniv")Long idUniv){
        return departementService.retrieveDepartementsByUniversite(idUniv);
    }
}
