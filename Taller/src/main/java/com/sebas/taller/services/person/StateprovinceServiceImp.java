package com.sebas.taller.services.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.repositories.person.CountryregionRepository;
import com.sebas.taller.repositories.person.StateprovinceRepository;
import com.sebas.taller.repositories.sales.SalesterritoryRepository;

@Service
@Transactional
public class StateprovinceServiceImp implements StateprovinceService {

	private StateprovinceRepository sr;
	private CountryregionRepository cr;
	private SalesterritoryRepository tr;
	
	@Autowired
	public StateprovinceServiceImp(StateprovinceRepository sr, CountryregionRepository cr, SalesterritoryRepository tr) {
		this.sr = sr;
		this.cr = cr;
		this.tr = tr;
	}

	@Override
	public Stateprovince save(Stateprovince s) {
		if (s != null) {
			
			if (s.getCountryregion() == null || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
				
			} else if (!cr.existsById(s.getCountryregion().getCountryregioncode())) {
				throw new NullPointerException();
				
			}
			
			if (s.getStateprovincecode().length() == 5 && s.getName().length() >= 5 &&
					/*(s.getIsonlystateprovinceflag().equals("Yes") || s.getIsonlystateprovinceflag().equals("No"))*/
					s.getIsonlystateprovinceflag().equals("Y/N")) {
				
				s.setCountryregion(cr.findById(s.getCountryregion().getCountryregioncode()).get());
				s.setTerritoryid(tr.findById(s.getTerritoryid()).get().getTerritoryid());
				
				sr.save(s);
				
				
			}
			
		}
		return search(s);
	}

	@Override
	public Stateprovince update(Stateprovince s) {
		Stateprovince real = null;
		if (s != null) {
			
			if (s.getCountryregion() == null || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
				
			} else if (!cr.existsById(s.getCountryregion().getCountryregioncode())) {
				throw new NullPointerException();
				
			}
			
			real = search(s);
			if (s.getStateprovincecode().length() == 5 && s.getName().length() >= 5 &&
					/*(s.getIsonlystateprovinceflag().equals("Yes") || s.getIsonlystateprovinceflag().equals("No"))*/
					s.getIsonlystateprovinceflag().equals("Y/N")) {
				
				real.setAddresses(s.getAddresses()); //TODO este address deberia asignarse por repositorio o así esta bien
				real.setCountryregion(cr.findById(s.getCountryregion().getCountryregioncode()).get());
				real.setIsonlystateprovinceflag(s.getIsonlystateprovinceflag());
				real.setModifieddate(s.getModifieddate());
				real.setName(s.getName());
				real.setRowguid(s.getRowguid());
				real.setStateprovincecode(s.getStateprovincecode());
				real.setTerritoryid(tr.findById(s.getTerritoryid()).get().getTerritoryid());
				
			} else {
				throw new IllegalArgumentException();
			}
		}
		return real;
	}

	@Override
	public Stateprovince search(Stateprovince s) {
		Stateprovince searched = null;
		if (sr.existsById(s.getStateprovinceid())) {
			
			searched = sr.findById(s.getStateprovinceid()).get();
			
		} else {
			
			throw new NullPointerException();
		}
		return searched;
	}
	
	
}
