package tn.spring.kaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.Contrat;
import tn.spring.kaddem.Services.ContratServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class ContratController {
    ContratServiceImpl contratService;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //Get_All_Contrat
    @GetMapping("/getallContrat")
    public List<Contrat> getallcontrats(){
        return contratService.retrieveAllContrats();
    }
    //Add new Contrat
    @PostMapping("/addContrat")
    public void addnewContrat(@RequestBody Contrat c){
        contratService.addContrat(c);
    }
    //Update contrat
    @PutMapping("/updateContrat/{idContrat}")
    public void updateContrat(@PathVariable("idContrat") Long idContrat,@RequestBody Contrat c){
        c.setIdContrat(idContrat);
        contratService.updateContrat(c);
    }
    //Delete Contrat
    @DeleteMapping("/deleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable ("idContrat")Long idContrat){
        contratService.removeContrat(idContrat);
    }

    //get Contrat ById
    @GetMapping("/getContrat/{idContrat}")
    public Contrat getContratbyid(@PathVariable("idContrat") Long idContrat){
        return  contratService.retrieveContrat(idContrat);
    }
    //Add Contrat To Etudiant
    @PostMapping ("/AddContratToEtudiant/{prenomE}_{nomE}")
    public  void assignContratToEtudiant(@PathVariable("prenomE") String prenomE,@PathVariable("nomE") String nomE,@RequestBody Contrat ce){
        contratService.affectContratToEtudiant(ce, prenomE,nomE);
    }
    //getChiffre
    @GetMapping  ("/getchiffre/{dateD}/{dateF}")
    public float getchiffre(@PathVariable("dateD")Date dateD,@PathVariable("dateF")Date dateF){

        return contratService.getChiffreAffaireEntreDeuxDate(dateD,dateF);
    }
    //getContratValide
    @GetMapping  ("/getContratValide/{dateD}/{dateF}")
    public float getContratValide(@PathVariable("dateD")Date dateD,@PathVariable("dateF")Date dateF){

        return contratService.nbrContratValides(dateD,dateF);
    }

}
