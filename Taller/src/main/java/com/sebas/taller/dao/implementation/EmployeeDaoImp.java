package com.sebas.taller.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sebas.taller.dao.interfaces.EmployeeDao;
import com.sebas.taller.model.hr.Employee;

@Repository
@Scope("singleton")
public class EmployeeDaoImp implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Employee save(Employee e) {
		em.persist(e);
		return e;
	}

	@Override
	public Employee update(Employee e) {
		em.merge(e);
		return e;
	}

	@Override
	public void delete(Employee e) {
		em.remove(e);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		String query = "SELECT e FROM Employee e";
		return em.createQuery(query).getResultList();
	}

	@Override
	public Employee findById(Integer employeeId) {
		return em.find(Employee.class, employeeId);
	}

	@Override
	public boolean existsById(Integer employeeId) {
		if (em.find(Employee.class, employeeId) != null)
			return true;
		return false;
	}

}
