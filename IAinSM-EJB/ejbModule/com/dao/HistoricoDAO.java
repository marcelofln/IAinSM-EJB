package com.dao;

import com.model.Historico;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;


@Stateless
public class HistoricoDAO extends GenericoDAO<Historico> {

	public HistoricoDAO(){
		super(Historico.class);
	}
	
	public Historico findAllPapelHist(String cod_negociacao){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("cod_negociacao", cod_negociacao);
		return super.findOneResult(Historico.FIND_BY_PAPEL_HIST, parameters);
	}
	


	
}
