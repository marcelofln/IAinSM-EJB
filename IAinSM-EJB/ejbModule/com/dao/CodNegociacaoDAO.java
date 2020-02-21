package com.dao;

import javax.ejb.Stateless;


import java.util.HashMap;
import java.util.Map;
import com.model.CodNegociacao;

@Stateless
public class CodNegociacaoDAO extends GenericoDAO<CodNegociacao> {
	
	public CodNegociacaoDAO(){
		super(CodNegociacao.class);
	}
	
	public CodNegociacao findAllCodNegociacao(String codNegociacao){	
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codNegociacao", codNegociacao);
		return super.findOneResult(CodNegociacao.FIND_BY_COD_NEGOCIACAO, parameters);
	}
	
	

}
