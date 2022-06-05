package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

public interface StateprovinceDao {
	public Stateprovince save(Stateprovince s);
	public Stateprovince update(Stateprovince s);
	public void delete (Stateprovince s);
	public List<Stateprovince> findAll();
	public Stateprovince findById(Integer stateprovinceId);
	public List<Stateprovince> findByCountryregionId(Integer id);
	public List<Stateprovince> findByTerritoryId(Integer id);
	public List<Stateprovince> findByName(String name);
	public boolean existsById(Integer id);
//	@SuppressWarnings("rawtypes")
	public List<Object[]> findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(Integer id);
}
