package com.example.projekt.controller;

import com.example.projekt.model.Corsi;
import com.example.projekt.repository.CategorieRepository;
import com.example.projekt.repository.CorsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Corsi")
public class SitiController {

    @Autowired
    public CorsiRepository corsiRepo;

    @Autowired
    public CategorieRepository catRepo;

    @GetMapping
    public String corsi(Model m) {
        m.addAttribute("corsi", corsiRepo.findAll());
        m.addAttribute("categorie",catRepo.findAll());
        m.addAttribute("corsiTop",topCorsi());
        return "Corsi";
    }

    public List<Corsi> topCorsi() {
        List<Corsi> completa = corsiRepo.findByOrderByNumVisualDesc();
        List<Corsi> top = new ArrayList<Corsi>();
        for (int i=0;i<3;i++) {
            top.add(i, completa.get(i));
        }
        return top;
    }
}
