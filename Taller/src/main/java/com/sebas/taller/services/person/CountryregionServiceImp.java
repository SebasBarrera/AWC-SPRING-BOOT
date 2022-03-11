package com.sebas.taller.services.person;

import org.springframework.stereotype.Service;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.repositories.person.CountryregionRepository;

@Service
public class CountryregionServiceImp implements CountryregionService{

	private CountryregionRepository cr;
	
	public CountryregionServiceImp(CountryregionRepository cr) {
		this.cr = cr;
	}
	
	@Override
	public Countryregion save(Countryregion c) {
		if (c != null) {
			
			//if() TODO
		}
		return null;
	}
	@Override
	public Countryregion update(Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Countryregion search(Countryregion c) {
		Countryregion searched = null;
		if (cr.existsById(c.getCountryregioncode())) {
			
			searched = cr.findById(c.getCountryregioncode()).get();
			
		} else {
			
			throw new NullPointerException();
			
		}
		return searched;
	}
}
