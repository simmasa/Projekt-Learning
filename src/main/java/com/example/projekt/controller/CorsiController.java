package com.example.projekt.controller;

import com.example.projekt.model.Corso;
import com.example.projekt.repository.CategorieRepository;
import com.example.projekt.repository.CorsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/corsi")
public class CorsiController {

    @Autowired
    public CorsiRepository corsiRepo;

    @Autowired
    public CategorieRepository catRepo;

    @GetMapping
    public String corsiQuery(@RequestParam(name = "cat",required = false) String cat, Model m) {
        if (cat!=null) {
            List<Corso> search = corsiRepo.findByCategorie_NomeLikeIgnoreCase(cat);
            m.addAttribute("corsi", search);
        }else {
            m.addAttribute("corsi", corsiRepo.findAll());
        }
        m.addAttribute("categorie",catRepo.findAll());
        m.addAttribute("corsiTop",topCorsi(3));
        return "Corsi";
    }

    @GetMapping("/{id}")
    public String corsiDetail (@PathVariable("id") Integer corsoId, Model m) {
        Optional<Corso> corso = corsiRepo.findById(corsoId);
        if (corso.isPresent()){
            m.addAttribute("corso", corso.get());
            incCorsoVis(corso.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossibile trovare corso con l'id specificato");
        }
        return "corsiDet";
    }

    @GetMapping("/search")
    public String corsiSearch(@RequestParam(name = "search",required = false) String request,Model m) {
        if (request!=null)
            m.addAttribute("list",cleanSearch(request));
        return"search";
    }

    public List<Corso> topCorsi(int numCorsi) {
        List<Corso> completa = corsiRepo.findByOrderByNumVisualDesc();
        List<Corso> top = new ArrayList<Corso>();
        for (int i=0;i<numCorsi;i++) {
            top.add(completa.get(i));
        }
        return top;
    }
     public void incCorsoVis(Corso corso) {
        long visual = corso.getNumVisual();
        visual+=1;
        corso.setNumVisual(visual);
        corsiRepo.save(corso);
     }
     public List<Corso> cleanSearch(String request){
        List<Corso> name = corsiRepo.findByTitoloContainsIgnoreCaseOrderByNumVisualDesc(request);
        List<Corso> prof = corsiRepo.findByInsegnantis_NomeLikeIgnoreCaseOrderByNumVisualAsc(request);
        List<Corso> cat = corsiRepo.findByCategorie_NomeLikeIgnoreCaseOrderByNumVisualAsc(request);

         for (Corso c : name) {
             prof.removeIf(p -> Objects.equals(p.getId(), c.getId()));
             cat.removeIf(ca -> Objects.equals(ca.getId(), c.getId()));
         }
         for (Corso p : prof) {
             cat.removeIf(ca -> Objects.equals(ca.getId(), p.getId()));
         }
         List<Corso> result = name;
         result.addAll(prof);
         result.addAll(cat);
         return result;
     }
}
