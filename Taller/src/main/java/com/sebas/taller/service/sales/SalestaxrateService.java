package com.sebas.taller.service.sales;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateService {
	
	public Salestaxrate save(Salestaxrate s);
	public Salestaxrate update(Salestaxrate s);
	public Salestaxrate search(Salestaxrate s);

}