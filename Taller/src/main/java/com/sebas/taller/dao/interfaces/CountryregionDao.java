package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Countryregion;

public interface CountryregionDao {
	public Countryregion save(Countryregion c);
	public Countryregion update(Countryregion c);
	public void delete (Countryregion c);
	public List<Countryregion> findAll();
	public Countryregion findById(Integer id);
	public boolean existsById(Integer id);
}
