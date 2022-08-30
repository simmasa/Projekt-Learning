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

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @OneToMany(mappedBy = "corsi", orphanRemoval = true)
    private List<Capitolo> capitoli = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "insegnanti_id")
    private Insegnanti insegnanti;

    public Insegnanti getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Insegnanti insegnanti) {
        this.insegnanti = insegnanti;
    }

    public List<Capitolo> getCapitoli() {
        return capitoli;
    }

    public void setCapitoli(List<Capitolo> capitoli) {
        this.capitoli = capitoli;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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