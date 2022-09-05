package com.example.projekt.controller;


import com.example.projekt.model.Insegnanti;
import com.example.projekt.repository.CorsiRepository;
import com.example.projekt.repository.InsegnantiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

 @Autowired
    private InsegnantiRepository ins;
 @Autowired
    private CorsiRepository corsi;


 @GetMapping
    public String List(Model model){
     model.addAttribute("insegnanti", ins.findAll());
     model.addAttribute("corsi", corsi.findAll());
     return"admin";

 }

 //GET MAPPING DELL'AGGIUNGI
 @GetMapping("/add")
    public String add(Model model) {
     model.addAttribute("AddInsegnanti", new Insegnanti());
     return "form";
    }


    @GetMapping("/cancella/{id}")
    public String delete(@PathVariable("id") Integer idInsegnante, RedirectAttributes ra) {
        ins.deleteById(idInsegnante);
        ra.addFlashAttribute("bravo", "Oggetto Cancellato con successo!");
        return "redirect:/admin";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("AddInsegnanti") Insegnanti formIns, BindingResult error) {

        if(error.hasErrors()) {
            return "form";
        }
        ins.save(formIns);
        return "redirect:/admin";

    }


}
