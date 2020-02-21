package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.HistoricoControl;

@Local
public interface HistoricoControlFacade {
	
	public abstract HistoricoControl update(HistoricoControl historicoControl);
	public abstract HistoricoControl find(int entityID);
	public HistoricoControl findAllControle(String nome_Arquivo);
	public abstract List<HistoricoControl> findAll();

}
