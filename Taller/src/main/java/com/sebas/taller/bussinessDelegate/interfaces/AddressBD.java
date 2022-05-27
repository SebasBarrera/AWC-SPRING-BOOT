package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Address;

public interface AddressBD {

	public List<Address> findAllAddress();
	public Address findAddressById(Integer id);
	public Address addAddress(Address a);
	public void updateAddress(Address a);
	public void deleteAddress(Integer id);

}
