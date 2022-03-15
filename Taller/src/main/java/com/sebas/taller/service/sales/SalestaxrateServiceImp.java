package com.sebas.taller.service.sales;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.repository.sales.SalestaxrateRepository;

@Service
@Transactional
public class SalestaxrateServiceImp implements SalestaxrateService{
	
	private SalestaxrateRepository sr;
	private StateprovinceRepository spr;
	
	@Autowired
	public SalestaxrateServiceImp(SalestaxrateRepository sr, StateprovinceRepository spr) {
		this.sr = sr;
		this.spr = spr;
	}

	@Override
	public Salestaxrate save(Salestaxrate s) {
		if (s != null) {
			if (s.getStateprovinceid() != null) {
				
				if (spr.existsById(s.getStateprovinceid())) {
					
					if ((s.getTaxrate().compareTo(new BigDecimal(0)) == 0 ||s.getTaxrate().compareTo(new BigDecimal(0)) == 1)
							&& s.getName().length() >= 5) {
					
						s.setStateprovinceid(s.getStateprovinceid());
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
		
		return s;
	}

	@Override
	public Salestaxrate update(Salestaxrate s) {
		Salestaxrate real = null;
		if (s != null) {
			
			if (s.getStateprovinceid() != null) {
				
				if (spr.existsById(s.getStateprovinceid())) {
					
					real = search(s);
					
					if ((s.getTaxrate().compareTo(new BigDecimal(0)) == 0 ||s.getTaxrate().compareTo(new BigDecimal(0)) == 1)
							&& s.getName().length() >= 5) {
						
						real.setModifieddate(s.getModifieddate());
						real.setName(s.getName());
						real.setRowguid(s.getRowguid());
						real.setStateprovinceid(spr.findById(s.getStateprovinceid()).get().getStateprovinceid());
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

}
