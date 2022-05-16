package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.model.person.Address;

@Repository
@Transactional
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

	@SuppressWarnings("unchecked")
	@Override
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
	public List<Address> findByAtLeastTwoSalesorderheaders() {
		// no encontre la relacion entre Address y Salesorderheader
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		if (em.find(Address.class, id) != null) {
			return true;
		}
		return false;
	}
	
}
