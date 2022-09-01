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



    @ManyToOne(optional = false)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @OneToMany(mappedBy = "corsi", orphanRemoval = true)
    private List<Capitolo> capitoli = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "corsi_tags",
            joinColumns = @JoinColumn(name = "corsi_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private List<Tag> tags = new ArrayList<>();

    @ManyToMany(mappedBy = "corsi")
    private List<Insegnanti> insegnantis = new ArrayList<>();

    @Column(name = "num_visual", nullable = false)
    private Long numVisual;

    public Long getNumVisual() {
        return numVisual;
    }

    public void setNumVisual(Long numVisual) {
        this.numVisual = numVisual;
    }

    public List<Insegnanti> getInsegnantis() {
        return insegnantis;
    }

    public void setInsegnantis(List<Insegnanti> insegnantis) {
        this.insegnantis = insegnantis;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public List<Capitolo> getCapitoli() {
        return capitoli;
    }

    public void setCapitoli(List<Capitolo> capitoli) {
        this.capitoli = capitoli;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

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