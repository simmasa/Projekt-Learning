package com.example.projekt.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email_prenonato", nullable = false)
    private String emailPrenonato;

    @Column(name = "data_prenotazione", nullable = false)
    private Date dataPrenotazione;

    @Column(name = "slot_orari", nullable = false, length = 5)
    private String slotOrari;

    @ManyToOne(optional = false)
    @JoinColumn(name = "insegnanti_id", nullable = false)
    private Insegnanti insegnanti;

    public Insegnanti getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Insegnanti insegnanti) {
        this.insegnanti = insegnanti;
    }

    public String getSlotOrari() {
        return slotOrari;
    }

    public void setSlotOrari(String slotOrari) {
        this.slotOrari = slotOrari;
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public String getEmailPrenonato() {
        return emailPrenonato;
    }

    public void setEmailPrenonato(String emailPrenonato) {
        this.emailPrenonato = emailPrenonato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}