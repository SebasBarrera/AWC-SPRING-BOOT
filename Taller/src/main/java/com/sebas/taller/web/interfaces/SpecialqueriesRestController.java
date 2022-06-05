package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

public interface SpecialqueriesRestController {
	
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces();
	public Iterable<Address> findAllAddresses();
	public Iterable<Integer> findAllAmounts(Integer id);

}
