package com.sebas.taller.bussinessDelegate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

public class BusinessDelegateImp implements BusinessDelegate {

	private final static String URL = "http://localhost:8080/";
	private final static String ADDRESS_URL = URL + "/address";
	private final static String COUNTRYREGION_URL = URL + "/countryregion";
	private final static String SALESTAXRATE_URL = URL + "/salestaxrate";
	private final static String STATEPROVINCE_URL = URL + "/stateprovince";
	
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Override
	public ResponseEntity<Address[]> findAllAddress() {
		return restTemplate.getForEntity(ADDRESS_URL, Address[].class);
	}

	@Override
	public ResponseEntity<Countryregion[]> findAllCountryregion() {
		return restTemplate.getForEntity(COUNTRYREGION_URL, Countryregion[].class);
	}

	@Override
	public ResponseEntity<Salestaxrate[]> findAllSalestaxrate() {
		return restTemplate.getForEntity(SALESTAXRATE_URL, Salestaxrate[].class);
	}

	@Override
	public ResponseEntity<Stateprovince[]> findAllStateprovince() {
		return restTemplate.getForEntity(STATEPROVINCE_URL, Stateprovince[].class);
	}

	@Override
	public ResponseEntity<Address> findAddressById(Integer id) {
		return restTemplate.getForEntity(ADDRESS_URL + "/" + id, Address.class);
	}

	@Override
	public ResponseEntity<Countryregion> findCountryregionById(Integer id) {
		return restTemplate.getForEntity(COUNTRYREGION_URL + "/" + id, Countryregion.class);
	}

	@Override
	public ResponseEntity<Salestaxrate> findSalestaxrateById(Integer id) {
		return restTemplate.getForEntity(SALESTAXRATE_URL + "/" + id, Salestaxrate.class);
	}

	@Override
	public ResponseEntity<Stateprovince> findStateprovinceById(Integer id) {
		return restTemplate.getForEntity(STATEPROVINCE_URL + "/" + id, Stateprovince.class);
	}

	@Override
	public ResponseEntity<Address> addAddress(Address a) {
		return restTemplate.postForEntity(ADDRESS_URL, a, Address.class);
	}

	@Override
	public ResponseEntity<Countryregion> addCountryregion(Countryregion c) {
		return restTemplate.postForEntity(COUNTRYREGION_URL, c, Countryregion.class);
	}

	@Override
	public ResponseEntity<Salestaxrate> addSalestaxrate(Salestaxrate s) {
		return restTemplate.postForEntity(SALESTAXRATE_URL, s, Salestaxrate.class);
	}

	@Override
	public ResponseEntity<Stateprovince> addStateprovince(Stateprovince s) {
		return restTemplate.postForEntity(STATEPROVINCE_URL, s, Stateprovince.class);
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

}
