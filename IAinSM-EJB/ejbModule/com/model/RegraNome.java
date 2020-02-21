package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
@NamedQuery(name="RegraNome.findAllRegraNome", query="select u from RegraNome u where u.nomeRegra = :nomeRegra"),
@NamedQuery(name="RegraNome.findRegraByEmail", query="select u from RegraNome u where u.email = :email")
})

@Entity
@Table(name="REGRAS_NOME")
public class RegraNome {
	
	public static final String FIND_BY_REGRA_NOME = "RegraNome.findAllRegraNome";
	public static final String FIND_REGRA_BY_EMAIL = "RegraNome.findRegraByEmail";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nomeRegra;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRegra() {
		return nomeRegra;
	}

	public void setNomeRegra(String nomeRegra) {
		this.nomeRegra = nomeRegra;
	}
	
	@Override
	public int hashCode() {
	    return getId();
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof RegraNome) {
	        RegraNome regraNome = (RegraNome) obj;
	        return regraNome.getId() == getId();
	    }

	    return false;
	}
	
	@Override
	public String toString() {
		return nomeRegra;
	}
	
}
