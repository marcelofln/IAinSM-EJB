package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.RegraNomeDAO;
import com.model.RegraNome;

@Stateless
public class RegraNomeFacadeImpl  implements RegraNomeFacade{

	@EJB
	private RegraNomeDAO regraNomeDAO;
	
	
	
	@Override
	public RegraNome update(RegraNome regraNome) {
			isRegraNomeAllData(regraNome);
			return regraNomeDAO.update(regraNome);
	}

	@Override
	public RegraNome find(int entityID) {
		return regraNomeDAO.find(entityID);
	}

	@Override
	public RegraNome findAllRegraNome(String regraNome) {
		return regraNomeDAO.findAllRegraNome(regraNome);
	}

	@Override
	public List<RegraNome> findRegraByEmail(String email) {		
		return regraNomeDAO.findRegraByEmail(email);
	}
	
	@Override
	public List<RegraNome> findAll() {
		return regraNomeDAO.findAll();
	}

	private void isRegraNomeAllData(RegraNome regraNome) {
		boolean hasError = false;

		if (regraNome == null) {
			hasError = true;
		}

		if (regraNome.getNomeRegra() == null
				|| "".equals(regraNome.getNomeRegra().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"Esta faltando dados para cadastro Nome da Regra.");
		}

	}

	@Override
	public void delete(RegraNome regraNome) {
		regraNomeDAO.delete(regraNome);
		
	}






	
	
	
}
