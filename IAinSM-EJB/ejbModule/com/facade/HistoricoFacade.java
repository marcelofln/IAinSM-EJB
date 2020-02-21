package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Historico;


@Local
public interface HistoricoFacade {
	
	public abstract Historico update(Historico historico);
	public abstract Historico find(int entityID);
	public Historico findAllPapelHist(String cod_negociacao);
	public abstract List<Historico> findAll();
	

}
