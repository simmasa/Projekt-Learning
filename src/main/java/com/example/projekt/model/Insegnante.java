package com.example.projekt.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insegnanti")
public class Insegnante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Riempi il campo nome")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotEmpty(message = "Riempi il campo cognome")
    @Column(name = "cognome", nullable = false)
    private String cognome;

    @OneToMany(mappedBy = "insegnanti", orphanRemoval = true)
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    @ManyToMany(mappedBy = "insegnantis")
    private List<Corso> corsi = new ArrayList<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "image_id")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }


    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
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