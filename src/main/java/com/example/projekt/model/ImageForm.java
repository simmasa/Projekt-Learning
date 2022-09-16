package com.example.projekt.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageForm {

    private Integer id;

    private Insegnante insegnante;

    private MultipartFile contentMultipart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Insegnante getInsegnante() {
        return insegnante;
    }

    public void setInsegnante(Insegnante insegnante) {
        this.insegnante = insegnante;
    }

    public MultipartFile getContentMultipart() {
        return contentMultipart;
    }

    public void setContentMultipart(MultipartFile contentMultipart) {
        this.contentMultipart = contentMultipart;
    }
}
