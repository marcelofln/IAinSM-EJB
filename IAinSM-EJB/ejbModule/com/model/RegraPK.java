package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RegraPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 264590627819658309L;

	@Column
	private String nomeRegra;

	@Column
	private String codNegociacao;

	public RegraPK() {
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RegraPK)) {
			RegraPK regraPK = (RegraPK) obj;

			if (!regraPK.getNomeRegra().equals(nomeRegra)) {
				return false;
			}

			if (!regraPK.getCodNegociacao().equals(codNegociacao)) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return nomeRegra.hashCode() + codNegociacao.hashCode();

	}
	
	
	public String getNomeRegra() {
		return nomeRegra;
	}

	public void setNomeRegra(String nomeRegra) {
		this.nomeRegra = nomeRegra;
	}

	public String getCodNegociacao() {
		return codNegociacao;
	}

	public void setCodNegociacao(String codNegociacao) {
		this.codNegociacao = codNegociacao;
	}

}
