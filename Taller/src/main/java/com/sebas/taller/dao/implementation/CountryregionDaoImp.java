package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.model.person.Countryregion;

@Repository
@Transactional
@Scope("singleton")
public class CountryregionDaoImp implements CountryregionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Countryregion save(Countryregion c) {
		em.persist(c);
		return c;
	}

	@Override
	public Countryregion update(Countryregion c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Countryregion c) {
		em.remove(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Countryregion> findAll() {
		String query = "SELECT c FROM Countryregion c";
		return em.createQuery(query).getResultList();
	}


	@Override
	public Countryregion findById(Integer countryregionId) {
		return em.find(Countryregion.class, countryregionId);
	}

	@Override
	public boolean existsById(Integer id) {
		if (em.find(Countryregion.class, id) != null) {
			return true;
		}
		return false;
	}
}
