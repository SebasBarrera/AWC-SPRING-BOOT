package com.sebas.taller.web.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.StateprovinceAndAddresses;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.web.interfaces.SpecialqueriesRestController;

@RestController
@RequestMapping("/api/specialqueries")
public class SpecialqueriesRestControllerImp implements SpecialqueriesRestController {

	@Autowired
	private AddressService as;
	@Autowired
	private StateprovinceService ss;
	
	@Override
	@GetMapping("/stateprovince/1")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces1() {
		return ss.specialFind(1);
	}
	
	@Override
	@GetMapping("/stateprovince/2")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces2() {
		return ss.specialFind(2);
	}
	
	@Override
	@GetMapping("/stateprovince/3")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces3() {
		return ss.specialFind(3);
	}
	
	@Override
	@GetMapping("/stateprovince/4")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces4() {
		return ss.specialFind(4);
	}
	
	@Override
	@GetMapping("/stateprovince/5")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces5() {
		return ss.specialFind(5);
	}
	
	@Override
	@GetMapping("/amount/")
	public Iterable<Integer> findAllAmounts(Integer id) {
		return ss.specialFindAmount(id);
	}

	@Override
	@GetMapping("/address/")
	public Iterable<Address> findAllAddresses() {
		return as.specialFind();
	}

}
