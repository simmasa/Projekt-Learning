package com.example.projekt.repository;

import com.example.projekt.model.Corso;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface CorsiRepository extends CrudRepository<Corso, Integer> {
    List<Corso> findByOrderByNumVisualDesc();

    List<Corso> findByCategorie_NomeLikeIgnoreCase(String nome);

    List<Corso> findByDataCreazioneAfterOrderByDataCreazioneDesc(Date dataCreazione);

    List<Corso> findByTitoloContainsIgnoreCaseOrderByNumVisualDesc(String titolo);

    List<Corso> findByInsegnantis_NomeLikeIgnoreCaseOrderByNumVisualAsc(String nome);

    List<Corso> findByCategorie_NomeLikeIgnoreCaseOrderByNumVisualAsc(String nome);

    List<Corso> findByInsegnantis_CognomeLikeIgnoreCaseOrderByNumVisualAsc(String cognome);



    List<Corso> findByLivelloDifficolta(Integer livelloDifficolta);


}