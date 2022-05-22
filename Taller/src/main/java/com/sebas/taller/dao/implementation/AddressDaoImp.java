 package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.model.person.Address;

@Repository
@Scope("singleton")
public class AddressDaoImp implements AddressDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Address save(Address a) {
		em.persist(a);
		return a;
	}

	@Override
	public Address update(Address a) {
		em.merge(a);
		return a;
	}

	@Override
	public void delete(Address a) {
		em.remove(a);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> findAll() {
		String query = "SELECT a FROM Address a";
		return em.createQuery(query).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> findByStateprovinceId(Integer id) {
		String jpql = "SELECT a FROM Address a, Stateprovince s WHERE a MEMBER OF s.addresses AND s.stateprovinceid=:id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> findByCity(String city) {
		String jpql = "SELECT a FROM Address a " +
					  "WHERE a.city=:city";
		Query query = em.createQuery(jpql);
		query.setParameter("city", city);
		return query.getResultList();
	}

	@Override
	public Address findById(Integer addressId) {
		return em.find(Address.class, addressId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> findByAtLeastTwoSalesorderheaders() {
		String jpql = "SELECT a FROM Address a, Stateprovince s, Salesterritory t "
				+ "WHERE s.stateprovinceid=a.stateprovince.stateprovinceid "
				+ "AND t.territoryid=s.territoryid "
				+ "AND t.salesorderheaders.size >= 2";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public boolean existsById(Integer addressId) {
		if (em.find(Address.class, addressId) != null)
			return true;
		return false;
	}
	
}
