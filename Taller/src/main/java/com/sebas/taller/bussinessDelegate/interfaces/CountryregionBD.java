package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Countryregion;

public interface CountryregionBD {
	public List<Countryregion> findAllCountryregion();
	public Countryregion findCountryregionById(Integer id);
	public Countryregion addCountryregion(Countryregion c);
	public void updateCountryregion(Countryregion c);
	public void deleteCountryregion(Integer id);

}
