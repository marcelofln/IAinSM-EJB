package com.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
@NamedQuery(name="Regra.findRegraByApelido", query="select u from Regra u where u.apelido = :apelido"),
@NamedQuery(name="Regra.FindRegraListByEmail", query="select u from Regra u where u.email_usuario = :email_usuario")
})
@Entity
@Table(name = "REGRAS")
public class Regra {

	public static final String FIND_REGRA_BY_APELIDO = "Regra.findRegraByApelido";
	public static final String FIND_LIST_REGRA_BY_EMAIL = "Regra.FindRegraListByEmail";
	
	@EmbeddedId
	private RegraPK regraPK;

	private String email_usuario;
	private String apelido;
	private double stopGanho;
	private double stopPerda;
	private boolean perdaAutomatico;
	private boolean ganhoAutomatico;
	private double periodo;
	private boolean mValorCompra;
	private boolean nLimitePerda;
	private boolean nLimiteGanho;
	private boolean testarRegra;
	private double valorCompra;
	private double valorGanho;
	private double valorPerda;
	private boolean matchPerda;
	private boolean matchGanho;
	private double oferta;

	public double getOferta() {
		return oferta;
	}

	public void setOferta(double oferta) {
		this.oferta = oferta;
	}

	public boolean isMatchPerda() {
		return matchPerda;
	}

	public void setMatchPerda(boolean matchPerda) {
		this.matchPerda = matchPerda;
	}

	public boolean isMatchGanho() {
		return matchGanho;
	}

	public void setMatchGanho(boolean matchGanho) {
		this.matchGanho = matchGanho;
	}

	public double getValorGanho() {
		return valorGanho;
	}

	public void setValorGanho(double valorGanho) {
		this.valorGanho = valorGanho;
	}

	public double getValorPerda() {
		return valorPerda;
	}

	public void setValorPerda(double valorPerda) {
		this.valorPerda = valorPerda;
	}

	public RegraPK getRegraPK() {
		if(regraPK == null){
			regraPK = new RegraPK();
		}
		return regraPK;
	}

	public void setRegraPK(RegraPK regraPK) {
		this.regraPK = regraPK;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public double getStopGanho() {
		return stopGanho;
	}

	public void setStopGanho(double stopGanho) {
		this.stopGanho = stopGanho;
	}

	public double getStopPerda() {
		return stopPerda;
	}

	public void setStopPerda(double stopPerda) {
		this.stopPerda = stopPerda;
	}

	public double getPeriodo() {
		return periodo;
	}

	public void setPeriodo(double periodo) {
		this.periodo = periodo;
	}

	public boolean isPerdaAutomatico() {
		return perdaAutomatico;
	}

	public void setPerdaAutomatico(boolean perdaAutomatico) {
		this.perdaAutomatico = perdaAutomatico;
	}

	public boolean isGanhoAutomatico() {
		return ganhoAutomatico;
	}

	public void setGanhoAutomatico(boolean ganhoAutomatico) {
		this.ganhoAutomatico = ganhoAutomatico;
	}

	public boolean ismValorCompra() {
		return mValorCompra;
	}

	public void setmValorCompra(boolean mValorCompra) {
		this.mValorCompra = mValorCompra;
	}

	public boolean isnLimitePerda() {
		return nLimitePerda;
	}

	public void setnLimitePerda(boolean nLimitePerda) {
		this.nLimitePerda = nLimitePerda;
	}

	public boolean isnLimiteGanho() {
		return nLimiteGanho;
	}

	public void setnLimiteGanho(boolean nLimiteGanho) {
		this.nLimiteGanho = nLimiteGanho;
	}

	public boolean isTestarRegra() {
		return testarRegra;
	}

	public void setTestarRegra(boolean testarRegra) {
		this.testarRegra = testarRegra;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

}
