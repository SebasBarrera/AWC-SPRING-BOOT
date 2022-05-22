package com.sebas.taller.web.interfaces;

import com.sebas.taller.model.person.Address;

public interface AddressRestController {
	
	public Iterable<Address> findAll();
	public Address findById(Integer id);
	public void save(Address a);
	public void update(Address a);
	public void delete(Integer id);

}
