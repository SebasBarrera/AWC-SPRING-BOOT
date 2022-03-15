package com.sebas.taller.service.sales;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

public class SalesterritoryServiceImp implements SalesterritoryService {
	
	@Autowired
	private SalesterritoryRepository sr;
	
	public SalesterritoryServiceImp(SalesterritoryRepository sr) {
		this.sr = sr;
	}

	@Override
	public Salesterritory save(Salesterritory s) {
		if (s != null) {
			sr.save(s);
		}
		return s;
	}

	@Override
	public Salesterritory update(Salesterritory s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salesterritory Search(Salesterritory s) {
		// TODO Auto-generated method stub
		return null;
	}

}
