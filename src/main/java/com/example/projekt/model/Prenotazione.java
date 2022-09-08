package com.example.projekt.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "prenotazioni", uniqueConstraints = {
		@UniqueConstraint(name = "uc_prenotazione", columnNames = {"data_prenotazione", "slot_orari", "insegnanti_id"})
})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


	@NotEmpty(message = "Devi inserire un email")
	@Column(name = "email_prenonato", nullable = false)
	private String emailPrenonato;

	@Column(name = "data_prenotazione", nullable = false)
	private Date dataPrenotazione;

	@Column(name = "slot_orari", nullable = false, length = 5)
	private String slotOrari;


    @ManyToOne(optional = false)
    @JoinColumn(name = "insegnanti_id", nullable = false)
    private Insegnante insegnanti;

    public Insegnante getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Insegnante insegnanti) {
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