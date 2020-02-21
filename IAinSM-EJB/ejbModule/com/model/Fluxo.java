package com.model;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="BASE_SECUNDARIA")
@NamedQuery(name="Fluxo.findAllPapel", query="select u from Fluxo u where u.cod_negociacao = :cod_negociacao")
public class Fluxo {

public static final String FIND_BY_PAPEL = "Fluxo.findAllPapel";
	
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Temporal(TemporalType.TIMESTAMP)
private Date data_pregao;

private	String cod_negociacao;
private String nome_empresa;
private float preco_abertura;
private float preco_maximo;
private float preco_minimo;
private float preco_medio;
private float preco_melhor_oferta_compra;
private float preco_melhor_oferta_venda;
private float quantidade_negociada;
private float volume_total;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



public Date getData_pregao() {
	return data_pregao;
}
public void setData_pregao(Date data_pregao) {
	this.data_pregao = data_pregao;
}
public String getCod_negociacao() {
	return cod_negociacao;
}
public void setCod_negociacao(String cod_negociacao) {
	this.cod_negociacao = cod_negociacao;
}
public String getNome_empresa() {
	return nome_empresa;
}
public void setNome_empresa(String nome_empresa) {
	this.nome_empresa = nome_empresa;
}
public float getPreco_abertura() {
	return preco_abertura;
}
public void setPreco_abertura(float preco_abertura) {
	this.preco_abertura = preco_abertura;
}
public float getPreco_maximo() {
	return preco_maximo;
}
public void setPreco_maximo(float preco_maximo) {
	this.preco_maximo = preco_maximo;
}
public float getPreco_minimo() {
	return preco_minimo;
}
public void setPreco_minimo(float preco_minimo) {
	this.preco_minimo = preco_minimo;
}
public float getPreco_medio() {
	return preco_medio;
}
public void setPreco_medio(float preco_medio) {
	this.preco_medio = preco_medio;
}
public float getPreco_melhor_oferta_compra() {
	return preco_melhor_oferta_compra;
}
public void setPreco_melhor_oferta_compra(float preco_melhor_oferta_compra) {
	this.preco_melhor_oferta_compra = preco_melhor_oferta_compra;
}
public float getPreco_melhor_oferta_venda() {
	return preco_melhor_oferta_venda;
}
public void setPreco_melhor_oferta_venda(float preco_melhor_oferta_venda) {
	this.preco_melhor_oferta_venda = preco_melhor_oferta_venda;
}
public float getQuantidade_negociada() {
	return quantidade_negociada;
}
public void setQuantidade_negociada(float quantidade_negociada) {
	this.quantidade_negociada = quantidade_negociada;
}
public float getVolume_total() {
	return volume_total;
}
public void setVolume_total(float volume_total) {
	this.volume_total = volume_total;
}
@Override
public int hashCode() {
    return getId();
}

@Override
public boolean equals(Object obj) {
    if (obj instanceof Fluxo) {
        Fluxo fluxo = (Fluxo) obj;
        return fluxo.getId() == getId();
    }

    return false;
}




}
