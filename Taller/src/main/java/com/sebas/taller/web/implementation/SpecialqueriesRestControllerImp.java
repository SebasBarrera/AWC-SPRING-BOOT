package com.sebas.taller.web.implementation;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
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
	@GetMapping("/stateprovince/")
	public Iterable<StateprovinceAndAddresses> findAllStateprovinces() {
//		Iterable<StateprovinceAndAddresses> al = ss.specialFind(1);
//		int counter = 0;
//		for (StateprovinceAndAddresses currentSpa : al) {
//			Stateprovince sp = currentSpa.getSp();
//			System.out.println(sp.getName() + currentSpa.getAddresses());
//			counter++;
//		}
//		System.out.println(counter);
		return ss.specialFind(1);
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
