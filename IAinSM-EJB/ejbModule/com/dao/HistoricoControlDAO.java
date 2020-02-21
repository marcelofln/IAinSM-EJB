package com.dao;

import com.model.HistoricoControl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;


@Stateless
public class HistoricoControlDAO extends GenericoDAO<HistoricoControl> {

	public HistoricoControlDAO(){
		super(HistoricoControl.class);
	}
	
	public HistoricoControl findAllControle(String nome_Arquivo){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome_Arquivo", nome_Arquivo);
		return super.findOneResult(HistoricoControl.FIND_BY_CONTROLE, parameters);	
	}
		
	
}
