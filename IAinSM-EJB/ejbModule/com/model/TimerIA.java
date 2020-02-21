package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TIMER")
@NamedQueries({
@NamedQuery(name = "TimerIA.findTimerByEmail", query = "select u from TimerIA u where u.emailIA = :emailIA"),
@NamedQuery(name = "TimerIA.findListTimerByEmail", query = "select u from TimerIA u where u.emailIA = :emailIA")
})
public class TimerIA {

	public static final String FIND_TIMER_BY_EMAIL = "TimerIA.findTimerByEmail";
	public static final String FIND_LIST_TIMER_BY_EMAIL = "TimerIA.findListTimerByEmail";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String emailIA;	

	private boolean estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInicial;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFinal;
	
	public Date getDateInicial() {
		return dateInicial;
	}

	public void setDateInicial(Date dateInicial) {
		this.dateInicial = dateInicial;
	}

	public Date getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(Date dateFinal) {
		this.dateFinal = dateFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailIA() {
		return emailIA;
	}

	public void setEmailIA(String emailIA) {
		this.emailIA = emailIA;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TimerIA) {
			TimerIA timer = (TimerIA) obj;
			return timer.getEmailIA().equals(getEmailIA());
		}

		return false;
	}



}
