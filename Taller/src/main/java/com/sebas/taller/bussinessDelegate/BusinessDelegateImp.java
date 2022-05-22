package com.sebas.taller.bussinessDelegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Person;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

@Component
public class BusinessDelegateImp implements BusinessDelegate {

	private final static String URL = "http://localhost:8080/";
	private final static String ADDRESS_URL = URL + "/address";
	private final static String COUNTRYREGION_URL = URL + "/countryregion";
	private final static String SALESTAXRATE_URL = URL + "/salestaxrate";
	private final static String STATEPROVINCE_URL = URL + "/stateprovince";
	private final static String PERSON_URL = URL + "/person";
	private final static String EMPLOYEE_URL = URL + "/employee";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Override
	public List<Address> findAllAddress() {
		return Arrays.asList(restTemplate.getForObject(ADDRESS_URL, Address[].class));
	}

	@Override
	public List<Countryregion> findAllCountryregion() {
		return Arrays.asList(restTemplate.getForObject(COUNTRYREGION_URL, Countryregion[].class));
	}

	@Override
	public List<Salestaxrate> findAllSalestaxrate() {
		return Arrays.asList(restTemplate.getForObject(SALESTAXRATE_URL, Salestaxrate[].class));
	}

	@Override
	public List<Stateprovince> findAllStateprovince() {
		return Arrays.asList(restTemplate.getForObject(STATEPROVINCE_URL, Stateprovince[].class));
	}

	@Override
	public Address findAddressById(Integer id) {
		return restTemplate.getForObject(ADDRESS_URL + "/" + id, Address.class);
	}

	@Override
	public Countryregion findCountryregionById(Integer id) {
		return restTemplate.getForObject(COUNTRYREGION_URL + "/" + id, Countryregion.class);
	}

	@Override
	public Salestaxrate findSalestaxrateById(Integer id) {
		return restTemplate.getForObject(SALESTAXRATE_URL + "/" + id, Salestaxrate.class);
	}

	@Override
	public Stateprovince findStateprovinceById(Integer id) {
		return restTemplate.getForObject(STATEPROVINCE_URL + "/" + id, Stateprovince.class);
	}

	@Override
	public Address addAddress(Address a) {
		return restTemplate.postForObject(ADDRESS_URL, a, Address.class);
	}

	@Override
	public Countryregion addCountryregion(Countryregion c) {
		return restTemplate.postForObject(COUNTRYREGION_URL, c, Countryregion.class);
	}

	@Override
	public Salestaxrate addSalestaxrate(Salestaxrate s) {
		return restTemplate.postForObject(SALESTAXRATE_URL, s, Salestaxrate.class);
	}

	@Override
	public Stateprovince addStateprovince(Stateprovince s) {
		return restTemplate.postForObject(STATEPROVINCE_URL, s, Stateprovince.class);
	}

	@Override
	public void updateAddress(Address a) {
		restTemplate.put(ADDRESS_URL, a);
	}

	@Override
	public void updateCountryregion(Countryregion c) {
		restTemplate.put(COUNTRYREGION_URL, c);
	}

	@Override
	public void updateSalestaxrate(Salestaxrate s) {
		restTemplate.put(SALESTAXRATE_URL, s);
	}

	@Override
	public void updateStateprovince(Stateprovince s) {
		restTemplate.put(STATEPROVINCE_URL, s);
	}

	@Override
	public void deleteAddress(Integer id) {
		restTemplate.delete(ADDRESS_URL, Integer.class);
	}

	@Override
	public void deleteCountryregion(Integer id) {
		restTemplate.delete(COUNTRYREGION_URL, Integer.class);
	}

	@Override
	public void deleteSalestaxrate(Integer id) {
		restTemplate.delete(SALESTAXRATE_URL, Integer.class);
	}

	@Override
	public void deleteStateprovince(Integer id) {
		restTemplate.delete(STATEPROVINCE_URL, Integer.class);
	}

	@Override
	public List<Person> findAllPerson() {
		return Arrays.asList(restTemplate.getForObject(PERSON_URL, Person[].class));
	}

	@Override
	public List<Employee> findAllEmployee() {
		return Arrays.asList(restTemplate.getForObject(EMPLOYEE_URL, Employee[].class));
	}

	@Override
	public Person findPersonById(Integer id) {
		return restTemplate.getForObject(PERSON_URL + "/" + id, Person.class);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return restTemplate.getForObject(EMPLOYEE_URL + "/" + id, Employee.class);
	}

	@Override
	public Person addPerson(Person p) {
		return restTemplate.postForObject(PERSON_URL, p, Person.class);
	}

	@Override
	public Employee addEmployee(Employee e) {
		return restTemplate.postForObject(EMPLOYEE_URL, e, Employee.class);
	}

	@Override
	public void updatePerson(Person p) {
		restTemplate.put(PERSON_URL, p);
	}

	@Override
	public void updateEmployee(Employee e) {
		restTemplate.put(EMPLOYEE_URL, e);
	}

	@Override
	public void deletePerson(Integer id) {
		restTemplate.delete(PERSON_URL, Integer.class);
	}

	@Override
	public void deleteEmployee(Integer id) {
		restTemplate.delete(EMPLOYEE_URL, Integer.class);
	}

}
