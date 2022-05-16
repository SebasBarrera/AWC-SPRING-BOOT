package com.sebas.taller.service.sales;


import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateService {
	
	public void save(Salestaxrate s);
	public Salestaxrate update(Salestaxrate s);
	public Salestaxrate search(Salestaxrate s);
	public Salestaxrate findById(Integer id);
	public Iterable<Salestaxrate> findAll();
	public void delete(Salestaxrate s);
}
