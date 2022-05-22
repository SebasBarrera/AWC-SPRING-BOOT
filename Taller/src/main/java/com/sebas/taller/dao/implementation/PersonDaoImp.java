package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sebas.taller.dao.interfaces.PersonDao;
import com.sebas.taller.model.person.Person;

@Repository
@Scope("singleton")
public class PersonDaoImp implements PersonDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Person save(Person p) {
		em.persist(p);
		return p;
	}

	@Override
	public Person update(Person p) {
		em.merge(p);
		return p;
	}

	@Override
	public void delete(Person p) {
		em.remove(p);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		String query = "SELECT p FROM Person p";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Person findById(Integer personId) {
		return em.find(Person.class, personId);
	}

	@Override
	public boolean existsById(Integer personId) {
		if (em.find(Person.class, personId) != null)
			return true;
		return false;
	}

}
