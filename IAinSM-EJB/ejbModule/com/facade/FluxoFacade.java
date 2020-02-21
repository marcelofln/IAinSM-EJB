package com.facade;

import java.util.List;
import javax.ejb.Local;
import com.model.Fluxo;


@Local
public interface FluxoFacade {
	
	public abstract void save(Fluxo excel);
	public abstract Fluxo update(Fluxo excel);
	public abstract void delete(Fluxo excel);
	public abstract Fluxo find(int entityID);
	public Fluxo findAllPapel(String papel);
	public abstract List<Fluxo> findAll();	

}
