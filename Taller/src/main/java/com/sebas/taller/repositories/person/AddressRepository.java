package com.sebas.taller.repositories.person;

import org.springframework.data.repository.CrudRepository;

import com.sebas.taller.model.person.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
