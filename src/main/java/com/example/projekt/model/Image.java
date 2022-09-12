package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "content")
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "insegnante_id")
    private Insegnante insegnante;

    public Insegnante getInsegnante() {
        return insegnante;
    }

    public void setInsegnante(Insegnante insegnante) {
        this.insegnante = insegnante;
    }


    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}