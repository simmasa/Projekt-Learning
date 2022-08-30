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

    @Column(name = "desc")
    private String desc;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @ManyToOne
    @JoinColumn(name = "corsi_id")
    private Corsi corsi;

    public Corsi getCorsi() {
        return corsi;
    }

    public void setCorsi(Corsi corsi) {
        this.corsi = corsi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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