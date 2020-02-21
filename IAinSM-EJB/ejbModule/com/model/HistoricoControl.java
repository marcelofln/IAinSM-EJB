package com.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@NamedQuery(name="HistoricoControl.findAllControle", query="select u from HistoricoControl u where u.nome_Arquivo = :nome_Arquivo")
@Entity
@Table(name = "CONTROLE_HISTORICO")
public class HistoricoControl {

	public static final String FIND_BY_CONTROLE = "HistoricoControl.findAllControle";

	private int tipreg;
	private String nome_Arquivo;
	private String nome_user_Control;
	private String cod_Origem;
	private String data_Geracao;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getTipreg() {
		return tipreg;
	}

	public void setTipreg(int tipreg) {
		this.tipreg = tipreg;
	}

	public String getNome_Arquivo() {
		return nome_Arquivo;
	}

	public void setNome_Arquivo(String nome_Arquivo) {
		this.nome_Arquivo = nome_Arquivo;
	}
	
	public String getNome_user_Control() {
		return nome_user_Control;
	}

	public void setNome_user_Control(String nome_user_Control) {
		this.nome_user_Control = nome_user_Control;
	}

	public String getCod_Origem() {
		return cod_Origem;
	}

	public void setCod_Origem(String cod_Origem) {
		this.cod_Origem = cod_Origem;
	}

	public String getData_Geracao() {
		return data_Geracao;
	}

	public void setData_Geracao(String data_Geracao) {
		this.data_Geracao = data_Geracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		return getId();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof HistoricoControl){
			HistoricoControl historicoControl = (HistoricoControl)  obj;
			return historicoControl.getNome_Arquivo().equals(getNome_Arquivo());
		}
		
		return false;
	}
	
	
	
	

}
