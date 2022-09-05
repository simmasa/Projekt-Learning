package com.example.projekt.controller;

import com.example.projekt.model.Capitolo;
import com.example.projekt.model.Corsi;
import com.example.projekt.repository.CapitoloRepository;
import com.example.projekt.repository.CorsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/corsi/{corsoId}/{capNum}", method = GET)
public class CapController {

    @Autowired
    public CapitoloRepository repo;

    @Autowired
    public CorsiRepository corso;

    @GetMapping
    public String capitolo(@PathVariable int corsoId, @PathVariable int capNum, Model m){
        Optional<Capitolo> cap = repo.findByCorsi_IdAndNumeroCapitolo(corsoId,capNum);
        m.addAttribute("capitolo", cap.get());
        return "Capitolo";
    }
}
