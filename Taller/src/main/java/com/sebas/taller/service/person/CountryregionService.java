package com.sebas.taller.service.person;


import com.sebas.taller.model.person.Countryregion;

public interface CountryregionService {

	public Countryregion save(Countryregion c);
	public Countryregion update(Countryregion c);
	public Countryregion search(Countryregion c);
	public Countryregion findById(Integer id);
	public Iterable<Countryregion> findAll();
	public void delete(Countryregion c);
}
