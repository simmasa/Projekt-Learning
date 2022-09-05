package com.example.projekt.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute("Prenotazioni", new Prenotazione());
		model.addAttribute("insegnanti", repo.findById(insegnantiId).get());
		return "prenotazioni";
	}

	@PostMapping("/detail/{id}/prenota/save")
	public String save(@Valid @ModelAttribute("Prenotazioni") Prenotazione formPrenotazioni,
			@PathVariable("id") Integer iId, BindingResult error) {

		if (error.hasErrors()) {
			return "prenotazioni";
		}
		formPrenotazioni.setInsegnanti(repo.findById(iId).get());
		repoPrenotazioni.save(formPrenotazioni);
		return "redirect:/";

	}
}
