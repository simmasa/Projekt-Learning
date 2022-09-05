package com.example.projekt.repository;

import com.example.projekt.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categoria, Integer> {
}