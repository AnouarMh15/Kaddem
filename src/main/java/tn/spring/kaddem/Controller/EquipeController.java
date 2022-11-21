package tn.spring.kaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.Equipe;
import tn.spring.kaddem.Entity.Niveau;
import tn.spring.kaddem.Services.EquipeServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {
    EquipeServiceImpl equipeService;

    //GetallEquipe
    @GetMapping("/getallEquipe")
    public List<Equipe> Geteqp(){

        return equipeService.retrieveAllEquipe();
    }
    //add new Equipe
    @PostMapping("/addEquipe")
    public void  addEqp(@RequestBody Equipe D){
        equipeService.addEquipe(D);
    }

    //update Equipe
    @PutMapping("/updateEquipe/{IdEquipe}")
    public void updateEqp(@PathVariable("IdEquipe") Long id, @RequestBody Equipe C){

        C.setIdEquipe(id);
        equipeService.updatEquipe(C);
    }
    //delete Equipe
    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe")Long idEquipe){
        equipeService.removeEquipe(idEquipe);
    }
    //findEquipe By Id
    @GetMapping("/getEquipe/{idEquipe}")
    public Equipe getEquipeById(@PathVariable("idEquipe")Long idEquipe){
        return equipeService.retrieveEquipe(idEquipe);
    }

    //find Equipe By IdEtudiant
    @GetMapping("/findEquipeByIdEtuidant/{idEtudiant}")
    public List<Equipe> findEquipeByIdEtudiant(@PathVariable("idEtudiant") Long id){

        return  equipeService.findEquipeByEtudiantsIdEtudiant(id);
    }
    //find Equipe By thematique
    @GetMapping("/findEquipeByThematique/{thematique}")
    public List<Equipe> findbyThematique(@PathVariable("thematique") String thematique){

        return  equipeService.findEquipeByDetailEquipeThematiqueLike(thematique);
    }
    //find Equipe ByIdEtuddiant And IdDepart
    @GetMapping("/findEquipeByIdEtudiantAndIdDepartement/{idEtudiant}/{idDepart}")
    public List<Equipe> findbyIdEtudiantAndIdDepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart") Long idDepartement){

        return  equipeService.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant,idDepartement);
    }
    //find Equipe By Thematique Nonull
    @GetMapping("/findEquipeByThematiqueNoNull/{idEtudiant}")
    public List<Equipe> findByThematiqueNoNull(@PathVariable("idEtudiant") Long id1){

        return  equipeService.findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(id1);
    }

    //delete EQUIPE By Niveau
    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public  void  DeleteEquipeByNiveau(@PathVariable Niveau niveau){
        equipeService.deleteEquipeByNiveau(niveau);
    }

    //find Equipe By niveau And thematique
    @GetMapping("/findEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> getEquipeByNiveauAndThematique(@PathVariable Niveau niveau,@PathVariable String thematique){

        return  equipeService.findEquipeByNiveauAndDetailEquipe_Thematique(niveau,thematique);
    }
}
