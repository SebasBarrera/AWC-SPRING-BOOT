package com.sebas.taller.services.person;

import org.springframework.stereotype.Service;

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.repositories.person.StateprovinceRepository;

@Service
public class StateprovinceServiceImp implements StateprovinceService {

	private StateprovinceRepository spr;
	
	public StateprovinceServiceImp(StateprovinceRepository spr) {
		this.spr = spr;
	}

	@Override
	public Stateprovince save(Stateprovince s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stateprovince update(Stateprovince s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stateprovince search(Stateprovince s) {
		// TODO Auto-generated method stub
		return null;
	}
}
