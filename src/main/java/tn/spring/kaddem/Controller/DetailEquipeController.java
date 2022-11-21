package tn.spring.kaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.kaddem.Entity.DetailEquipe;
import tn.spring.kaddem.Services.DetailEquipeServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailEquipeController {
    DetailEquipeServiceImpl detailEquipeService;
    //GetallDetailEquipe
    @GetMapping("/getallDetail")
    public List<DetailEquipe> getallDetailDetail(){
        return detailEquipeService.getAllDetail();
    }
    //add new Detail
    @PostMapping("/addDetail")
    public void addDetail(@RequestBody DetailEquipe d){
        detailEquipeService.addDetail(d);
    }
    //update Detail
    @PutMapping("/updateDetail/{idDetail}")
    public void updateDetail(@PathVariable("idDetail")Long idDetail,DetailEquipe d){
        d.setIdDetailEquipe(idDetail);
        detailEquipeService.updateDetail(d);
    }
    //delete Detail
    @DeleteMapping("/deleteDetail/{idDetail}")
    public void deleteDetail(@PathVariable("idDetail")Long idDetail){
        detailEquipeService.deleteDetail(idDetail);
    }
    //getDetail by thematique
    @GetMapping("/getDetail/{thematique}")
    public List<DetailEquipe> getDetailbyThematique(@PathVariable("thematique") String thematique){
        return detailEquipeService.findByThematiqueLike(thematique);
    }
}
