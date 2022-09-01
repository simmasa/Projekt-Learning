package com.example.projekt.repository;

import com.example.projekt.model.Corsi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CorsiRepository extends CrudRepository<Corsi, Integer> {
    List<Corsi> findByOrderByNumVisualDesc();

    List<Corsi> findByCategorie_NomeLikeIgnoreCase(String nome);



}