package com.sebas.taller.service.person;



import com.sebas.taller.model.person.Address;

public interface AddressService {
	
	public Address save(Address a);
	public Address update(Address a);
	public Address search(Address a);
	public Address findById(Integer id);
	public Iterable<Address> findAll();
	public void delete(Address a);
	public Iterable<Address> specialFind();
	
}
