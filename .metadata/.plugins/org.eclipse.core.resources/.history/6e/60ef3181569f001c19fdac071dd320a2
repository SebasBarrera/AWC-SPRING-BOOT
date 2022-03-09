package com.sebas.taller.services.person;

import org.springframework.stereotype.Service;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.repositories.person.AddressRepository;
import com.sebas.taller.repositories.person.StateprovinceRepository;

@Service
public class AddressServiceImp implements AddressService{
	
	private AddressRepository ar;
	private StateprovinceRepository sr;
	
	public AddressServiceImp(AddressRepository ar) {
		this.ar = ar;
	}

	@Override
	public Address save(Address a) {
		if (a != null) {
			if (a.getStateprovince() != null) {
				
				if (a.getAddressline1() != null && a.getCity().length() >= 3 && a.getPostalcode().length() >= 6) {
					
					a.setStateprovince(sr.findById(a.getStateprovince().getStateprovinceid()).get());
					ar.save(a);
					
				} else {
					throw new IllegalArgumentException();
				}
				
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new NullPointerException();
		}
		
		return a;
	}

	@Override
	public Address update(Address a) {
		if (a != null) {
			if (a.getStateprovince() != null) {
				Address real = search(a);
				if (a.getAddressline1() != null && a.getCity().length() >= 3 && a.getPostalcode().length() >= 6) {
					real.setStateprovince(sr.findById(a.getStateprovince().getStateprovinceid()).get());
					real.setAddressline1(a.getAddressline1());
					real.setAddressline2(a.getAddressline2());
					real.setBusinessentityaddresses(a.getBusinessentityaddresses());
					real.setCity(a.getCity());
					real.setModifieddate(a.getModifieddate());
					real.setPostalcode(a.getPostalcode());
					real.setRowguid(a.getRowguid());
					real.setSpatiallocation(a.getSpatiallocation());
					real.setStateprovince(a.getStateprovince());
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}

	@Override
	public Address search(Address a) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
