package com.sebas.taller.service.sales;

import java.util.Optional;

import com.sebas.taller.model.sales.Salesterritory;

public interface SalesterritoryService {
	
	public Salesterritory save(Salesterritory s);
	public Salesterritory update(Salesterritory s);
	public Salesterritory Search(Salesterritory s);
	public Optional<Salesterritory> findById(Integer id);
	public Iterable<Salesterritory> findAll();
	public void delete(Salesterritory s);

}
