package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.RegraNome;

@Stateless
public class RegraNomeDAO extends GenericoDAO<RegraNome>{

	public RegraNomeDAO(){
		super(RegraNome.class);
	}
	
	public RegraNome findAllRegraNome(String regraNome){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("regraNome", regraNome);
		return super.findOneResult(RegraNome.FIND_BY_REGRA_NOME, parameters);
	}
	
	public List<RegraNome> findRegraByEmail(String email){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findList(RegraNome.FIND_REGRA_BY_EMAIL, parameters);
		
		
	}
	
	
	
}
