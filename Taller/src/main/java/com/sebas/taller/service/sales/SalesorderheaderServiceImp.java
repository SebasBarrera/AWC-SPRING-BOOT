package com.sebas.taller.service.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.model.sales.Salesorderheader;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesorderheaderRepository;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@Service
public class SalesorderheaderServiceImp implements SalesorderheaderService {
	
	@Autowired
	private SalesorderheaderRepository sr;
	
	public SalesorderheaderServiceImp(SalesorderheaderRepository sr) {
		this.sr = sr;
	}

	@Override
	public Salesorderheader save(Salesorderheader s) {
		
			sr.save(s);
		
		return s;
	}

	@Override
	public Salesorderheader update(Salesorderheader s) {
		sr.save(s);
		return null;
	}

	@Override
	public Salesorderheader Search(Salesorderheader s) {
		return sr.findById(s.getSalesorderid()).get();
	}

	@Override
	public Optional<Salesorderheader> findById(Integer id) {
		return sr.findById(id);
	}

	@Override
	public Iterable<Salesorderheader> findAll() {
		return sr.findAll();
	}

	@Override
	public void delete(Salesorderheader s) {
		sr.delete(s);
	}

}
