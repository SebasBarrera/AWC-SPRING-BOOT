package com.sebas.taller.service.person;

import java.util.Optional;

import com.sebas.taller.model.person.Countryregion;

public interface CountryregionService {

	public Countryregion save(Countryregion c);
	public Countryregion update(Countryregion c);
	public Countryregion search(Countryregion c);
	public Optional<Countryregion> findById();
	public Iterable<Countryregion> findAll();
	public void delete(Countryregion c);
}
