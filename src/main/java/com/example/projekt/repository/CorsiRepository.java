package com.example.projekt.repository;

import com.example.projekt.model.Corso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CorsiRepository extends CrudRepository<Corso, Integer> {
    List<Corso> findByOrderByNumVisualDesc();

    List<Corso> findByCategorie_NomeLikeIgnoreCase(String nome);

}