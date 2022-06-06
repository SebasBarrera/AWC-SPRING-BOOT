package com.sebas.taller.service.sales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.SalestaxrateDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.sales.Salestaxrate;

@Service
public class SalestaxrateServiceImp implements SalestaxrateService{
	
	private SalestaxrateDao salestaxrateDao;
	private StateprovinceDao stateprovinceDao;
	
	@Autowired
	public SalestaxrateServiceImp(SalestaxrateDao sr, StateprovinceDao spr) {
		this.salestaxrateDao = sr;
		this.stateprovinceDao = spr;
	}

	@Override
	@Transactional
	public void save(Salestaxrate s) {
		if (s != null) {
			if (s.getStateprovince() != null) {
				
				if (stateprovinceDao.existsById(s.getStateprovince().getStateprovinceid())) {
					
					if ((s.getTaxrate() >= 0.0)
							&& s.getName().length() >= 5) {
					
						s.setStateprovince(stateprovinceDao.findById(s.getStateprovince().getStateprovinceid()));
						salestaxrateDao.save(s);
						
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
				
				if (stateprovinceDao.existsById(s.getStateprovince().getStateprovinceid())) {
					
					real = search(s);
					
					if ((s.getTaxrate() > 0.0)
							&& s.getName().length() >= 5) {
						
						real.setModifieddate(s.getModifieddate());
						real.setName(s.getName());
						real.setRowguid(s.getRowguid());
						real.setStateprovince(s.getStateprovince());
						real.setTaxrate(s.getTaxrate());
						real.setTaxtype(s.getTaxtype());
						
						salestaxrateDao.update(real);
						
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
		if (salestaxrateDao.existsById(s.getSalestaxrateid())) {
			
			searched = salestaxrateDao.findById(s.getSalestaxrateid());
			
		} else {
			throw new NullPointerException();
		}
		return searched;
	}

	@Override
	public Salestaxrate findById(Integer id) {
		return salestaxrateDao.findById(id);
	}

	@Override
	public Iterable<Salestaxrate> findAll() {
		return salestaxrateDao.findAll();
	}

	@Override
	public void delete(Salestaxrate s) {
		salestaxrateDao.delete(s);
	}

}
