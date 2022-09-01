package com.example.projekt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projekt.model.Corsi;
import com.example.projekt.repository.CorsiRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CorsiRepository corsiRepo;

	@GetMapping
	public String corsiList(Model model) {
		model.addAttribute("corsi", corsiRepo.findAll());
		model.addAttribute("corsiTop", corsiRepo.findByOrderByNumVisualDesc());
		return "home";
	}

	public List<Corsi> topCorsi() {
		List<Corsi> completa = corsiRepo.findByOrderByNumVisualDesc();
		List<Corsi> top = new ArrayList<Corsi>();
		for (int i = 0; i < 4; i++) {
			top.add(completa.get(i));
		}
		return top;
	}
}
