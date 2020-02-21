package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dao.RegraDAO;
import com.model.Regra;
import com.model.RegraPK;

@Stateless
public class RegraFacadeImpl implements RegraFacade {

	@EJB
	private RegraDAO regraDAO;

	private Regra regra;

	

	@Override
	public void delete(Regra regra) {
		regraDAO.delete(regra);

	}

	@Override
	public Regra update(Regra regra) {
		return regraDAO.update(regra);
	}

	@Override
	public Regra find(int entityID) {
		return regraDAO.find(entityID);
	}

	@Override
	public List<Regra> FindRegraListByEmail(String email_usuario) {
		return regraDAO.FindRegraListByEmail(email_usuario);
	}
	
	
	@Override
	public Regra findRegraByPK(RegraPK regraPK) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Hello");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Regra regra = em.find(Regra.class, regraPK);

			System.out.println(regra.getRegraPK().getNomeRegra().toString());

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			emf.close();
		}
		return regra;
	}

	
	@Override
	public List<Regra> findAll() {
		return regraDAO.findAll();
	}

	@Override
	public Regra findRegraByApelido(String apelido) {
		return regraDAO.findRegraByApelido(apelido);
	}

	

}
