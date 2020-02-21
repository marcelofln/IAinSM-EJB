package com.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericoDAO<T> {

	private final static String UNIT_NAME = "IAinSmPU";

	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;

	private Class<T> entityClass;

	public GenericoDAO(Class<T> entityClass) {
		this.entityClass = entityClass;

	}

	public void save(T entity) {
		em.persist(entity);
	}

	public void delete(T entity) {
		T entityToBeRemoved = em.merge(entity);
		em.remove(entityToBeRemoved);
	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	// Usando Criteria
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings({ "unchecked" })
	protected List<T> findList(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			// Método que irá preencher os parâmetros, se eles ​​não estiverem
			// nulo ou vazios.
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro durante a execução da consulta: "
					+ e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	// Named Query generica unico resultado
	@SuppressWarnings({ "unchecked" })
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			// Método que irá preencher os parâmetros, se eles ​​não estiverem
			// nulo ou vazios.
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("Erro durante a execução da consulta: "
					+ e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	private void populateQueryParameters(Query query,
			Map<String, Object> parameters) {

		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

}
