package com.example.projekt.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.projekt.model.Insegnante;
import com.example.projekt.model.Prenotazione;
import com.example.projekt.repository.InsegnantiRepository;
import com.example.projekt.repository.PrenotazioniRepository;

@Controller
@RequestMapping("/insegnanti")
public class InsegnantiController {

	@Autowired
	private InsegnantiRepository repo;

	@Autowired
	private PrenotazioniRepository repoPrenotazioni;

	@GetMapping
	public String insegnantiList(Model model) {
		model.addAttribute("insegnanti", repo.findAll());
		return "insegnanti";
	}

	@GetMapping("/detail/{id}")
	public String insegnantiDetail(Model model, @PathVariable(name = "id") Integer id) {

		Optional<Insegnante> queryResult = repo.findById(id);
		if (queryResult.isPresent()) {
			Insegnante insegnanti = queryResult.get();
			model.addAttribute("insegnanti", insegnanti);
			return "insegnantiDetail";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "insegnante non trovato");
		}

	}

	@GetMapping("/detail/{id}/prenota")
	public String prenotazioniForm(@PathVariable("id") Integer insegnantiId, Model model) {
		model.addAttribute("prenotazione", new Prenotazione());
		model.addAttribute("inseg" , repo.findById(insegnantiId).get());
		return "prenotazioni";
	}

	@PostMapping("/detail/{id}/prenota/save")
	public String save(@Valid @ModelAttribute("prenotazione") Prenotazione formPrenotazioni, BindingResult error,
			@PathVariable("id") Integer iId, Model m) {

		boolean err= error.hasErrors();
		formPrenotazioni.setInsegnanti(repo.findById(iId).get());
		if (!isAvailable(formPrenotazioni)) {
			error.addError(new FieldError("prenotazione","slotOrari","Slot orario non disponibile"));
			err=true;
		}

		if (err) {
			m.addAttribute("inseg" , repo.findById(iId).get());
			return "prenotazioni";
		}else {

		try {
			repoPrenotazioni.save(formPrenotazioni);
		}catch (Exception e) {
			m.addAttribute("errore","C'è stato un errore durante il salvataggio della prenotazione");
		}
		return "redirect:/insegnanti/detail/" + formPrenotazioni.getInsegnanti().getId();
		}



	}

	public Boolean isAvailable(Prenotazione form){
		List<Prenotazione> precedenti = repoPrenotazioni.findByInsegnanti_Id(form.getInsegnanti().getId());
		for (Prenotazione p:
			 precedenti) {
			if (form.getDataPrenotazione().equals(p.getDataPrenotazione())) {
				if(Objects.equals(form.getSlotOrari(), p.getSlotOrari())) {
				return false;

				}			}
		}
		return true;
	}
}
