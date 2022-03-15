package com.sebas.taller.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.repository.person.CountryregionRepository;

@Service
@Transactional
public class CountryregionServiceImp implements CountryregionService{

	private CountryregionRepository cr;
	
	@Autowired
	public CountryregionServiceImp(CountryregionRepository cr) {
		this.cr = cr;
	}
	
	@Override
	public Countryregion save(Countryregion c) {
		if (c != null) {
			
			if(c.getCountryregioncode().length() >= 1 && 
					c.getCountryregioncode().length() <= 4
					&& c.getName().length() >= 5) {
				cr.save(c);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return cr.findById(c.getCountryregioncode()).get();
	}
	@Override
	public Countryregion update(Countryregion c) {
		Countryregion real = null;
		if (c != null) {
			
			real = search(c);
			
			if (c.getCountryregioncode().length() >= 1 && 
					c.getCountryregioncode().length() <= 4
					&& c.getName().length() >= 5) {
				
				real.setCountryregioncode(c.getCountryregioncode());
				real.setModifieddate(c.getModifieddate());
				real.setName(c.getName());
				real.setStateprovinces(c.getStateprovinces());
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return real;
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
