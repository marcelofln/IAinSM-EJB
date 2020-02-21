package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.RegraNome;

@Local
public interface RegraNomeFacade {
	
	public abstract void delete(RegraNome regraNome);
	public abstract RegraNome update(RegraNome regraNome);
	public abstract RegraNome find(int entityID);
	public RegraNome findAllRegraNome(String regraNome);
	public abstract List<RegraNome> findRegraByEmail(String email);
	public abstract List<RegraNome> findAll();

}
