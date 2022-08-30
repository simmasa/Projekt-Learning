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

    @ManyToMany
    @JoinTable(name = "insegnanti_corsis",
            joinColumns = @JoinColumn(name = "insegnanti_id"),
            inverseJoinColumns = @JoinColumn(name = "corsis_id"))
    private List<Corsi> corsis = new ArrayList<>();

    @OneToMany(mappedBy = "insegnanti", orphanRemoval = true)
    private List<Prenotazioni> prenotazionis = new ArrayList<>();

    public List<Prenotazioni> getPrenotazionis() {
        return prenotazionis;
    }

    public void setPrenotazionis(List<Prenotazioni> prenotazionis) {
        this.prenotazionis = prenotazionis;
    }

    public List<Corsi> getCorsis() {
        return corsis;
    }

    public void setCorsis(List<Corsi> corsis) {
        this.corsis = corsis;
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