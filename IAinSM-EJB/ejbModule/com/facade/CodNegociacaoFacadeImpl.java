package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CodNegociacaoDAO;
import com.model.CodNegociacao;

@Stateless
public class CodNegociacaoFacadeImpl implements CodNegociacaoFacade{

	@EJB
	private CodNegociacaoDAO codNegociacaoDAO;
	
	
	
	@Override
	public CodNegociacao find(int entityID) {
		return codNegociacaoDAO.find(entityID);
	}

	@Override
	public CodNegociacao findAllCodNegociacao(String codNegociacao) {
		return codNegociacaoDAO.findAllCodNegociacao(codNegociacao);
	}

	@Override
	public List<CodNegociacao> findAll() {
		return codNegociacaoDAO.findAll();
	}
	
	
}
