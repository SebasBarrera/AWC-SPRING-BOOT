package com.sebas.taller.service.person;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Address;

@Service

public class AddressServiceImp implements AddressService{
	
	
	private AddressDao ar;
	
	private StateprovinceDao sr;
	
	@Autowired
	public AddressServiceImp(AddressDao ar, StateprovinceDao sr) {
		this.ar = ar;
		this.sr = sr;
	}

	@Override
	@Transactional
	public Address save(Address a) {
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if (sr.existsById(a.getStateprovince().getStateprovinceid())) {
				
					if (a.getAddressline1() != null && a.getCity().length() >= 3 && 
							a.getPostalcode().length() == 6 && a.getPostalcode().chars().allMatch(Character::isDigit)) {
						
						a.setStateprovince(sr.findById(a.getStateprovince().getStateprovinceid()));
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
		
		return ar.findById(a.getAddressid());
	}

	@Override
	@Transactional
	public Address update(Address a) {
		Address real = null;
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if ( sr.existsById(a.getStateprovince().getStateprovinceid()) ) {
					
					real = search(a);
					
					if (a.getAddressline1() != null && a.getCity().length() >= 3 && a.getPostalcode().length() == 6
							 && a.getPostalcode().chars().allMatch(Character::isDigit)) {
						
						real.setStateprovince(sr.findById(a.getStateprovince().getStateprovinceid()));
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
			
		} else {
			throw new NullPointerException();
			
		}
		
		return real;
	}

	@Override
	public Address search(Address a) {
		Address searched = null;
		if (ar.existsById(a.getAddressid())) {
			
			searched = ar.findById(a.getAddressid());
			
		} else {
			
			throw new NullPointerException();
			
		}
		
		return searched;
	}

	@Override
	public Address findById(Integer id) {
		return ar.findById(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return ar.findAll();
	}

	@Override
	public void delete(Address a) {
		ar.delete(a);
		
	}

	
}
