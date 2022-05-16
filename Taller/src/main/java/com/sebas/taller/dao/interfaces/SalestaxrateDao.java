package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.sales.Salestaxrate;


public interface SalestaxrateDao {
	public Salestaxrate save(Salestaxrate s);
	public Salestaxrate update(Salestaxrate s);
	public void delete (Salestaxrate s);
	public List<Salestaxrate> findAll();
	public Salestaxrate findById(Integer id);
	public List<Salestaxrate> findByStateprovinceId(Integer id);
	public List<Salestaxrate> findByName(String name);
	public boolean existsById(Integer id);
}
