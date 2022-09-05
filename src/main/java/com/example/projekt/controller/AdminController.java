package com.example.projekt.controller;


import com.example.projekt.model.Corsi;
import com.example.projekt.model.Insegnanti;
import com.example.projekt.repository.CategorieRepository;
import com.example.projekt.repository.CorsiRepository;
import com.example.projekt.repository.InsegnantiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {

 @Autowired
    private InsegnantiRepository ins;
 @Autowired
    private CorsiRepository corsi;
 @Autowired
     private CategorieRepository cat;


 @GetMapping
    public String List(Model model){
     model.addAttribute("insegnanti", ins.findAll());
     model.addAttribute("corsi", corsi.findAll());
     return"admin";

 }

 //MAPPING DEL FORM INSEGNANTI
 @GetMapping("/add")
    public String add(Model model) {
     model.addAttribute("AddInsegnanti", new Insegnanti());
     return "form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer idInsegnante, RedirectAttributes ra, Model model) {
        model.addAttribute("AddInsegnanti", ins.findById(idInsegnante));
        return "form";
    }


    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer idInsegnante) {
        ins.deleteById(idInsegnante);
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

//MAPPING DEL FORM CORSI

    @GetMapping("/addCorsi")
    public String addCorsi(Model model) {
        model.addAttribute("Categorie", cat.findAll());
        model.addAttribute("AddInsegnanti", ins.findAllByOrderByNome());
        model.addAttribute("AddCorsi", new Corsi());
        return "formCorsi";
    }

    @GetMapping("/delCorsi/{id}")
    public String delCorsi(@PathVariable("id") Integer idCorsi) {
        corsi.deleteById(idCorsi);
        return "redirect:/admin";
    }

    @GetMapping("/editCorsi/{id}")
    public String editCorsi(@PathVariable("id") Integer idCorsi, Model model) {
        model.addAttribute("Categorie", cat.findAll());
        model.addAttribute("AddInsegnanti", ins.findAllByOrderByNome());
        model.addAttribute("AddCorsi", corsi.findById(idCorsi));
        return "formCorsi";
    }

    @PostMapping("/saveCorsi")
    public String saveCorsi(@ModelAttribute("AddCorsi") Corsi formCorsi, Model model) {
        formCorsi.setDataCreazione(Date.valueOf(LocalDate.now()));
        formCorsi.setNumVisual(0L);
        corsi.save(formCorsi);
        return "redirect:/admin";

    }
}
