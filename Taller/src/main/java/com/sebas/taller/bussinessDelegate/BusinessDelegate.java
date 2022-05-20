package com.sebas.taller.bussinessDelegate;

import org.springframework.http.ResponseEntity;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

public interface BusinessDelegate {

	public ResponseEntity<Address[]> findAllAddress();
	public ResponseEntity<Countryregion[]> findAllCountryregion();
	public ResponseEntity<Salestaxrate[]> findAllSalestaxrate();
	public ResponseEntity<Stateprovince[]> findAllStateprovince();
	
	public ResponseEntity<Address> findAddressById(Integer id);
	public ResponseEntity<Countryregion> findCountryregionById(Integer id);
	public ResponseEntity<Salestaxrate> findSalestaxrateById(Integer id);
	public ResponseEntity<Stateprovince> findStateprovinceById(Integer id);
	
	public ResponseEntity<Address> addAddress(Address a);
	public ResponseEntity<Countryregion> addCountryregion(Countryregion c);
	public ResponseEntity<Salestaxrate> addSalestaxrate(Salestaxrate s);
	public ResponseEntity<Stateprovince> addStateprovince(Stateprovince s);
	
	public void updateAddress(Address a);
	public void updateCountryregion(Countryregion c);
	public void updateSalestaxrate(Salestaxrate s);
	public void updateStateprovince(Stateprovince s);
	
	public void deleteAddress(Integer id);
	public void deleteCountryregion(Integer id);
	public void deleteSalestaxrate(Integer id);
	public void deleteStateprovince(Integer id);
	
	
}
