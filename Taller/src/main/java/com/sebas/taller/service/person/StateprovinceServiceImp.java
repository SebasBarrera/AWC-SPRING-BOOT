package com.sebas.taller.service.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@Service
public class StateprovinceServiceImp implements StateprovinceService {

	private StateprovinceDao sr;
	private CountryregionDao cr;
	private SalesterritoryRepository tr;
	
	@Autowired
	public StateprovinceServiceImp(StateprovinceDao sr, CountryregionDao cr, SalesterritoryRepository tr) {
		this.sr = sr;
		this.cr = cr;
		this.tr = tr;
	}

	@Override
	@Transactional
	public Stateprovince save(Stateprovince s) {
		if (s != null) {
			
			if (s.getCountryregion() == null || s.getTerritoryid() == null) {
				throw new NullPointerException();
				
			} else if (!cr.existsById(s.getCountryregion().getCountryregionid()) || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
			}
			
			if (s.getStateprovincecode().length() == 5 && s.getName().length() >= 5 &&
					(s.getIsonlystateprovinceflag().equals("Y") || s.getIsonlystateprovinceflag().equals("N"))
					&& s.getStateprovincecode().chars().allMatch(Character::isDigit)) {
				
				s.setCountryregion(cr.findById(s.getCountryregion().getCountryregionid()));
				s.setTerritoryid(tr.findById(s.getTerritoryid()).get().getTerritoryid());
				
				sr.save(s);
				
				
			} else {
				throw new IllegalArgumentException();
			}
			
		} else {
			throw new NullPointerException();
		}
		return sr.findById(s.getStateprovinceid());
	}

	@Override
	@Transactional
	public Stateprovince update(Stateprovince s) {
		Stateprovince real = null;
		if (s != null) {
			
			if (s.getCountryregion() == null || s.getTerritoryid() == null) {
				throw new NullPointerException();
				
			} else if (!cr.existsById(s.getCountryregion().getCountryregionid()) || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
			}
			
			real = search(s);
			if (s.getStateprovincecode().length() == 5 && s.getName().length() >= 5 &&
					(s.getIsonlystateprovinceflag().equals("Y") || s.getIsonlystateprovinceflag().equals("N"))
					&& s.getStateprovincecode().chars().allMatch(Character::isDigit)) {
				
				sr.update(s);
				
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return real;
	}

	@Override
	public Stateprovince search(Stateprovince s) {
		Stateprovince searched = null;
		if (sr.existsById(s.getStateprovinceid())) {
			
			searched = sr.findById(s.getStateprovinceid());
			
		} else {
			
			throw new NullPointerException();
		}
		return searched;
	}

	@Override
	public Stateprovince findById(Integer id) {
		return sr.findById(id);
	}

	@Override
	public Iterable<Stateprovince> findAll() {
		return sr.findAll();
	}

	@Override
	public void delete(Stateprovince s) {
		sr.delete(s);
	}
	
	
}
