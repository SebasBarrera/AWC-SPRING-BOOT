package com.sebas.taller.services.person;

import org.springframework.stereotype.Service;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.repositories.person.CountryregionRepository;

@Service
public class CountryregionServiceImp implements CountryregionService{

	private CountryregionRepository crr;
	public CountryregionServiceImp(CountryregionRepository crr) {
		this.crr = crr;
	}
	@Override
	public Countryregion save(Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Countryregion update(Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Countryregion search(Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}
}
