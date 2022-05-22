package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.person.Stateprovince;

public interface StateprovinceRestController {

	public Iterable<Stateprovince> findAll();
	public Stateprovince findById(Integer id);
	public void save(Stateprovince s);
	public void update(Stateprovince s);
	public void delete(Integer id);
	
}
