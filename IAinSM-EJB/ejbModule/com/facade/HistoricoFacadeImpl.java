package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.HistoricoDAO;
import com.model.Historico;

@Stateless
public class HistoricoFacadeImpl implements HistoricoFacade {

	@EJB
	private HistoricoDAO historicoDAO;

	@Override
	public Historico update(Historico historico) {
		isHistoricoAllData(historico);
		return historicoDAO.update(historico);
	}

	@Override
	public Historico find(int entityID) {
		return historicoDAO.find(entityID);
	}

	@Override
	public Historico findAllPapelHist(String cod_negociacao) {
		return historicoDAO.findAllPapelHist(cod_negociacao);
	}

	@Override
	public List<Historico> findAll() {
		return historicoDAO.findAll();
	}
	

	

	private void isHistoricoAllData(Historico historico) {
		boolean hasError = false;

		if (historico == null) {
			hasError = true;
		}

		if (historico.getCod_negociacao() == null
				|| "".equals(historico.getCod_negociacao().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"Esta faltando dados para cadastro Historico.");
		}

	}

	

}
