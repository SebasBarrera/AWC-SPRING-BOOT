package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateRestController {

	public Iterable<Salestaxrate> findAll();
	public Salestaxrate findById(Integer id);
	public void save(Salestaxrate s);
	public void update(Salestaxrate s);
	public void delete(Integer id);
	
}
