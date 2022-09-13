package com.example.projekt.repository;

import com.example.projekt.model.Image;
import com.example.projekt.model.Insegnante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    //List<Image> findByInsegnante(Insegnante insegnante);


}