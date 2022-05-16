package com.sebas.taller.service.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.model.person.Countryregion;

@Service
@Transactional
public class CountryregionServiceImp implements CountryregionService{

	private CountryregionDao cr;
	@Autowired
	public CountryregionServiceImp(CountryregionDao cr) {
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
		return cr.findById(c.getCountryregionid());
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
		if (cr.existsById(c.getCountryregionid())) {
			
			searched = cr.findById(c.getCountryregionid());
			
		} else {
			
			throw new NullPointerException();
			
		}
		return searched;
	}


	@Override
	public Iterable<Countryregion> findAll() {
		return cr.findAll();
	}

	@Override
	public void delete(Countryregion c) {
		cr.delete(c);
	}

	@Override
	public Countryregion findById(Integer id) {
		return cr.findById(id);
	}
	
	
}
