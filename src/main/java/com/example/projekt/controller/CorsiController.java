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
import java.util.stream.Collectors;

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
        m.addAttribute("corsiTop",topCorsi(5));
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
    public String corsiSearch(@RequestParam(name = "title",required = false) String titleReq,
                              @RequestParam(name = "doc",required = false) String docReq,
                              @RequestParam(name = "LD",required = false) Integer LDReq,
                              @RequestParam(name = "Cat",required = false) String CatReq,
                              Model m) {
        m.addAttribute("list",advSearchResult(titleReq,docReq,LDReq,CatReq));

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

//     public String[] splitQueryString(String req) {
//        if (req != null){
//            String[] parole = req.split(" ");
//            return parole;
//        }
//        return -1;
//     }
     public List<Corso> simSearchResult(String request){

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
    public List<Corso> advSearchResult(String title,String doc,Integer lvl,String catReq){

        List<Corso> inseg =new ArrayList<Corso>();
        if (doc != null) {
            String[] nomeCog = doc.split(" ");
            for (String i:
                    nomeCog) {
                inseg.addAll(corsiRepo.findByInsegnantis_NomeLikeIgnoreCaseOrderByNumVisualAsc(i));
                inseg.addAll(corsiRepo.findByInsegnantis_CognomeLikeIgnoreCaseOrderByNumVisualAsc(i));
            }
        }

        List<Corso> titleList = new ArrayList<Corso>();
        if (title != null) {
            String[] searchWord = title.split(" ");
            for (String i:
                 searchWord) {
                if (i.length()>2){
                    titleList.addAll(corsiRepo.findByTitoloContainsIgnoreCaseOrderByNumVisualDesc(i));
                }
            }
        }


        //List<Corso> name = corsiRepo.findByTitoloContainsIgnoreCaseOrderByNumVisualDesc(title);


        List<Corso> cat = corsiRepo.findByCategorie_NomeLikeIgnoreCaseOrderByNumVisualAsc(catReq);
        List<Corso> diff = corsiRepo.findByLivelloDifficolta(lvl);


        if (title != null && title.isBlank()) {

            assert doc != null;
            if ((!doc.isEmpty() || !catReq.isEmpty() || lvl != null)){
                titleList.removeAll(titleList);
            }
        }

        List<Corso> bigList = titleList;
        bigList.addAll(inseg);
        bigList.addAll(cat);
        bigList.addAll(diff);

        List<Corso> cleanList = bigList.stream().distinct().collect(Collectors.toList());

        return cleanList;
}
}
