package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Stateprovince;

@Repository
@Transactional
@Scope("singleton")
public class StateprovinceDaoImp implements StateprovinceDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stateprovince save(Stateprovince s) {
		em.persist(s);
		return s;
	}

	@Override
	public Stateprovince update(Stateprovince s) {
		em.merge(s);
		return s;
	}

	@Override
	public void delete(Stateprovince s) {
		em.remove(s);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stateprovince> findAll() {
		String query = "SELECT s FROM Stateprovince s";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Stateprovince findById(Integer stateprovinceId) {
		return em.find(Stateprovince.class, stateprovinceId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stateprovince> findByCountryregionId(Integer id) {
		String jpql = "SELECT s FROM Stateprovince s, Countryregion c WHERE s MEMBER OF c.stateprovinces AND c.countryregionid=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stateprovince> findByTerritoryId(Integer id) {
		String jpql = "SELECT s FROM Stateprovince s " +
				  "WHERE s.territoryid=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stateprovince> findByName(String name) {
		String jpql = "SELECT s FROM Stateprovince s " +
					  "WHERE s.name=:name";
		Query query = em.createQuery(jpql);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stateprovince> findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(Integer id) {
		String jpql = "SELECT s, COUNT(a) FROM Address a, Stateprovince s LEFT JOIN Salestaxrate st ON s.stateprovinceid=st.stateprovinceid WHERE s.territoryid=:id ORDER BY s.name";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
