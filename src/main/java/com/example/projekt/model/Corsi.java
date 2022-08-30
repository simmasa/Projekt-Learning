package com.example.projekt.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corsi")
public class Corsi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titolo", nullable = false, unique = true)
    private String titolo;

    @Lob
    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "livello_difficolta")
    private Integer livelloDifficolta;

    @Column(name = "durata")
    private Integer durata;

    @Column(name = "data_creazione", nullable = false)
    private Date dataCreazione;


    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getLivelloDifficolta() {
        return livelloDifficolta;
    }

    public void setLivelloDifficolta(Integer livelloDifficolta) {
        this.livelloDifficolta = livelloDifficolta;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}