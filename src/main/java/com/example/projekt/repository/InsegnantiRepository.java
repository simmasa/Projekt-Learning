package com.example.projekt.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.example.projekt.model.Insegnanti;
import com.example.projekt.model.Prenotazioni;

public interface InsegnantiRepository extends CrudRepository<Insegnanti, Integer> {

	void save(@Valid Prenotazioni formPrenotazione);
}