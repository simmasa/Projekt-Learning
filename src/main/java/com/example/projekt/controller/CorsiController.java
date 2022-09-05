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
}
