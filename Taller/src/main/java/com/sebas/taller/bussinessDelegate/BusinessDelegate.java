package com.sebas.taller.bussinessDelegate;

import java.util.List;

import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Person;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

public interface BusinessDelegate {

	public List<Address> findAllAddress();
	public List<Countryregion> findAllCountryregion();
	public List<Salestaxrate> findAllSalestaxrate();
	public List<Stateprovince> findAllStateprovince();
	public List<Person> findAllPerson();
	public List<Employee> findAllEmployee();
	
	public Address findAddressById(Integer id);
	public Countryregion findCountryregionById(Integer id);
	public Salestaxrate findSalestaxrateById(Integer id);
	public Stateprovince findStateprovinceById(Integer id);
	public Person findPersonById(Integer id);
	public Employee findEmployeeById(Integer id);
	
	public Address addAddress(Address a);
	public Countryregion addCountryregion(Countryregion c);
	public Salestaxrate addSalestaxrate(Salestaxrate s);
	public Stateprovince addStateprovince(Stateprovince s);
	public Person addPerson(Person p);
	public Employee addEmployee(Employee e);
	
	public void updateAddress(Address a);
	public void updateCountryregion(Countryregion c);
	public void updateSalestaxrate(Salestaxrate s);
	public void updateStateprovince(Stateprovince s);
	public void updatePerson(Person p);
	public void updateEmployee(Employee e);
	
	public void deleteAddress(Integer id);
	public void deleteCountryregion(Integer id);
	public void deleteSalestaxrate(Integer id);
	public void deleteStateprovince(Integer id);
	public void deletePerson(Integer id);
	public void deleteEmployee(Integer id);
	
}
