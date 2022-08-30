package com.example.projekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insegnanti")
public class Insegnanti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Lob
    @Column(name = "foto")
    private String foto;

    @OneToMany(mappedBy = "insegnanti", orphanRemoval = true)
    private List<Corsi> corsi = new ArrayList<>();

    @OneToMany(mappedBy = "insegnanti", orphanRemoval = true)
    private List<Prenotazioni> prenotazioni = new ArrayList<>();

    public List<Prenotazioni> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public List<Corsi> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corsi> corsi) {
        this.corsi = corsi;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}