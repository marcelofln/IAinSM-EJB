package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.HistoricoControlDAO;
import com.model.HistoricoControl;

@Stateless
public class HistoricoControlFacadeImpl implements HistoricoControlFacade {

	@EJB
	private HistoricoControlDAO historicoControlDAO;

	@Override
	public HistoricoControl update(HistoricoControl historicoControl) {
		isHistoricoControlAllData(historicoControl);
		return historicoControlDAO.update(historicoControl);
	}

	@Override
	public HistoricoControl find(int entityID) {

		return historicoControlDAO.find(entityID);
	}

	@Override
	public HistoricoControl findAllControle(String nome_Arquivo) {
		return historicoControlDAO.findAllControle(nome_Arquivo);
	}

	@Override
	public List<HistoricoControl> findAll() {
		return historicoControlDAO.findAll();
	}

	public void isHistoricoControlAllData(HistoricoControl historicoControl) {
		boolean hasError = false;

		if (historicoControl == null) {
			hasError = true;
		}

		if (historicoControl.getNome_Arquivo() == null
				|| "".equals(historicoControl.getNome_Arquivo().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"Esta Faltando dados para cadastro Historico Control");
		}
	}

}
