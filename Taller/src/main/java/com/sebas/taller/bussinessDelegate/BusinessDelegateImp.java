package com.sebas.taller.bussinessDelegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

@Component
public class BusinessDelegateImp implements BusinessDelegate {

	private final static String URL = "http://localhost:8080/";
	private final static String ADDRESS_URL = URL + "/address";
	private final static String COUNTRYREGION_URL = URL + "/countryregion";
	private final static String SALESTAXRATE_URL = URL + "/salestaxrate";
	private final static String STATEPROVINCE_URL = URL + "/stateprovince";
	
	
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

}
