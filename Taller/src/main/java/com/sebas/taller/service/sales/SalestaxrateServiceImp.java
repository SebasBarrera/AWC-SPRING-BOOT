package com.sebas.taller.service.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.repository.sales.SalestaxrateRepository;

@Service
public class SalestaxrateServiceImp implements SalestaxrateService{
	
	private SalestaxrateRepository sr;
	private StateprovinceRepository spr;
	
	@Autowired
	public SalestaxrateServiceImp(SalestaxrateRepository sr, StateprovinceRepository spr) {
		this.sr = sr;
		this.spr = spr;
	}

	@Override
	@Transactional
	public void save(Salestaxrate s) {
		if (s != null) {
			if (s.getStateprovince() != null) {
				
				if (spr.existsById(s.getStateprovince().getStateprovinceid())) {
					
					if ((s.getTaxrate() >= 0.0)
							&& s.getName().length() >= 5) {
					
						s.setStateprovince(spr.findById(s.getStateprovince().getStateprovinceid()).get());
						sr.save(s);
						
					} else {
						throw new IllegalArgumentException();
					}
						
				} else {
					throw new NullPointerException();
				}
				
			} else {
				throw new NullPointerException();
			}
			
		} else {
			throw new NullPointerException();
		}
		
	}

	@Override
	public Salestaxrate update(Salestaxrate s) {
		Salestaxrate real = null;
		if (s != null) {
			
			if (s.getStateprovince() != null) {
				
				if (spr.existsById(s.getStateprovince().getStateprovinceid())) {
					
					real = search(s);
					
					if ((s.getTaxrate() > 0.0)
							&& s.getName().length() >= 5) {
						
						real.setModifieddate(s.getModifieddate());
						real.setName(s.getName());
						real.setRowguid(s.getRowguid());
						real.setStateprovince(s.getStateprovince());
						real.setTaxrate(s.getTaxrate());
						real.setTaxtype(s.getTaxtype());
						
					} else {
						throw new IllegalArgumentException();
					}
					
				} else {
					throw new NullPointerException();
				}
				
			} else {
				throw new NullPointerException();
			}
			
		} else {
			throw new NullPointerException();
		}
		
		return real;
	}

	@Override
	public Salestaxrate search(Salestaxrate s) {
		Salestaxrate searched = null;
		if (sr.existsById(s.getSalestaxrateid())) {
			
			searched = sr.findById(s.getSalestaxrateid()).get();
			
		} else {
			throw new NullPointerException();
		}
		return searched;
	}

	@Override
	public Optional<Salestaxrate> findById(Integer id) {
		return sr.findById(id);
	}

	@Override
	public Iterable<Salestaxrate> findAll() {
		return sr.findAll();
	}

	@Override
	public void delete(Salestaxrate s) {
		sr.delete(s);
	}

}
