package com.example.projekt.repository;


import com.example.projekt.model.Insegnanti;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsegnantiRepository extends CrudRepository<Insegnanti, Integer> {

    List<Insegnanti> findAllByOrderByNome();
}