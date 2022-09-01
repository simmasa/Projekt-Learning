package com.example.projekt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.projekt.model.Corsi;

public interface CorsiRepository extends CrudRepository<Corsi, Integer> {
	List<Corsi> findByOrderByNumVisualDesc();
}
