package com.example.projekt.repository;

import com.example.projekt.model.Prenotazione;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrenotazioniRepository extends CrudRepository<Prenotazione, Integer> {
    List<Prenotazione> findByInsegnanti_IdOrderByDataPrenotazioneAsc(Integer id);

    List<Prenotazione> findByInsegnanti_Id(Integer id);


}