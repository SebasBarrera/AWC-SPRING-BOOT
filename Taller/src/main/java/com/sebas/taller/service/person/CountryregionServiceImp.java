package com.sebas.taller.service.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.model.person.Countryregion;

@Service
@Transactional
public class CountryregionServiceImp implements CountryregionService{

	private CountryregionDao countryregionDao;
	@Autowired
	public CountryregionServiceImp(CountryregionDao cr) {
		this.countryregionDao = cr;
	}
	
	@Override
	public Countryregion save(Countryregion c) {
		if (c != null) {
			
			if(c.getCountryregioncode().length() >= 1 && 
					c.getCountryregioncode().length() <= 4
					&& c.getName().length() >= 5) {
				countryregionDao.save(c);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return countryregionDao.findById(c.getCountryregionid());
	}

	@Override
	public Countryregion update(Countryregion c) {
		Countryregion real = null;
		if (c != null) {
			
			real = search(c);
			
			if (c.getCountryregioncode().length() >= 1 && 
					c.getCountryregioncode().length() <= 4
					&& c.getName().length() >= 5) {
				
				countryregionDao.update(c);
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
		if (countryregionDao.existsById(c.getCountryregionid())) {
			
			searched = countryregionDao.findById(c.getCountryregionid());
			
		} else {
			
			throw new NullPointerException();
			
		}
		return searched;
	}


	@Override
	public Iterable<Countryregion> findAll() {
		return countryregionDao.findAll();
	}

	@Override
	public void delete(Countryregion c) {
		countryregionDao.delete(c);
	}

	@Override
	public Countryregion findById(Integer id) {
		return countryregionDao.findById(id);
	}
	
	
}
