package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="CodNegociacao.findAllCodNegociacao", query="select u from CodNegociacao u where u.codNegociacao = :codNegociacao")
@Entity
@Table(name="COD_NEGOCIACAO")
public class CodNegociacao {
	
	
	
	public static final String FIND_BY_COD_NEGOCIACAO = "CodNegociacao.findAllCodNegociacao";
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String codNegociacao;
	private String nomeEmpresa;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCodNegociacao() {
		return codNegociacao;
	}

	public void setCodNegociacao(String codNegociacao) {
		this.codNegociacao = codNegociacao;
	}
	
	
	@Override
	public int hashCode() {
	    return getId();
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof CodNegociacao) {
	        CodNegociacao codNegociacao = (CodNegociacao) obj;
	        return codNegociacao.getId() == getId();
	    }

	    return false;
	}
	

}
