package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.FluxoDAO;
import com.model.Fluxo;

@Stateless
public class FluxoFacadeImpl implements FluxoFacade {

	@EJB
	private FluxoDAO fluxoDAO;

	@Override
	public void save(Fluxo fluxo) {
		isFluxoWithAllData(fluxo);
		fluxoDAO.save(fluxo);

	}

	@Override
	public Fluxo update(Fluxo fluxo) {
		isFluxoWithAllData(fluxo);
		return fluxoDAO.update(fluxo);
	}

	@Override
	public void delete(Fluxo fluxo) {

	}

	@Override
	public Fluxo find(int entityID) {

		return null;
	}

	@Override
	public List<Fluxo> findAll() {		
		return fluxoDAO.findAll();
	}

	@Override
	public Fluxo findAllPapel(String papel) {
		return fluxoDAO.findAllPapel(papel);
	}
	
	private void isFluxoWithAllData(Fluxo fluxo) {
		boolean hasError = false;
		
		if(fluxo == null){
			hasError = true;
		}
		
		if(fluxo.getCod_negociacao()==null || "".equals(fluxo.getCod_negociacao().trim())){
			hasError = true;
		}
				
	
		if(hasError){
			throw new IllegalArgumentException("Esta faltando dados para cadastrar Fluxo.");
		}
	}

}
