package com.sebas.taller.service.person;


import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

public interface StateprovinceService {
	
	public Stateprovince save(Stateprovince s);
	public Stateprovince update(Stateprovince s);
	public Stateprovince search(Stateprovince s);
	public Stateprovince findById(Integer id);
	public Iterable<Stateprovince> findAll();
	public void delete(Stateprovince s);
	public Iterable<StateprovinceAndAddresses> specialFind(Integer id);
	public Iterable<Integer> specialFindAmount(Integer id);
}
