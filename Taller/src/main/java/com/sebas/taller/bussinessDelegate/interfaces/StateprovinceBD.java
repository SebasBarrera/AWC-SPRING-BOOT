package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Stateprovince;

public interface StateprovinceBD {
	
	public List<Stateprovince> findAllStateprovince();
	public Stateprovince findStateprovinceById(Integer id);
	public Stateprovince addStateprovince(Stateprovince s);
	public void updateStateprovince(Stateprovince s);
	public void deleteStateprovince(Integer id);

}
