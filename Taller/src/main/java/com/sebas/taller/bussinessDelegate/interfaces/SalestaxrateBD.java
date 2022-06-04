package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateBD {
	public List<Salestaxrate> findAllSalestaxrate();
	public Salestaxrate findSalestaxrateById(Integer id);
	public Salestaxrate addSalestaxrate(Salestaxrate s);
	public Salestaxrate updateSalestaxrate(Salestaxrate s);
	public void deleteSalestaxrate(Integer id);
}
