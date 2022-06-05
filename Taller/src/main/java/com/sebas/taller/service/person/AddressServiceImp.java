package com.sebas.taller.service.person;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Address;

@Service
@Transactional
public class AddressServiceImp implements AddressService{
	
	
	private AddressDao addressDao;
	
	private StateprovinceDao stateprovinceDao;
	
	@Autowired
	public AddressServiceImp(AddressDao ar, StateprovinceDao sr) {
		this.addressDao = ar;
		this.stateprovinceDao = sr;
	}

	@Override
	
	public Address save(Address a) {
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if (stateprovinceDao.existsById(a.getStateprovince().getStateprovinceid())) {
				
					if (a.getAddressline1() != null && a.getCity().length() >= 3 && 
							a.getPostalcode().length() == 6 && 
							a.getPostalcode().chars().allMatch(Character::isDigit)) {
						
						a.setStateprovince(stateprovinceDao.findById(a.getStateprovince().getStateprovinceid()));
						addressDao.save(a);
						
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
		
		return addressDao.findById(a.getAddressid());
	}

	@Override
	@Transactional
	public Address update(Address a) {
		Address real = null;
		if (a != null) {
			
			if (a.getStateprovince() != null) {
				
				if ( stateprovinceDao.existsById(a.getStateprovince().getStateprovinceid()) ) {
					
					real = search(a);
					
					if (a.getAddressline1() != null && a.getCity().length() >= 3 && a.getPostalcode().length() == 6
							 && a.getPostalcode().chars().allMatch(Character::isDigit)) {
						
						real.setStateprovince(stateprovinceDao.findById(a.getStateprovince().getStateprovinceid()));
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
		if (addressDao.existsById(a.getAddressid())) {
			
			searched = addressDao.findById(a.getAddressid());
			
		} else {
			
			throw new NullPointerException();
			
		}
		
		return searched;
	}

	@Override
	public Address findById(Integer id) {
		return addressDao.findById(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public void delete(Address a) {
		addressDao.delete(a);
	}

	@Override
	public Iterable<Address> specialFind() {
//		List<Address> al = addressDao.findByAtLeastTwoSalesorderheaders();
//		int counter = 0;
//		for (Address currentA : al) {
//			System.out.println(currentA.getCity());
//			counter++;
//		}
//		System.out.println(counter);
		return addressDao.findByAtLeastTwoSalesorderheaders();
	}

	
}
