package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.person.Countryregion;

public interface CountryregionRestController {

	public Iterable<Countryregion> findAll();
	public Countryregion findById(Integer id);
	public void save(Countryregion c);
	public void update(Countryregion c, Integer id);
	public void delete(Integer id);
	
}
