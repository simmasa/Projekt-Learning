package com.example.projekt.repository;


import com.example.projekt.model.Insegnante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsegnantiRepository extends CrudRepository<Insegnante, Integer> {

    List<Insegnante> findAllByOrderByNome();
}