package com.example.projekt.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.projekt.model.Corso;

public interface CorsiRepository extends CrudRepository<Corso, Integer> {
	List<Corso> findByOrderByNumVisualDesc();

	List<Corso> findByCategorie_NomeLikeIgnoreCase(String nome);

	List<Corso> findByDataCreazioneAfterOrderByDataCreazioneDesc(Date dataCreazione);

	List<Corso> findByTitoloContainsIgnoreCaseOrderByNumVisualDesc(String titolo);

	List<Corso> findByInsegnantis_NomeLikeIgnoreCaseOrderByNumVisualAsc(String nome);

	List<Corso> findByCategorie_NomeLikeIgnoreCaseOrderByNumVisualAsc(String nome);

	List<Corso> findByInsegnantis_CognomeLikeIgnoreCaseOrderByNumVisualAsc(String cognome);

	List<Corso> findByTags_IdLike(int id);

	List<Corso> findByLivelloDifficolta(Integer livelloDifficolta);

}