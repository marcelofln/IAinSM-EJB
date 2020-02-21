package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Regra;
import com.model.RegraPK;

@Local
public interface RegraFacade {

	public abstract void delete(Regra regra);
	public abstract Regra update(Regra regra);
	public abstract Regra find(int entityID);
	public Regra findRegraByPK(RegraPK regraPK);
	public Regra findRegraByApelido(String apelido);
	public abstract List<Regra> FindRegraListByEmail(String email_usuario);
	public abstract List<Regra> findAll();
	
	
}
