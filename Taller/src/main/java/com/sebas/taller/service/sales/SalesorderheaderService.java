package com.sebas.taller.service.sales;

import java.util.Optional;

import com.sebas.taller.model.sales.Salesorderheader;

public interface SalesorderheaderService {
	
	public Salesorderheader save(Salesorderheader s);
	public Salesorderheader update(Salesorderheader s);
	public Salesorderheader Search(Salesorderheader s);
	public Optional<Salesorderheader> findById(Integer id);
	public Iterable<Salesorderheader> findAll();
	public void delete(Salesorderheader s);

}
