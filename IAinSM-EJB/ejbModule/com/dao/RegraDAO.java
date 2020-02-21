package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Regra;

@Stateless
public class RegraDAO extends GenericoDAO<Regra>{

	public RegraDAO(){
		super(Regra.class);
	}
	
	public Regra findRegraByApelido(String apelido){
		Map<String, Object>parameters = new HashMap<String, Object>();
		parameters.put("apelido", apelido);
		return super.findOneResult(Regra.FIND_REGRA_BY_APELIDO, parameters);
		
	}
	
	
	public List<Regra> FindRegraListByEmail(String email_usuario){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email_usuario", email_usuario);
		return super.findList(Regra.FIND_LIST_REGRA_BY_EMAIL, parameters);
		
	}
	
	
	
}
