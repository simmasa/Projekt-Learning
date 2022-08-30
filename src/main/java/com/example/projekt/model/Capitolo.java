package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "capitolo")
public class Capitolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @Column(name = "numero_capitolo", nullable = false)
    private Integer numeroCapitolo;

    public Integer getNumeroCapitolo() {
        return numeroCapitolo;
    }

    public void setNumeroCapitolo(Integer numeroCapitolo) {
        this.numeroCapitolo = numeroCapitolo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descr) {
        this.descrizione = descr;
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