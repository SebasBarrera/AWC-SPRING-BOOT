package com.sebas.taller.services.person;

import com.sebas.taller.repositories.person.StateprovinceRepository;

public class StateprovinceServiceImp implements StateprovinceService {

	private StateprovinceRepository spr;
	
	public StateprovinceServiceImp(StateprovinceRepository spr) {
		this.spr = spr;
	}
}
