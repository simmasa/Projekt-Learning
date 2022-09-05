package com.example.projekt.repository;

import com.example.projekt.model.Capitolo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CapitoloRepository extends CrudRepository<Capitolo, Integer> {
    Optional<Capitolo> findByCorsi_IdAndNumeroCapitolo(Integer id, Integer numeroCapitolo);

    List<Capitolo> findByCorsi_IdOrderByNumeroCapitoloAsc(Integer id);





}