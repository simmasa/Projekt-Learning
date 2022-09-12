package com.example.projekt.controller;


import com.example.projekt.model.*;
import com.example.projekt.repository.*;
import com.example.projekt.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

 @Autowired
    private InsegnantiRepository ins;
 @Autowired
    private CorsiRepository corsi;
 @Autowired
    private CategorieRepository cat;

 @Autowired
    private PrenotazioniRepository pre;

 @Autowired
 private ImageService img;

 @Autowired
 private ImageRepository imgRepo;


 @GetMapping
    public String List(@RequestParam(value = "iId", required = false) Integer iId,Model model){
     model.addAttribute("insegnanti", ins.findAll());
     model.addAttribute("corsi", corsi.findAll());
     model.addAttribute("topCorsi", corsi.findByOrderByNumVisualDesc());
     model.addAttribute("ultimi",corsi.findByDataCreazioneAfterOrderByDataCreazioneDesc(Date.valueOf(LocalDate.now().minusDays(7))));

     List<Prenotazione> req = pre.findByInsegnanti_IdOrderByDataPrenotazioneAsc(iId);

     model.addAttribute("preno",req);

     return"admin";

 }

 //MAPPING DEL FORM INSEGNANTI
 @GetMapping("/add")
    public String add(Model model) {
     model.addAttribute("AddInsegnanti", new Insegnante());
     model.addAttribute("imgForm", new ImageService().newImgForm());
     return "form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer idInsegnante, RedirectAttributes ra, Model model) {
        model.addAttribute("AddInsegnanti", ins.findById(idInsegnante));
        model.addAttribute("imgForm", new ImageService().newImgForm());
        return "form";
    }


    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer idInsegnante) {
        ins.deleteById(idInsegnante);
        return "redirect:/admin";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("AddInsegnanti") Insegnante formIns, BindingResult error,
                       @ModelAttribute("imgForm") ImageForm imgForm) throws IOException {

        if(error.hasErrors()) {
            return "form";
        }

        ins.save(formIns);
        img.newInsImage(imgForm, formIns.getId());

        return "redirect:/admin";

    }

//MAPPING DEL FORM CORSI

    @GetMapping("/addCorsi")
    public String addCorsi(Model model) {
        model.addAttribute("Categorie", cat.findAll());
        model.addAttribute("AddInsegnanti", ins.findAllByOrderByNome());
        model.addAttribute("AddCorsi", new Corso());
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
    public String saveCorsi(@ModelAttribute("AddCorsi") Corso formCorsi, Model model) {
        formCorsi.setDataCreazione(Date.valueOf(LocalDate.now()));
        formCorsi.setNumVisual(0L);
        corsi.save(formCorsi);
        return "redirect:/admin";

    }
}
