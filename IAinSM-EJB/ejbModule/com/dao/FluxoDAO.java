package com.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Fluxo;


@Stateless
public class FluxoDAO extends GenericoDAO<Fluxo> {
	
	public FluxoDAO(){
		super(Fluxo.class);
	}
	
	public Fluxo findAllPapel(String papel) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("papel", papel);
		return super.findOneResult(Fluxo.FIND_BY_PAPEL, parameters);
	}
	

}
