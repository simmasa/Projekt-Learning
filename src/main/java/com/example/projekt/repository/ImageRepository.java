package com.example.projekt.repository;

import com.example.projekt.model.Image;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    Optional<Image> findFirstByIdOrderByIdDesc(Integer id);

    List<Image> findByIdOrderByIdDesc(Integer id);



}