package com.sebas.taller.service.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@Service
public class SalesterritoryServiceImp implements SalesterritoryService {
	
	@Autowired
	private SalesterritoryRepository sr;
	
	public SalesterritoryServiceImp(SalesterritoryRepository sr) {
		this.sr = sr;
	}

	@Override
	public Salesterritory save(Salesterritory s) {
		
			sr.save(s);
		
		return s;
	}

	@Override
	public Salesterritory update(Salesterritory s) {
		sr.save(s);
		return null;
	}

	@Override
	public Salesterritory Search(Salesterritory s) {
		return sr.findById(s.getTerritoryid()).get();
	}

	@Override
	public Optional<Salesterritory> findById(Integer id) {
		return sr.findById(id);
	}

	@Override
	public Iterable<Salesterritory> findAll() {
		return sr.findAll();
	}

	@Override
	public void delete(Salesterritory s) {
		sr.delete(s);
	}

}
