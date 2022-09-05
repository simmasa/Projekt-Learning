package com.example.projekt.repository;

import com.example.projekt.model.Prenotazione;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrenotazioniRepository extends CrudRepository<Prenotazione, Integer> {
    Optional<Prenotazione> findByInsegnanti_IdOrderByDataPrenotazioneAsc(Integer id);
}