package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sebas.taller.dao.interfaces.SalestaxrateDao;
import com.sebas.taller.model.sales.Salestaxrate;

@Repository
@Transactional
@Scope("singleton")
public class SalestaxrateDaoImp implements SalestaxrateDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Salestaxrate save(Salestaxrate s) {
		em.persist(s);
		return s;
	}

	@Override
	public Salestaxrate update(Salestaxrate s) {
		em.merge(s);
		return s;
	}

	@Override
	public void delete(Salestaxrate s) {
		em.remove(s);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Salestaxrate> findAll() {
		String query = "SELECT s FROM Salestaxrate s";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Salestaxrate findById(Integer salestaxrateId) {
		return em.find(Salestaxrate.class, salestaxrateId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Salestaxrate> findByStateprovinceId(Integer id) {
		String jpql = "SELECT s FROM Salestaxrate s LEFT JOIN Stateprovince sp ON s.stateprovinceid = sp.stateprovinceid WHERE sp.stateprovinceid=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Salestaxrate> findByName(String name) {
		String jpql = "SELECT s FROM Salestaxrate s " +
				  "WHERE s.name=:name";
	Query query = em.createQuery(jpql);
	query.setParameter("name", name);
	return query.getResultList();
	}

}
