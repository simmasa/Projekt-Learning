package com.example.projekt.controller;

import com.example.projekt.model.Corso;
import com.example.projekt.repository.CorsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestControl {

    @Autowired
    public CorsiRepository repo;

    @GetMapping
    public List<Corso> getCorso() {
        return (List<Corso>) repo.findAll();
    }

    @GetMapping("/{id}/like")
    public Corso corsoLikes(@PathVariable("id") Integer cId) {
        Corso liked = repo.findById(cId).get();
        liked.setLikes(liked.getLikes()+1);
        return repo.save(liked);
    }

}
