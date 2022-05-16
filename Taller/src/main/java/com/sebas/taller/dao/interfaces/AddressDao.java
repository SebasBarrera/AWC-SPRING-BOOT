package com.sebas.taller.dao.interfaces;

import java.util.List;

import com.sebas.taller.model.person.Address;

public interface AddressDao {
	public Address save(Address a);
	public Address update(Address a);
	public void delete (Address a);
	public List<Address> findAll();
	public Address findById(Integer id);
	public List<Address> findByStateprovinceId(Integer id);
	public List<Address> findByCity(String city);
	public List<Address> findByAtLeastTwoSalesorderheaders();
}
