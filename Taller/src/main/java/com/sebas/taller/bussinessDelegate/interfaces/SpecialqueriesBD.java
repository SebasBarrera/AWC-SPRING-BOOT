package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

public interface SpecialqueriesBD {

	public List<StateprovinceAndAddresses> findSpecialStateprovinces1();
	public List<StateprovinceAndAddresses> findSpecialStateprovinces2();
	public List<StateprovinceAndAddresses> findSpecialStateprovinces3();
	public List<StateprovinceAndAddresses> findSpecialStateprovinces4();
	public List<StateprovinceAndAddresses> findSpecialStateprovinces5();

	public List<Address> findSpecialAddresses();

	public List<Integer> findspecialAmountAddressInStateprovince();

}
