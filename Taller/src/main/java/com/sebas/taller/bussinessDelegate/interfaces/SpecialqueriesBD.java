package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

public interface SpecialqueriesBD {

	public List<StateprovinceAndAddresses> findSpecialStateprovinces();

	public List<Address> findSpecialAddresses();

	public List<Integer> findspecialAmountAddressInStateprovince();

}
