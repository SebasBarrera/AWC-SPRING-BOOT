package com.sebas.taller.services.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.repositories.person.AddressRepository;
import com.sebas.taller.repositories.person.StateprovinceRepository;

@Service
@Transactional
public class AddressServiceImp implements AddressService{
	
	private AddressRepository ar;
	private StateprovinceRepository sr;
	
	public AddressServiceImp(AddressRepository ar, StateprovinceRepository sr) {
		this.ar = ar;
		this.sr = sr;
	}

	@Override
	public Address save(Address a) {
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if (sr.existsById(a.getStateprovince().getStateprovinceid())) {
				
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
			
		} else {
			throw new NullPointerException();
		}
		
		return a;
	}

	@Override
	public Address update(Address a) {
		Address real = null;
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if ( sr.existsById(a.getStateprovince().getStateprovinceid()) ) {
					
					real = search(a);
					
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
						
					}
					
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new NullPointerException();
			
		}
		
		return real;
	}

	@Override
	public Address search(Address a) {
		Address searched = null;
		if (ar.existsById(a.getAddressid())) {
			
			searched = ar.findById(a.getAddressid()).get();
			
		} else {
			
			throw new NullPointerException();
			
		}
		
		return searched;
	}

	
}
