package com.sebas.taller.service.person;

import java.util.Optional;

import com.sebas.taller.model.person.Address;

public interface AddressService {
	
	public Address save(Address a);
	public Address update(Address a);
	public Address search(Address a);
	public Optional<Address> findById(long id);
	public Iterable<Address> findAll();
	public void delete(Address a);
	
}
