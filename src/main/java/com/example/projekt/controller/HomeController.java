package com.example.projekt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projekt.model.Corso;
import com.example.projekt.repository.CapitoloRepository;
import com.example.projekt.repository.CorsiRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CorsiRepository corsiRepo;

	@Autowired
	private CapitoloRepository capitoloRepo;

	@GetMapping
	public String corsiList(Model model) {
		model.addAttribute("corsi", corsiRepo.findAll());
		model.addAttribute("corsiTop", corsiRepo.findByOrderByNumVisualDesc());
		model.addAttribute("capitolo", capitoloRepo.findAll());
		return "home";
	}

	public List<Corso> topCorsi() {
		List<Corso> completa = corsiRepo.findByOrderByNumVisualDesc();
		List<Corso> top = new ArrayList<Corso>();
		for (int i = 0; i < 4; i++) {
			top.add(completa.get(i));
		}
		return top;
	}
}
