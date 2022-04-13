package com.sebas.taller.service.sales;

import java.util.Optional;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateService {
	
	public Salestaxrate save(Salestaxrate s);
	public Salestaxrate update(Salestaxrate s);
	public Salestaxrate search(Salestaxrate s);
	public Optional<Salestaxrate> findById(Integer id);
	public Iterable<Salestaxrate> findAll();
	public void delete(Salestaxrate s);
}
