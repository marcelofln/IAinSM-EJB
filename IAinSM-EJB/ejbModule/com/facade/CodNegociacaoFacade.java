package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.CodNegociacao;


@Local
public interface CodNegociacaoFacade {

	public abstract CodNegociacao find(int entityID);
	public CodNegociacao findAllCodNegociacao(String codNegociacao);
	public abstract List<CodNegociacao> findAll();
	
}
